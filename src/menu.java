/**
 * Classe Menu.
 *
 */
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;

public class Menu {
    /**
     * Método que constrói o menu inicial para a interface do programa.
     *
     * @param
     * @return
     */
    private static void show_menu_Principal() {
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
        sb.append("                                                    ||        0 ---> Sair                                                           ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    private static void tipo_registo() {
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
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu inicial para a interface do programa.
     *
     * @param
     * @return
     */
    private static void show_menu_Cliente() {
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
        sb.append("                                                    ||        7 ---> Logout                                                         ||\n");
        sb.append("                                                    ==================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu dos Contribuintes Individuais que faz parte da interface do programa.
     *
     * @param
     * @return
     */
    private static void show_menu_Voluntario() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             ||                             Menu TrazAqui - Voluntário                                            ||\n");
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             || Opções:                                                                                           ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        1 ---> Disponivel para receber.                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        2 ---> Ver Encomendas pendentes                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        3 ---> Logout.                                                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que constrói o menu dos Contribuintes Coletivos / Empresas que faz parte da interface do programa.
     *
     * @param
     * @return
     */
    private static void show_menu_EmpresaEntrega() {
        StringBuilder sb = new StringBuilder();
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             ||                       Menu TrazAqui - Empresa Entrega                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        sb.append("                                             || Opções:                                                                                           ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        1 ---> Disponivel para receber.                                                            ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        2 ---> Determinar preço de transporte de encomenda                                         ||\n");
        sb.append("                                             ||---------------------------------------------------------------------------------------------------||\n");
        sb.append("                                             ||        3 ---> Logout.                                                                             ||\n");
        sb.append("                                             =======================================================================================================\n");
        System.out.print(sb);
    }

    /**
     * Método que inicializa o programa JavaFatura.
     *
     * @param args
     * @return
     */
    public static void main(String[] args) {
        String opçao1, opçao2, opçao3, opçao4, option;
        boolean isNumeric;
        int choice1, choice2, choice3, choice4, choice;
        Scanner read = new Scanner(System.in);
        Menu m = new Menu();
        TrazAqui t = TrazAqui.recoverState();

        try {
            t = TrazAqui.getDataFromBackupFile("src/dados.txt", t);
            t.setBackupDataRead();
        } catch (ClassNotFoundException e) {
            t = new TrazAqui();
            System.out.println("Erro de Leitura: Formato de ficheiro desconhecido.");
        } catch (FileNotFoundException e) {
            t = new TrazAqui();
            System.out.println("Erro de Leitura: Ficheiro especificado não existe / não foi encontrado!");
        } catch (IOException e) {
            t = new TrazAqui();
            System.out.println("Erro de Leitura: Erro ao ler ficheiro de estado.");
        }

        do {
            m.show_menu_Principal();
            System.out.print("Escolha uma opção: ");
            opçao1 = read.nextLine();
            isNumeric = opçao1.chars().allMatch(Character::isDigit);
        } while (!isNumeric || opçao1.length() < 1);
        choice1 = Integer.parseInt(opçao1);
        System.out.print("\n");
        switch (choice1) {
            case 1:
                System.out.println("Escreva o seu mail: ");
                String mail = read.nextLine();
                System.out.println("Escreva a password: ");
                String pass = read.nextLine();
                boolean status = t.login(mail, pass);
                if (status) {
                    User u = t.getUser(mail);
                    if (u instanceof Voluntario) {
                        show_menu_Voluntario();



                    } else if (u instanceof Empresaentrega) {
                        show_menu_EmpresaEntrega();
                    } else if (u instanceof Cliente) {
                        show_menu_Cliente();
                    }
                }
                break;


            case 2:
                String nome = "";
                tipo_registo();
                System.out.println("Escolha uma opção válida: ");
                opçao2 = read.nextLine();
                while(!Character.isDigit(opçao2.charAt(0)) || 4 < Integer.parseInt(opçao2) || Integer.parseInt(opçao2) < 1){
                    System.out.println("Escolha uma opção válida: ");
                    opçao2 = read.nextLine();
                }

                System.out.println("Qual o seu nome: ");
                nome = read.nextLine();

                System.out.println("Escreva o seu mail: ");
                mail = read.nextLine();

                System.out.println("Escreva a password: ");
                pass = read.nextLine();

                System.out.println("Diga a sua coordenada x: ");
                double x = read.nextDouble();
                read.nextLine();

                System.out.println("Diga a sua coordenada y: ");
                double y = read.nextDouble();
                read.nextLine();

                switch (Integer.parseInt(opçao2)){
                    case 1:
                        System.out.println("Diga o seu raio de ação: ");
                        double raio = read.nextDouble();
                        System.out.println("Faça uma estimativa da velocidade a que se vai deslocar: ");
                        double vel = read.nextDouble();
                        System.out.println("Tem verificação para transportar encomendas médicas(S ou N)? ");
                        String ver = read.nextLine().toUpperCase();
                        boolean visto = false;
                        if (ver.charAt(0) == 'S'){
                            visto = true;
                        }
                        Voluntario v = new Voluntario(nome,mail,pass,new Coordenadas(x,y),0,0,true,raio,vel,visto,new ArrayList<>(),new ArrayList<>());
                        t.addUser(v);
                        break;

                    case 2:
                        Cliente c = new Cliente(nome,mail,pass,new Coordenadas(x,y),new ArrayList<>());
                        t.addUser(c);
                        break;

                    case 3:
                        System.out.println("Diga o nif da empresa: ");
                        String nif = read.nextLine();
                        System.out.println("Taxa de custo por km: ");
                        double taxa = read.nextDouble();
                        System.out.println("Quantas encomendas pode transportar de uma vez: ");
                        int cap = read.nextInt();
                        System.out.println("Faça uma estimativa da velocidade a que se vai deslocar: ");
                        vel = read.nextDouble();
                        System.out.println("Diga o seu raio de ação: ");
                        raio = read.nextDouble();
                        System.out.println("Tem verificação para transportar encomendas médicas(S ou N)? ");
                        ver = read.nextLine().toUpperCase();
                        visto = false;
                        if (ver.charAt(0) == 'S'){
                            visto = true;
                        }
                        Empresaentrega emp = new Empresaentrega(nome,mail,pass,new Coordenadas(x,y),true,taxa,cap,vel,0,0,raio,visto,new ArrayList<>());
                        t.addUser(emp);
                        break;

                    case 4:
                        System.out.println("Diga o tempo de atendimento esperado: ");
                        double tempo = read.nextDouble();
                        Loja l = new Loja (nome,mail,pass,new Coordenadas(x,y),new ArrayList<>(),tempo);
                        break;
                }
                break;

            case 0:
                t.saveState();
                System.exit(0);
                break;

            default:
                System.out.println("Opção Inválida.\n");
                show_menu_Principal();
        }
    }
}
