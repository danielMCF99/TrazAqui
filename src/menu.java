/**
 * Classe Menu.
 *
 */
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
        TrazAqui t = new TrazAqui();
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
            System.out.print('\u000C');
            m.show_menu_Principal();
            System.out.print("Escolha uma opção: ");
            opçao1 = read.nextLine();
            isNumeric = opçao1.chars().allMatch(Character::isDigit);
            }while(!isNumeric || opçao1.length() < 1);
            choice1 = Integer.parseInt(opçao1);
            System.out.print("\n");
            switch(choice1) {
                case 1:
                    System.out.println("Escreva o seu mail: ");
                    String mail = read.nextLine();
                    System.out.println("Escreva a password: ");
                    String pass = read.nextLine();
                    boolean status = t.login(mail,pass);
                    if(status == true){
                        User u = t.getUser(mail);
                        if (u instanceof Voluntario){
                            show_menu_Voluntario();

                        }
                        else if (u instanceof Empresaentrega){
                            show_menu_EmpresaEntrega();
                        }
                        else if (u instanceof Cliente){
                            show_menu_Cliente();
                        }
                    }
                default:
                    System.out.println("Opção Inválida.\n");
                    show_menu_Principal();
                }

            }
        /*
        try{
            t.gravar_estado();
        }
        catch(FileNotFoundException e){
            System.out.println("Erro de Escrita: Ficheiro especificado não existe / não foi encontrado!");
        }
        catch(IOException e){
            System.out.println("Erro de Escrita: Erro ao aceder ao ficheiro!");
        }

        System.out.print('\u000C');
        System.exit(0);
        */
}
