/**
 * Classe Menu.
 *
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Set;

public class Menu {
    /**
     * Método que constrói o menu inicial para a interface do programa.
     *
     * @param
     * @return
     */
    public void show_menu_Principal() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    ||                                Menu TrazAqui                                 ||\n");
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    || Opções:                                                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        1 ---> Login                                                          ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        2 ---> Registar                                                       ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        3 ---> Top 10 Utilizadores(nº encomendas transp)                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        4 ---> Top 10 Empresas(nº de km)                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        0 ---> Sair                                                           ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    public void tipo_registo() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    ||                                Tipo de Registo                               ||\n");
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    || Opções:                                                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        1 ---> Voluntario                                                     ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        2 ---> Cliente                                                        ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        3 ---> Empresa de Entrega                                             ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        4 ---> Loja                                                           ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        0 ---> Voltar                                                         ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu inicial para a interface do programa.
     *
     * @param
     * @return
     */
    public void show_menu_Cliente() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    ||                         Menu TrazAqui - Cliente                              ||\n");
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    || Opções:                                                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        1 ---> Fazer encomenda                                                ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        2 ---> Ver histórico                                                  ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        3 ---> Ver Encomendas pendentes                                       ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        4 ---> Ver informação de Empresa                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        5 ---> Ver informação de Voluntário                                   ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        6 ---> Classificar Empresa/Voluntário                                 ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        7 ---> Entregas por aceitar                                           ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        8 ---> Logout                                                         ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu dos Voluntários.
     *
     * @param
     * @return
     */
    public void show_menu_Voluntario() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             ||                             Menu TrazAqui - Voluntário                                            ||\n");
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             || Opções:                                                                                           ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        1 ---> Disponivel para receber.                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        2 ---> Alterar Visto Médico                                                                ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        3 ---> Ver Encomendas pendentes                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        4 ---> Aceitar Encomenda                                                                   ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        5 ---> Logout.                                                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu das Empresas.
     *
     * @param
     * @return
     */
    public void show_menu_EmpresaEntrega() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             ||                       Menu TrazAqui - Empresa Entrega                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             || Opções:                                                                                           ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        1 ---> Disponivel para receber.                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        2 ---> Alterar visto médico                                                                ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        3 ---> Determinar preço de transporte de encomenda                                         ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        4 ---> Ver total faturado num periodo de tempo                                             ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        5 ---> Fazer entrega                                                                             ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        6 ---> Logout.                                                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que imprime o menu das lojas
     */
    public void show_menu_loja(){
        StringBuilder sb = new StringBuilder();
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    ||                                Menu TrazAqui - Loja                          ||\n");
        sb.append("                                                    ==================================================================================\n");
        sb.append("                                                    || Opções:                                                                      ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        1 ---> Alterar tempo de atendimento                                   ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        2 ---> Mostrar fila de espera                                         ||\n");
        sb.append("                                                    ||------------------------------------------------------------------------------||\n");
        sb.append("                                                    ||        0 ---> Logout                                                         ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }


    /**
     * Metodo para ver se uma string é um número
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Método que inicializa o programa JavaFatura.
     *
     * @param args
     * @return
     */
    public static void main(String[] args) {
        String opçao1;
        int choice;
        Scanner read = new Scanner(System.in);
        Menu m = new Menu();
        TrazAqui t = TrazAqui.recoverState();
        if (t == null) {
            try {
                t = TrazAqui.getDataFromBackupFile("src/dados.txt", t);
                t.setBackupDataRead();
            } catch (FileNotFoundException e) {
                t = new TrazAqui();
                System.out.println("Erro de Leitura: Ficheiro especificado não existe / não foi encontrado!");
            } catch (IOException e) {
                t = new TrazAqui();
                System.out.println("Erro de Leitura: Erro ao ler ficheiro de estado.");
            }
        }
        t.atualiza();

        do {
            do {
                m.show_menu_Principal();
                System.out.print("Escolha uma opção: ");
                opçao1 = read.nextLine();
            } while (!isNumeric(opçao1) || opçao1.length() < 1);

            choice = Integer.parseInt(opçao1);

            switch (choice) {
                case 1:
                    System.out.println("Escreva o seu username: ");
                    String mail = read.nextLine();
                    System.out.println("Escreva a password: ");
                    String pass = read.nextLine();
                    boolean status = t.login(mail, pass);
                    if (status) {
                        User u = t.getUser(mail);

                        if (u instanceof Cliente) {
                            t.setUserlogado(u);
                            Controlo.menu_cliente(t, u, m);
                        }
                        else if (u instanceof Voluntario){
                            t.setUserlogado(u);
                            Controlo.menu_voluntario(t, u, m);
                        }
                        else if (u instanceof Empresaentrega){
                            t.setUserlogado(u);
                            Controlo.menu_EmpresaEntrega(t,u,m);
                        }else if (u instanceof Loja){
                            t.setUserlogado(u);
                            Controlo.menu_Loja(t,u,m);
                        }
                    }
                    break;
                case 2:
                    Controlo.menu_registo(t,m);
                    break;

                case 3:
                    Set<User> s = t.top10_u();
                    int tam = 10;
                    for(User u : s){
                        if (tam > 0){
                            Voluntario v1 = u instanceof Voluntario ? (Voluntario) u : null;
                            Empresaentrega e1 = u instanceof Empresaentrega ? (Empresaentrega) u: null;
                            int s1 = v1 != null ? v1.getEntregas_feitas().size(): e1.getEncomendas().size();
                            System.out.println("Empresa: " + u.getNome() + " ----> Numero de encomendas: " + s1);
                            tam -= 1;
                        }
                    }
                    break;

                case 4:
                    tam = 10;
                    Set<Empresaentrega> se = t.top10_km();
                    for(Empresaentrega e : se){
                        if (tam > 0){
                            double dist = e.getDistancia();
                            System.out.println("Empresa: " + e.getNome() + " ----> Numero de km: " + dist);
                            tam -= 1;
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção Inválida.\n");
            }
        }while (choice != 0);

        System.out.println("A sair.");
        read.close();
        t.saveState();
        System.exit(0);
    }
}
