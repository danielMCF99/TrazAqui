import java.time.LocalDateTime;

public class Encomenda {
    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;
    private LocalDateTime data;

    public Encomenda() {
        this.referencia = "n/a";
        this.descricao = "n/a";
        this.preco = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
        this.data = LocalDateTime.now();
    }

    public Encomenda(String referencia, String descricao, double preco,
                     int quantidade, double imposto, double desconto, LocalDateTime date) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
        this.data = data;
    }

    public Encomenda(Encomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.preco = linha.getPreco();
        this.quantidade = linha.getQuantidade();
        this.imposto = linha.getImposto();
        this.desconto = linha.getDesconto();
        this.data = linha.getData();
    }

    /**
     * B)
     */
    public double calculaValorLinhaEnc() {
        double valor = this.quantidade * this.preco;
        valor -= valor*this.desconto;
        valor *= 1+this.imposto;
        return valor;
    }

    /**
     * C)
     */
    public double calculaValorDesconto() {
        double valor = this.quantidade * this.preco;
        valor *= this.imposto; //e.g. imposto = 1.06
        return this.calculaValorLinhaEnc()-valor;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) obj;
        return le.getReferencia().equals(this.referencia) &&
                le.getDescricao().equals(this.descricao) &&
                le.getPreco() == this.preco;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia: ").append(this.referencia);
        //..
        return sb.toString();
    }
