import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Produto implements Serializable
{

  // Variáveis de instância
  private String referencia;
  private String descricao;
  private double preco;
  private int quantidade;
  private double imposto;
  private double desconto;
  private double peso;
  
  
     /**
     * Construtor parametrizado da classe produto.
     * @param ref
     * @param des
     * @param pre
     * @param quan
     * @param imp
     * @param descon
     * @param pe
     * @return
     */
    public Produto(String ref,String des,double pre,int quan,double imp,double descon,double pe)
    {
      this.referencia = ref;
      this.descricao = des;
      this.preco = pre;
      this.quantidade = quan;
      this.imposto = imp;
      this.desconto = descon;
      this.peso = pe;
      }
  
     /**
     * Construtor de cópia da classe produto
     * @param umproduto
     * @return
     */
      public Produto(Produto umproduto)
        {
          this.referencia = umproduto.getreferencia();
          this.descricao = umproduto.getdescricao();
          this.preco = umproduto.getpreco();    
          this.quantidade = umproduto.getquantidade();
          this.imposto = umproduto.getimposto();
          this.desconto = umproduto.getdesconto();
          this.peso = umproduto.getpeso();
        }
  
     /**
     * Devolve a referencia de um produto
     * @param
     * @return referencia
     */
      public String getreferencia()
      {
        return this.referencia;
    }
     
     /**
     * Atualiza a referencia de um produto
     * @param ref
     * @return
     */
    public void setreferencia(String ref)
    {
        this.referencia = ref;
    }
  
     /**
     * Devolve a descricao de um produto
     * @param
     * @return descricao
     */
      public String getdescricao()
      {
        return this.descricao;
    }
     
     /**
     * Atualiza a descricao de um produto
     * @param des
     * @return
     */
    public void setdescricao(String des)
    {
        this.descricao = des;
    }
  
     /**
     * Devolve o preco de um produto
     * @param
     * @return preco
     */
      public double getpreco()
      {
        return this.preco;
    }
     
     /**
     * Atualiza o preco de um produto
     * @param pre
     * @return
     */
    public void setpreco(double pre)
    {
        this.preco = pre;
    }
  
     /**
     * Devolve a quantidade de um produto 
     * @param
     * @return quantidade
     */
      public int getquantidade()
      {
        return this.quantidade;
    }
  
     /**
     * Atualiza a quantidade de um produto
     * @param quan
     * @return
     */
    public void setquantidade(int quan)
    {
        this.quantidade = quan;
    }
  
    /**
     * Devolve o imposto de um produto 
     * @param
     * @return quantidade
     */
      public double getimposto()
      {
        return this.imposto;
    }
  
    /**
     * Atualiza o imposto de um produto
     * @param imp
     * @return
     */
    public void setimposto(double imp)
    {
        this.imposto = imp;
    }
  
    /**
     * Devolve o desconto de um produto
     * @param
     * @return desconto
     */
      public double getdesconto()
      {
        return this.desconto;
    }
  
     /**
     * Atualiza o desconto de um produto
     * @param descon
     * @return
     */
    public void setdesconto(double descon)
    {
        this.desconto = descon;
    }
  
     /**
     * Devolve o peso de um produto
     * @param
     * @return peso
     */
      public double getpeso()
      {
        return this.peso;
    }
  
    /**
     * Atualiza o peso de um produto
     * @param pe
     * @return
     */
    public void setpeso(double pe)
    {
        this.peso = pe;
    }

    /**
     * Metodo para calcular o preço total
     *
     */
    public double quantoCusta(){
        return this.preco * this.quantidade;
    }


    /**
     * Método que faz uma cópia da classe produto.
     * Para tal invoca o construtor de cópia.
     * @param
     * @return Produto clone da classe produto.
     */
    public Produto clone()
    {
        return new Produto(this);
    }
    
     
     /**
     * Método que devolve a representação em String da classe Produto.
     * @param
     * @return String
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Produto:\n");
        sb.append("\tReferencia: ").append(this.getreferencia()).append("\n");
        sb.append("\tDescricao: ").append(this.getdescricao()).append("\n");
        sb.append("\tPreco: ").append(this.getpreco()).append("\n");
        sb.append("\tQuantidade: ").append(this.getquantidade()).append("\n");
        sb.append("\tImposto: ").append(this.getimposto()).append("\n");
        sb.append("\tDesconto: ").append(this.getdesconto()).append("\n");
        sb.append("\tPeso: ").append(this.getpeso()).append("\n");
        return sb.toString();
    }
  
  
     /**
     * Método que verifica se a classe Produto é igual à classe Produto atual.
     * @param o
     * @return boolean
     */
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Produto umproduto = (Produto) o;
        return this.getreferencia().equals(umproduto.getreferencia());
    }
  
  
}
