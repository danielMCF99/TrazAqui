import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Controlo implements Serializable {


    public static void menu_registo(TrazAqui t, Menu m){
        Scanner read = new Scanner(System.in);
        String linha = "";
        int opcao = 0;

        do {
            m.tipo_registo();
            do {
                System.out.println("Escolha uma opção válida: ");
                linha = read.nextLine();
            } while (!Menu.isNumeric(linha) || linha.length() < 1);

            opcao = Integer.parseInt(linha);

            if (opcao != 0) {
                System.out.println("Qual o seu nome: ");
                String nome = read.nextLine();

                System.out.println("Escreva o seu username: ");
                String mail = read.nextLine();

                System.out.println("Escreva a password: ");
                String pass = read.nextLine();

                do {
                    System.out.println("Diga a sua coordenada x: ");
                    linha = read.nextLine();
                } while (!Menu.isNumeric(linha) || linha.length() < 1);

                double x = Double.parseDouble(linha);

                do {
                    System.out.println("Diga a sua coordenada y: ");
                    linha = read.nextLine();
                } while (!Menu.isNumeric(linha) || linha.length() < 1);

                double y = Double.parseDouble(linha);

                switch (opcao) {
                    case 1:
                        System.out.println("Diga o seu raio de ação: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);

                        double raio = Double.parseDouble(linha);

                        System.out.println("Faça uma estimativa da velocidade a que se vai deslocar: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);

                        double vel = Double.parseDouble(linha);

                        System.out.println("Tem verificação para transportar encomendas médicas(S ou N)? ");
                        char ch;
                        do{
                            ch = read.next().charAt(0);
                        }while (ch !='S' && ch  != 's' && ch !='N' && ch  != 'n');

                        boolean visto = false;
                        if (ch == 'S' || ch == 's') {
                            visto = true;
                        }
                        Voluntario v = new Voluntario(nome, mail, pass, new Coordenadas(x, y), 0, 0, true, raio, vel, visto, new ArrayList<>());
                        t.addUser(v);

                        break;
                    case 2:
                        Cliente c = new Cliente(nome, mail, pass, new Coordenadas(x, y), new ArrayList<>());
                        t.addUser(c);
                        break;

                    case 3:
                        System.out.println("Diga o nif da empresa: ");
                        String nif = read.nextLine();

                        System.out.println("Taxa de custo por km: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);
                        double taxa = Double.parseDouble(linha);

                        System.out.println("Quantas encomendas pode transportar de uma vez: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);
                        int cap = Integer.parseInt(linha);

                        System.out.println("Faça uma estimativa da velocidade a que se vai deslocar: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);
                        vel = Double.parseDouble(linha);

                        System.out.println("Diga o seu raio de ação: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);
                        raio = Double.parseDouble(linha);

                        System.out.println("Tem verificação para transportar encomendas médicas(S ou N)? ");
                        do{
                            ch = read.next().charAt(0);
                        }while (ch !='S' && ch  != 's' && ch !='N' && ch  != 'n');
                        visto = false;

                        if (ch == 'S' || ch == 's') {
                            visto = true;
                        }

                        Empresaentrega emp = new Empresaentrega(mail, nome, pass, new Coordenadas(x, y),nif, true, taxa, cap, vel, 0, 0, raio,visto , new ArrayList<>());
                        t.addUser(emp);
                        break;

                    case 4:
                        System.out.println("Diga o tempo de at2endimento esperado: ");
                        do{
                            linha = read.nextLine();
                        }while (!Menu.isNumeric(linha) || linha.length() < 1);
                        double tempo = Double.parseDouble(linha);
                        Loja l = new Loja(nome, mail, pass, new Coordenadas(x, y), new ArrayList<>(), tempo);
                        t.addUser(l);
                        break;

                    default:
                        System.out.println("Opcao Invalida");
                }
            }
        }while(opcao != 0);
    }

    public static void menu_cliente(TrazAqui t,User u,Menu m){
        String linha = "";
        Scanner read = new Scanner(System.in);
        int opcao = 0;

        do {
            do {
                m.show_menu_Cliente();
                System.out.println("Escolha uma opção:");
                linha = read.nextLine();
                }while (!Menu.isNumeric(linha) || linha.length() < 1);

                opcao = Integer.parseInt(linha);
                switch (opcao) {
                    case 1:
                        break;

                    case 2:
                        System.out.println(((Cliente) u).getHistorico());
                        break;

                    case 3:
                        t.show_encomendas_pendentes(u.getUsername());
                        break;

                    case 4:
                        t.show_empresas();
                        System.out.println("Introduza o username da empresa que quer ver:");
                        String caridade = read.nextLine();
                        Empresaentrega e = t.getEmpresa(caridade);
                        while (e == null) {
                            System.out.println("Introduza um username válido: ");
                            caridade = read.nextLine();
                            e = t.getEmpresa(caridade);
                        }
                        System.out.println(e.toString());

                        break;

                    case 5:
                        t.show_voluntarios();
                        System.out.println("Introduza o username do voluntario que quer ver:");
                        caridade = read.nextLine();
                        Voluntario v = t.getVoluntario(caridade);
                        while (v == null) {
                            System.out.println("Introduza um username válido: ");
                            caridade = read.nextLine();
                            v = t.getVoluntario(caridade);
                        }
                        System.out.println(v.toString());
                        break;

                    case 6:
                        List<String> lista = t.get_classificoes_pendentes(u.getUsername());
                        if (lista.size() != 0){
                            System.out.println("Tem as seguintes classificaçoes para dar.");
                            System.out.println(lista.toString());
                            System.out.println("Escreva o username de quem quer classificar:");
                            String cod;
                            do{
                                cod = read.nextLine();
                            }while(!lista.contains(cod));

                            System.out.println("Escreva a classificacao que quer atribuir:");
                            String aux;
                            boolean isDouble;
                            do{
                                aux = read.nextLine();
                                isDouble = aux.chars().allMatch(Character::isDigit);
                            }while(!isDouble || aux.length() < 1);
                            double c = Double.parseDouble(aux);
                            t.classificar(cod,c);
                        }else{
                            System.out.println("Nao tem classificaçoes para dar.");
                        }
                        break;

                    case 7:
                        break;

                    default:
                        System.out.println("Escolha um opção válida");
                        break;
                }
        }while (opcao != 7);
        t.logout();
    }

    public static void menu_voluntario(TrazAqui t, User u, Menu m){
        String linha = "";
        Scanner read = new Scanner(System.in);
        int opcao = 0;

        do {
            do {
                m.show_menu_Voluntario();
                System.out.println("Escolha uma opção:");
                linha = read.nextLine();
            }while (!Menu.isNumeric(linha) || linha.length() < 1);

            opcao = Integer.parseInt(linha);
            switch (opcao) {
                case 1:
                    t.altera_disp(u);
                    System.out.println("Disponibilidade alterada.");
                    break;

                case 2:
                    t.altera_visto(u) ;
                    System.out.println("Visto alterado.");
                    break;

                case 3:
                    t.mostra_Enc_pendentes();
                    break;

                case 4:
                    t.mostra_Enc_pendentes();
                    String cod;
                    System.out.println("Escreva o codigo da encomenda que quer entregar.");
                    cod = read.nextLine();
                    t.aceitaEncomenda((Voluntario) u,cod);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Escolha um opção válida");
                    break;
            }
        }while (opcao != 5);
        t.logout();
    }

    public static void menu_EmpresaEntrega(TrazAqui t, User u, Menu m){
        String linha = "";
        Scanner read = new Scanner(System.in);
        int opcao = 0;

        do {
            do {
                m.show_menu_EmpresaEntrega();
                System.out.println("Escolha uma opção:");
                linha = read.nextLine();
            }while (!Menu.isNumeric(linha) || linha.length() < 1);

            opcao = Integer.parseInt(linha);
            switch (opcao) {
                case 1:
                    t.altera_disp(u);
                    break;
                case 2:
                    t.altera_visto(u);
                    break;
                case 3:
                    System.out.println("Escolha uma data entre:");
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Escolha um opção válida");
                    break;
            }
        }while (opcao != 5);
        t.logout();
    }
}