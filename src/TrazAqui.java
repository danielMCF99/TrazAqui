import java.io.*;
import java.util.*;

public class TrazAqui implements Serializable{

        private Map<String,User> utilizadores; //HashMap para todos os users
        private Map<String,Encomenda> encomendas; //HashMap com todas as encomendas
        private Map<String,Encomenda> encaceites; //HashMap com todas as encomendas aceites
        private Map<String,List<String>> classpendentes;
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
            this.classpendentes = new HashMap<>();
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
            setUserlogado(null);
        }

        /**
         * Lê o ficheiro csv e faz o parse retornando o Objeto TrazAqui já populado com a informação que o ficheiro csv tiver
         * @param fileName
         * @return TrazAqui com a informação do ficheiro csv já parsed.
         */
        public static TrazAqui getDataFromBackupFile(String fileName,TrazAqui t) throws IOException {
            if(fileName == null) return null;
            List<String> dataString = t.readFromFile(fileName);
            for (String s : dataString){
                parseStringAndAddToData(t,s);
            }
            t.setUserlogado(null);
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
                case "Encomenda":
                    addEncomenda(trazAqui,typeString[1]);
                    break;
                case "Aceite":
                    addAceite(trazAqui,typeString[1]);
                    break;
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
        private static void addCliente(TrazAqui trazAqui, String string){
            String[] fields = string.split(",");
            if(fields.length == 4) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Cliente c = new Cliente(fields[0],fields[1],pos);
                trazAqui.addUser(c);
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
                trazAqui.addUser(v);
            }
        }

        /**
         * Adiciona o Empresa à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */
        private static void addTransportadora(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            if(fields.length == 7) {
                Coordenadas pos = new Coordenadas(Double.parseDouble(fields[2]),Double.parseDouble(fields[3]));
                Empresaentrega emp = new Empresaentrega(fields[0],fields[1],pos,fields[4],Double.parseDouble(fields[5]),Double.parseDouble(fields[6]));
                trazAqui.addUser(emp);
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
                trazAqui.addUser(l);
            }
        }

        /**
         * Adiciona o Encomenda à aplicação através dos parâmetros do ficheiro csv.
         * @param trazAqui
         * @param string
         */

        private static void addEncomenda(TrazAqui trazAqui, String string) {
            String[] fields = string.split(",");
            List<Produto> lista = new ArrayList<>();
            int i = 4;
            while ( i < fields.length){
                String cod = fields[i];
                i++;
                String des = fields[i];
                i++;
                double qtd = Double.parseDouble(fields[i]);
                i++;
                double price = Double.parseDouble(fields[i]);
                i++;
                Produto p = new Produto(cod,des,qtd,price);
                lista.add(p.clone());
            }
            Encomenda enc = new Encomenda(fields[0],fields[1],fields[2],Double.parseDouble(fields[3]),lista);
            trazAqui.addEnc(enc);
            User u = trazAqui.utilizadores.get(fields[1]).clone();
            if(u != null){
                Cliente c = (Cliente) u;
                c.addEnc(enc);
                trazAqui.updateUser(c);
            }

        }

        private static void addAceite(TrazAqui t, String string){
            //String[] fields = string.split(",");
            Encomenda enc = t.encomendas.get(string);
            Cliente c = (Cliente) t.utilizadores.get(enc.getReferenciaUti()).clone();
            Loja l = (Loja) t.utilizadores.get(enc.getReferenciaLoj()).clone();

            for(Map.Entry<String,User> entry : t.utilizadores.entrySet()){
                User u = entry.getValue().clone();
                if (u instanceof Voluntario) {
                    Voluntario v = (Voluntario) u;
                    if (v.getPosicao().distancia_Coordenadas(l.getPosicao()) <= v.getRaio_acao() && l.getPosicao().distancia_Coordenadas(c.getPosicao()) <= v.getRaio_acao()) {
                        v.addEnc(enc);
                        t.add_pend(enc.getReferenciaUti(),v.getUsername());
                        t.updateUser(v);
                        break;
                    }
                }
                else if (u instanceof Empresaentrega){
                    Empresaentrega e = (Empresaentrega) u;
                    if (e.getPosicao().distancia_Coordenadas(l.getPosicao()) <= e.getRaio() && l.getPosicao().distancia_Coordenadas(c.getPosicao()) <= e.getRaio()){
                        e.addEnc(enc);
                        t.add_pend(enc.getReferenciaUti(),e.getUsername());
                        t.updateUser(e);
                            break;
                    }
                }
            }
            t.addEncAceite(string);
        }

        public void addEncAceite(String ref){
            Encomenda e = this.encomendas.get(ref).clone();
            this.encaceites.put(e.getReferencia(),e);
        }

        public void addEnc(Encomenda e){
            encomendas.put(e.getReferencia(),e.clone());
        }


        public User getUser(String username){
            if (utilizadores.containsKey(username)) return utilizadores.get(username).clone();
            else return null;
        }

        /**
         * Adiciona um utilizador á aplicação
         *
         */
        public void addUser(User user){
            utilizadores.put(user.getUsername(),user.clone());
        }

        /**
         *  Metodo para dar update ao map dos users
         */
        public void updateUser (User user ) {
            utilizadores.put(user.getUsername(),user.clone());
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

        public void setUserlogado(User userlogado) {
            this.userlogado = userlogado;
        }

        public User getUserLogado(){
            return this.userlogado.clone();
        }

    /**
         * Faz login na aplicação confirmando o username e a password.
         * @param username
         * @param pass
         * @return true caso o login seja bem sucedido , false caso contrário.
         */
        public boolean login (String username, String pass) {
            boolean status = false;
            if(utilizadores.containsKey(username)){
                User aux = this.utilizadores.get(username);
                status = aux.getPassword().equals(pass);
                if(status) {
                    setUserlogado(aux);
                }
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
                FileInputStream fis = new FileInputStream("src/data.txt");
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

        /**
         * Guarda o estado num object file
         */
        public void saveState ( ) {
            try {
                FileOutputStream fos = new FileOutputStream("src/data.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this);
                System.out.println("Dados Gravados");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if(log != null)
                log.flushLog();
        }

        /**
         *  Adiciona a encomendas feitas por um utilizador ao seu histórico:
         * @param username  o código do utilizador
         */

        public Cliente add_enc_hist_util(String username){
            for (Encomenda p: this.encaceites.values()) {
                if (p.getReferenciaUti().equals(username)) {
                    Encomenda res = p.clone();
                    Cliente c = (Cliente) this.utilizadores.get(username).clone();
                    List<Encomenda> lista = new ArrayList<>(c.getHistorico());
                    lista.add(res);
                    c.setHistorico(lista);
                    return c;
                }
            }
            return null;
        }

        /**
         * Adiciona tudo na hashMap de utilizadores
        */
        public void atualiza(){
            for (Map.Entry<String,User> p :this.utilizadores.entrySet()){
                Cliente c = add_enc_hist_util(p.getKey());
                if (c!=null) {
                    updateUser(c);
                }
            }
        }

    public void show_encomendas_pendentes(String username) {
        List <Encomenda> lista1= new ArrayList<>();
        for(Map.Entry<String,Encomenda> e : this.encomendas.entrySet()){
            if(!this.encaceites.containsKey(e.getKey())){
                Encomenda enc = e.getValue();
                if (enc.getReferenciaUti().equals(username)) {
                    lista1.add(enc.clone());
                }
            }
        }
        if(lista1.size() == 0) {
            System.out.print("De momento não tem encomendas pendentes para visualizar \n");
        }
        else
        {
            System.out.println(lista1.toString());
        }
    }

    public void show_empresas(){
            for (User u : this.utilizadores.values()) {
                if (u instanceof Empresaentrega) {
                    System.out.println("Username: " + u.getUsername());
                    System.out.println("Nome: " + u.getNome());
                }
            }
    }

    public Empresaentrega getEmpresa(String username){
        Empresaentrega e= null;
        for(Map.Entry<String,User>p : this.utilizadores.entrySet()){
            if(p.getKey().equals(username)) {
                e = (Empresaentrega)p.getValue().clone();
                return e;
            }
        }
        return e;
    }

    public void show_voluntarios(){
        for (User u : this.utilizadores.values()) {
            if (u instanceof Voluntario) {
                System.out.println("Username: " + u.getUsername());
                System.out.println("Nome: " + u.getNome());
            }
        }
    }

    public Voluntario getVoluntario(String username){
        Voluntario v = null;
        for(Map.Entry<String,User>p : this.utilizadores.entrySet()){
            if(p.getKey().equals(username)) {
                v = (Voluntario) p.getValue().clone();
                return v;
            }
        }
        return v;
    }

    public void show_Lojas(){
        for (User u : this.utilizadores.values()){
            if (u instanceof Loja) {
                System.out.println("Username: " + u.getUsername() + " -> " + u.getNome() +"\n");
            }
        }
    }

    /**
     * Funçaõ para alterar a disponibilidade
     * @param u
     * @return
     */

    public User altera_disp(User u){
        if (u instanceof Voluntario){
            if (((Voluntario) u).getDisponivel()){
                ((Voluntario) u).setDisponivel(false);
            }else{
                ((Voluntario) u).setDisponivel(true);
            }
        }else if (u instanceof Empresaentrega){
            if (((Empresaentrega) u).getProntaReceber()){
                ((Empresaentrega) u).setProntaReceber(false);
            }else{
                ((Empresaentrega) u).setProntaReceber(true);
            }
        }
        updateUser(u);
        return u;
    }

    /**
     * Funçao para alterar o visto médico.
     * @param u
     * @return this.userlogado
     */

    public User altera_visto(User u){
        if (u instanceof Voluntario){
            if (((Voluntario) u).getVerificado()){
                ((Voluntario) u).setVerificado(false);
            }else{
                ((Voluntario) u).setVerificado(true);
            }
        }else if (u instanceof Empresaentrega){
            if (((Empresaentrega) u).getVistoMedico()){
                ((Empresaentrega) u).setVistoMedico(false);
            }else{
                ((Empresaentrega) u).setVistoMedico(true);
            }
        }
        updateUser(u);
        return u;
    }

    public void mostra_Enc_pendentes(){
        List <Encomenda> lista1 = new ArrayList<>();
        for(Map.Entry<String,Encomenda> e : this.encomendas.entrySet()){
            if(!this.encaceites.containsKey(e.getKey())){
                Encomenda enc = e.getValue();
                lista1.add(enc.clone());
            }
        }
        if(lista1.size() == 0) {
            System.out.print("De momento não tem encomendas pendentes para visualizar \n");
        }
        else
        {
            System.out.println(lista1.toString());
        }
    }

    public void add_pend(String uti, String cod){
            List<String> temp = this.classpendentes.get(uti);
            if(temp == null){
                temp = new ArrayList<>();
            }
            if(!temp.contains(cod)){
                temp.add(cod);
            }
            this.classpendentes.put(uti,temp);
    }

    public void remove_pend(String uti, String cod){
            List<String> temp = this.classpendentes.get(uti);
            for(String s : temp){
                if (s.equals(cod)){
                    temp.remove(s);
                    break;
                }
            }
            this.classpendentes.put(uti,temp);
    }


    public void aceitaEncomenda(Voluntario v, String codenc){
            Encomenda enc = this.encomendas.get(codenc).clone();
            if (enc == null){
                System.out.println("Nao existe essa encomenda.");
            }
            else{
                v.setDisponivel(false);
                String codLoja = enc.getReferenciaLoj();
                String codUti = enc.getReferenciaUti();
                Loja l = (Loja) this.utilizadores.get(codLoja).clone();
                Cliente c = (Cliente) this.utilizadores.get(codUti).clone();
                double distancia1 = v.getPosicao().distancia_Coordenadas(l.getPosicao());
                double distancia2 = l.getPosicao().distancia_Coordenadas(c.getPosicao());
                if (distancia1 > v.getRaio_acao() || distancia2 > v.getRaio_acao()){
                    System.out.println("Esta fora do seu raio de açao.");
                }
                else{
                    this.encaceites.put(enc.getReferencia(),enc.clone());
                    v.addEnc(enc);
                    c.addEnc(enc);
                    l.removeEncomenda(codenc);
                    add_pend(codUti,v.getUsername());
                }
            }
    }

    public List<String> get_classificoes_pendentes(String username){
        return this.classpendentes.get(username);
    }

    public void classificar(String username, double classificao){
            User u = this.utilizadores.get(username).clone();
            if (u == null){
                System.out.println("Nao escolheu um voluntario/empresa que esta por classificar.");
            }
            else{
                if (u instanceof Voluntario){
                    Voluntario v = (Voluntario) u;
                    v.updateClass(classificao);
                    remove_pend(this.userlogado.getUsername(),u.getUsername());
                }
                else if (u instanceof Empresaentrega){
                    Empresaentrega e = (Empresaentrega) u;
                    e.updateClass(classificao);
                    remove_pend(this.userlogado.getUsername(),u.getUsername());
                }
            }
    }

}
