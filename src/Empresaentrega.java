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
     * @param nome
     * @param email
     * @param password
     * @param posicao
     * @param prontaReceber
     * @param taxa
     * @param capacidade
     * @param vel
     * @param classi
     * @param raio
     * @param vM
     * @param enc
     * @return
     */
      public Empresaentrega(String nome,String email,String password,Coordenadas posicao,boolean pR,double taxa,int capacidade, double vel,double classi, double raio,boolean vM, List<Encomenda> enc)
          {
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
     
     /**
     * Indica se a empresa esta pronta a receber.
     * @param
     * @return prontaReceber
     */
    public boolean getProntaReceber() {
        return prontaReceber;
    }
     
     /**
     * Atualiza se a empresa esta pronta a receber.
     * @param prontareceber
     * @return
     */
    public void setProntaReceber(boolean prontaReceber) {
        this.prontaReceber = prontaReceber;
    }
     
     /**
     * Indica a taxa da empresa.
     * @param
     * @return taxa
     */
    public double getTaxa() {
        return taxa;
    }
     
     /**
     * Atualiza a taxa da empresa.
     * @param taxa
     * @return
     */
    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
     
     /**
     * Indica a capacidade da empresa.
     * @param
     * @return capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }
     
     /**
     * Atualiza a capacidade da empresa.
     * @param capacidade
     * @return
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
     
     /**
     * Indica a velocidade da empresa a entregar.
     * @param
     * @return velocidade
     */
    public double getVelocidade() {
        return velocidade;
    }
     
     /**
     * Atualiza a velocidade da empresa a entregar.
     * @param velocidade
     * @return
     */
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
     
     /**
     * Indica a classificacao da empresa de entrega.
     * @param
     * @return classificacao
     */
    public double getClassificacao() {
        return classificacao;
    }
     
     /**
     * Atualiza a classificacao da empresa de entrega.
     * @param classificacao
     * @return
     */
    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }
    
     /**
     * Indica o raio que a empresa faz a entrega.
     * @param
     * @return raio
     */
    public double getRaio() {
        return raio;
    }
     
     /**
     * Atualiza o raio que a empresa faz a entrega.
     * @param raio
     * @return
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }
     
     /**
     * Indica se a empresa entrega material medico(se pode ou nao entregar).
     * @param
     * @return vistomedico
     */
    public boolean getVistoMedico() {
        return vistoMedico;
    }
     
     /**
     * Atualiza se a empresa entrega material medico(se pode ou nao entregar).
     * @param vistomedico
     * @return
     */
    public void setVistoMedico(boolean vistoMedico) {
        this.vistoMedico = vistoMedico;
    }
     
     /**
     * Indica a lista de encomendas que a empresa tem
     * @param
     * @return  List<Encomenda> Encomendas
     */
    public List<Encomenda> getEncomendas(){
        return this.encomendas.stream().map(Encomenda :: clone).collect(Collectors.toList());
    }
     
     /**
     * Atualiza a lista de encomendas
     * @param List<Encomenda> Encomendas
     * @return
     */
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
        sb.append("Email: ").append(super.getUsername()).append("\n");
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

       return (emp.getUsername().equals(this.getUsername()));
    }





}
