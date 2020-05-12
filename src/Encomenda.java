import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda implements Serializable {
    private String referencia;
    private String referenciaUti; //
    private String referenciaLoj;
    private double preco;
    private LocalDateTime data;
    private double peso;
    private List<Produto> lista;

    public Encomenda() {
        this.referencia = "n/a";
        this.referenciaUti = "n/a";
        this.referenciaLoj = "n/a";
        this.preco = 0;
        this.data = LocalDateTime.now();
        this.peso = 0;
        this.lista = new ArrayList<>();
    }

    public Encomenda(String ref, String refUti, String refL, double peso, List<Produto> l){
        this.referencia = ref;
        this.referenciaUti = refUti;
        this.referenciaLoj = refL;
        this.peso = peso;
        setLista(l);
        this.preco = this.calculaValorLinhaEnc();
        this.data = LocalDateTime.now();
    }

    public Encomenda(String referencia, String refUti, String refLoj, double preco,
                      LocalDateTime date,double peso, List<Produto> l) {
        this.referencia = referencia;
        this.referenciaUti = refUti;
        this.referenciaLoj = refLoj;
        this.preco = preco;
        this.peso = peso;
        this.data = date;
        setLista(l);

    }

    public Encomenda(Encomenda linha) {
        this.referencia = linha.getReferencia();
        this.referenciaUti = linha.getReferenciaUti();
        this.referenciaLoj = linha.getReferenciaLoj();
        this.preco = linha.getPreco();
        this.data = linha.getData();
        this.peso = linha.getPeso();
        this.lista = linha.getLista();
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferenciaUti() {
        return referenciaUti;
    }

    public void setReferenciaUti(String referenciaUti) {
        this.referenciaUti = referenciaUti;
    }

    public String getReferenciaLoj() {
        return referenciaLoj;
    }

    public void setReferenciaLoj(String referenciaLoj) {
        this.referenciaLoj = referenciaLoj;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<Produto> getLista(){
        List<Produto> ret = new ArrayList<>();
        for(Produto p : this.lista){
            ret.add(p.clone());
        }
        return ret;
    }

    public void setLista(List<Produto> l){
        this.lista = l.stream().map(Produto :: clone).collect(Collectors.toList());
    }

    /**
     * metodo que determina se produto vai ser encomendado
     * @return boolean
     */
    public boolean existeProdutoEncomenda(String refProduto) {
        Iterator<Produto> it = this.lista.iterator();
        while(it.hasNext()){
            String aux = it.next().getreferencia();
            if(refProduto.equals(aux)){
                return true;
            }
        }
        return false;
    }

    /**
     * método que determina o valor total de um encomenda
     * @return
     */

    public double calculaValorLinhaEnc() {
        double valor = 0;
        for(Produto p : this.lista){
            valor += p.quantoCusta();
        }
        return valor;
    }

    /**
     * metodo para adicionar produto a encomenda
     */
    public void adicionaProduto(Produto linha){
        if(!this.lista.contains(linha)){
            lista.add(linha.clone());
        }
        else{
            System.out.print("A encomenda que quer adicionar já existe\n");
        }
    }

    /**
     * metodo para remover produto de encomenda
     */
    public void removeProduto(String codProd){
        Iterator<Produto> it = this.lista.iterator();
        boolean removido = false;
        while(it.hasNext() && !removido){
            Produto aux = it.next();
            if(codProd.equals(aux.getreferencia())){
                it.remove();
                removido = true;
            }
        }
        if (!removido){
            System.out.println("O Produto que quer remover não se encontra nesta encomenda.\n");
        }
    }


    public Encomenda clone() {
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda:\n")
                .append("\tReferência:").append(this.referencia).append("\n")
                .append("\tReferência Utilizador: ").append(this.referenciaUti).append("\n")
                .append("\tReferência Loja: ").append(this.referenciaLoj).append("\n")
                .append("\tPeso: ").append(this.peso).append("\n")
                .append("\tData: ").append(this.data).append("\n")
                .append("\tProdutos:\n").append(this.lista.toString());
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) obj;
        return le.getReferencia().equals(this.referencia);
    }

}

