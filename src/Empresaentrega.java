import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresaentrega extends User {

    private boolean prontaReceber;
    private double taxa;
    private int capacidade;
    private double velocidade;
    private double classificacao;
    private double raio;
    private boolean vistoMedico;
    private List<Encomenda> encomendas;

    public Empresaentrega(){
        super();
        this.prontaReceber = false;
        this.taxa = 0;
        this.capacidade = 0;
        this.velocidade = 0;
        this.classificacao = 0;
        this.raio = 0;
        this.vistoMedico = false;
        this.encomendas = new ArrayList<Encomenda>();
    }

    public Empresaentrega(String nome,String email,String password,Coordenadas posicao,boolean pR,double taxa,int capacidade, double vel,double classi, double raio,boolean vM, List<Encomenda> enc){
        super(nome,email,password,posicao);
        this.prontaReceber = pR;
        this.taxa = taxa;
        this.capacidade = capacidade;
        this.velocidade = vel;
        this.classificacao = classi;
        this.raio = raio;
        this.vistoMedico = vM;
        this.encomendas = enc.stream().map(Encomenda :: clone).collect(Collectors.toList());
    }

    public Empresaentrega(Empresaentrega emp){
        super(emp);
        this.prontaReceber = emp.isProntaReceber();
        this.taxa = emp.getTaxa();
        this.capacidade = emp.getCapacidade();
        this.velocidade = emp.getVelocidade();
        this.classificacao = emp.getClassificacao();
        this.raio = emp.getRaio();
        this.vistoMedico = emp.isVistoMedico();
        setEncomendas(emp.getEncomendas());
    }

    public boolean isProntaReceber() {
        return prontaReceber;
    }

    public void setProntaReceber(boolean prontaReceber) {
        this.prontaReceber = prontaReceber;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public boolean isVistoMedico() {
        return vistoMedico;
    }

    public void setVistoMedico(boolean vistoMedico) {
        this.vistoMedico = vistoMedico;
    }

    public List<Encomenda> getEncomendas(){
        return this.encomendas.stream().map(Encomenda :: clone).collect(Collectors.toList());
    }

    public void setEncomendas(List<Encomenda> lista){
        List<Encomenda> aux = new ArrayList<Encomenda>();
        for(Encomenda e : lista){
            aux.add(e.clone());
        }
        this.encomendas = aux;
    }

}
