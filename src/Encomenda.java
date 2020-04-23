import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Encomenda {
    private String referencia;
    private String referenciaUti;
    private String referenciaLoj;
    private double preco;
    private double imposto;
    private double desconto;
    private LocalDateTime data;
    private double peso;
    private List<Produto> lista;


    public Encomenda() {
        this.referencia = "n/a";
        this.referenciaUti = "n/a";
        this.referenciaUti = "n/a";
        this.preco = 0;
        this.imposto = 0;
        this.desconto = 0;
        this.data = LocalDateTime.now();
        this.lista = new ArrayList<>();
    }

    public Encomenda(String referencia, String refUti, String refLoj, double preco,
                     double imposto, double desconto, LocalDateTime date, List<Produto> l) {
        this.referencia = referencia;
        this.referencia = refUti;
        this.referencia = refLoj;
        this.preco = preco;
        this.imposto = imposto;
        this.desconto = desconto;
        this.data = date;
        setLista(l);

    }

    public Encomenda(Encomenda linha) {
        this.referencia = linha.getReferencia();
        this.referenciaUti = linha.getReferenciaUti();
        this.referenciaLoj = linha.getReferenciaLoj();
        this.preco = linha.getPreco();
        this.imposto = linha.getImposto();
        this.desconto = linha.getDesconto();
        this.data = linha.getData();
        this.lista = linha.getLista();
    }

    public double calculaValorLinhaEnc() {
        double valor = 0;
        for(Produto p : this.lista){
            valor += p.quantoCusta();
        }
        return valor;
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


    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public List<Produto> getLista(){
        return this.lista.stream().map(Produto :: clone).collect(Collectors.toList());
    }

    public void setLista(List<Produto> l){
        this.lista = l.stream().map(Produto :: clone).collect(Collectors.toList());
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) obj;
        return le.getReferencia().equals(this.referencia);
    }

}