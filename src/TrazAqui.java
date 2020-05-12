import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class TrazAqui implements Serializable{

        private Map<String,User> utilizadores; //HashMap para todos os users
        private Map<String,Encomenda> encomendas; //HashMap com todas as encomendas
        private Map<String,Encomenda> encaceites; //HashMap com todas as encomendas aceites
        //Map<username,List<Double>> classifacoes
        private transient Logs log;
        private User userlogado = null;
        private boolean backupDataRead = false;

        /**
         * Construtor da TrazAqui
         */

        public TrazAqui(){
            this.utilizadores = new HashMap<>();
            this.encomendas = new HashMap<>();
            this.encaceites = new HashMap<>();
            initLog();
        }

        /**
         * Inicia o Log
         */
        public void initLog() {
            try{
                log = new Logs();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * Dá logout do utilizador
         */
        public void logout() {
            updateUser(this.userlogado);
            this.userlogado = null;
        }

        /**
         * Lê o ficheiro csv e faz o parse retornando o Objeto TrazAqui já populado com a informação que o ficheiro csv tiver
         * @param fileName
         * @return TrazAqui com a informação do ficheiro csv já parsed.
         */
        public static TrazAqui getDataFromBackupFile(String fileName,TrazAqui t) throws ClassNotFoundException, FileNotFoundException,IOException {
            if(fileName == null) return null;
            List<String> dataString = t.readFromFile(fileName);
            for (String s : dataString){
                parseStringAndAddToData(t,s);
            }
            return t;
        }

        /**
         * Dá parse da string tendo em conta o primeiro parâmetro do ficheiro csv
         * @param trazAqui
         * @param s
         */
        private static void parseStringAndAddToData(TrazAqui trazAqui, String s) {
            String[] typeString = s.split(":");
            switch(typeString[0]) {
                case "Utilizador":
                    addCliente(trazAqui,typeString[1]);
                    break;
                case "Voluntario":
                    addVoluntario(trazAqui,typeString[1]);
                    break;
                case "Loja":
                    addLoja(trazAqui,typeString[1]);
                    break;
                /*
                case "Encomenda":
                    addEncomenda(trazAqui,typeString[1]);
                    break;

                case "Aceite":
                    addAceite(trazAqui,typeString[1]);
                    break;
                 */
                case "Transportadora":
                    addTransportadora(trazAqui, typeString[1]);
                default:

                    break;
            }

        }

        /**
         * Adiciona o User à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        private static void addCliente(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            if(fields.length == 4) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Cliente c = new Cliente(fields[0],fields[1],pos);
                try {
                    trazAqui.addUser(c);
                } catch (utilizadorJaExiste e) {
                }
            }
        }

        /**
         * Adiciona o Voluntario à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        private static void addVoluntario(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            if(fields.length == 5) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Voluntario v = new Voluntario(fields[0],fields[1],pos,Double.parseDouble(fields[4]));
                try {
                    trazAqui.addUser(v);
                } catch (utilizadorJaExiste e) {
                }
            }
        }

        /**
         * Adiciona o Empresa à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        private static void addTransportadora(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            if(fields.length == 6) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Empresaentrega emp = new Empresaentrega(fields[0],fields[1],pos,fields[3],Double.parseDouble(fields[4]),Double.parseDouble(fields[5]));
                try {
                    trazAqui.addUser(emp);
                } catch (utilizadorJaExiste e) {
                }
            }
        }

        /**
         * Adiciona o Loja à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        private static void addLoja(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            if(fields.length == 4) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Loja l = new Loja(fields[0], fields[1],pos );
                try {
                    trazAqui.addUser(l);
                } catch (utilizadorJaExiste e) {
                }
            }
        }

        /*
         * Adiciona o Encomenda à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        /*
        private static void addEncomenda(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            List<Produto> lista = new ArrayList<>();
            Encomenda enc = new Encomenda();

            try {
                trazAqui.addEnc(v);
            } catch (utilizadorJaExiste e) {
            }

        }*/


        //Falta add para encomendas aceites

        public User getUser(String username){//} throws userInexistenteException{
            if (utilizadores.containsKey(username)) return utilizadores.get(username).clone();
            else return null;
        }

        /**
         * Adiciona um utilizador á aplicação
         *
         */
        public void addUser(User user) throws utilizadorJaExiste{
            utilizadores.put(user.getUsername(),user.clone());
            /*if(log != null){
                log.addToLogUser(user);
            }*/
        }

        /**
         *  Metodo para dar update ao map dos users
         */
        public void updateUser (User user ) {
            utilizadores.put(user.getUsername(),user.clone());
            userlogado = user;
        }

        /**
         * Verifica se já foi lida a data do ficheiro .bak
         * @return true se sim, falso se não
         */
        public boolean isBackupDataRead() {return this.backupDataRead;}

        /**
         * Mete a true se a data do ficheiro .bak já foi lida
         */
        public void setBackupDataRead() {this.backupDataRead = true;}

        /**
         * Verifica se há algum user logado
         * @return true, se sim, false se não
         */
        public boolean isUserLogado () {
            return (userlogado != null);
        }

        /**
         * Faz login na aplicação confirmando o username e a password.
         * @param username
         * @param pass
         * @return true caso o login seja bem sucedido , false caso contrário.
         */
        public boolean login (String username, String pass) {
            User utilizador = null;
            boolean status = false;
            if(utilizadores.containsKey(username)){
                User aux = this.utilizadores.get(username);
                status = aux.getPassword().equals(pass);
            }
            if(status) {
                userlogado = utilizador;
            }
            return status;
        }


        /**
         * Lê de um ficheiro para uma List<String>
         * @return List<String> que leu do ficheiro
         * @throws FileNotFoundException
         * @throws IOException
         */

        public List<String> readFromFile(String fileName) throws FileNotFoundException, IOException {
            List<String> linhas = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linha;
            while ((linha = br.readLine()) != null) linhas.add(linha);
            br.close();
            return linhas;
        }

    /**
     * Recupera o estado da aplicação
     * @return UMCarroJa
     */
    public static TrazAqui recoverState() {
        TrazAqui t = null;
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            t = (TrazAqui) ois.readObject();
            System.out.println("Dados Lidos");
        } catch (InvalidClassException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro de carregamento de dados não existe");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        if (t == null) t = new TrazAqui();
        else t.initLog();
        return t;
    }
}
