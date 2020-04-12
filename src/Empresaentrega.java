import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresaentrega extends User {
     
    // variáveis de instância
    private boolean prontaReceber;
    private double taxa;
    private int capacidade;
    private double velocidade;
    private double classificacao;
    private double raio;
    private boolean vistoMedico;
    private List<Encomenda> encomendas;

     /**
     * Construtor parametrizado da classe Voluntario.
     * @param Nome
     * @param email
     * @param password
     * @param posicao
     * @param prontaReceber
     * @param taxa
     * @param capacidade
     * @param velocidade
     * @param classificacao
     * @param raio
     * @param vistoMedico
     * @param encomendas
     * @return
     */
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
         
     /**
     * Construtor de cópia de Empresaentrega.
     * @param Empresaentrega emp
     * @return
     */
        public Empresaentrega(Empresaentrega emp)
        {
        super(emp);
        this.prontaReceber = emp.getProntaReceber();
        this.taxa = emp.getTaxa();
        this.capacidade = emp.getCapacidade();
        this.velocidade = emp.getVelocidade();
        this.classificacao = emp.getClassificacao();
        this.raio = emp.getRaio();
        this.vistoMedico = emp.getVistoMedico();
        setEncomendas(emp.getEncomendas());
    }

    public boolean getProntaReceber() {
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

    public boolean getVistoMedico() {
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

     /**
     * Método que faz uma cópia da classe Empresaentrega.
     * Para tal invoca o construtor de cópia.
     * @param
     * @return User clone da classe Empresaentrega
     */
    public Empresaentrega clone(){
        return new Empresaentrega(this);
    }

   /**
     * Método que devolve a representação em String da classe Empresaentrega.
     * @param
     * @return String
     */
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa de entrega:\n");
        sb.append("Nome: ").append(super.getNome()).append("\n");
        sb.append("Email: ").append(super.getEmail()).append("\n");
        sb.append("Password: ").append(super.getPassword()).append("\n");
        sb.append("Posicao: ").append(super.getPosicao()).append("\n");
        sb.append("\tPronta a receber: ").append(this.getProntaReceber()).append("\n");
        sb.append("\tTaxa: ").append(this.getTaxa()).append("\n");
        sb.append("\tCapacidade: ").append(this.getCapacidade()).append("\n");
        sb.append("\tVelocidade: ").append(this.getVelocidade()).append("\n");
        sb.append("\tClassificacao: ").append(this.getClassificacao()).append("\n");
        sb.append("\tRaio: ").append(this.getRaio()).append("\n");
        sb.append("\tVisto Medico: ").append(this.getVistoMedico()).append("\n");
        sb.append("\tLista de encomendas: ").append(this.encomendas.toString()).append("\n");
        return sb.toString();
    }

     /**
     * Método que verifica se um Object é igual à classe Empresaentrega atual.
     * @param Object
     * @return boolean
     */
      public boolean equals(Object o){
        if (o==this)return true;
        if ((o==null) || o.getClass()!=this.getClass())return false;

        Empresaentrega emp = (Empresaentrega) o;

       return (super(emp).equals(super(this));
    }





}
