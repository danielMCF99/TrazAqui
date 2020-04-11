import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Voluntario extends User {

    private double classificacao;
    private boolean disponivel;
    private double raioacao;
    private double velocidade;
    private double raio;
    private boolean verificado;
    private Set<Encomenda> entregasFeitas;
    private List<Encomenda> encomendas;

    public Voluntario(){
        this.classificacao = 0;
        this.disponivel = false;
        this.raioacao = 0;
        this.raio = 0;
        this.velocidade = 0;
        this.verificado = false;
        this.entregasFeitas = new TreeSet<Encomenda>();
        this.encomendas = new ArrayList<Encomenda>();
    }

    public Voluntario(double classi, boolean disp, double range,double vel, double r, boolean veri, Set<Encomenda> x,List<Encomenda> y){
        super();
        this.classificacao = classi;
        this.disponivel = disp;
        this.raioacao = range;
        this.raio = r;
        this.velocidade = vel;
        this.verificado = veri;
        //this.entregasFeitas =
        //this.encomendas =
    }

    public Voluntario(Voluntario v){

    }
}
