package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Voluntario extends User {

    private double classificacao;
    private boolean disponivel;
    private double raio_acao;
    private double velocidade;
    //private double raio;
    private boolean verificado;
    private List<Encomenda> entregas_feitas;
    private List<Encomenda> encomendas;


    public Voluntario(String nome, String mail, String pass, Coordenadas posicao, double classi, boolean disp, double range,double vel, boolean veri, List<Encomenda> entregas_feitas1,List<Encomenda> encomendas1){
        super(nome,mail,pass,posicao);
        this.classificacao = classi;
        this.disponivel = disp;
        this.raio_acao = range;
        //this.raio = r;
        this.velocidade = vel;
        this.verificado = veri;
        setEntregas_feitas(entregas_feitas1);
        setEncomendas(encomendas1);
    }

    public Voluntario(Voluntario v){
        super(v);
        this.classificacao = v.getClassificacao();
        this.disponivel = v.getDisponivel();
        this.raio_acao = v.getRaio_acao();
        this.velocidade = v.getVelocidade();
        this.verificado = v.getVerificado();
        setEntregas_feitas(v.getEntregas_feitas());
        setEncomendas(v.getEncomendas());
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getRaio_acao() {
        return raio_acao;
    }

    public void setRaio_acao(double raio_acao) {
        this.raio_acao = raio_acao;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public boolean getVerificado(){
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public List<Encomenda> getEncomendas() {
        List<Encomenda> novo = new ArrayList<Encomenda>();
        for (Encomenda x : this.encomendas){
            novo.add(x.clone());
        }
        return novo;
    }

    public void setEncomendas(List<Encomenda> novo){
        this.encomendas = new ArrayList<Encomenda>();
        for (Encomenda x: novo){
            this.encomendas.add(x.clone());
        }
    }

    public List<Encomenda> getEntregas_feitas() {
        List<Encomenda> novo = new ArrayList<Encomenda>();
        for (Encomenda x : this.entregas_feitas){
            novo.add(x.clone());
        }
        return novo;
    }

    public void setEntregas_feitas(List<Encomenda> novo){
        this.entregas_feitas = new ArrayList<Encomenda>();
        for (Encomenda x: novo){
            this.entregas_feitas.add(x.clone());
        }
    }

    public Voluntario clone(){
        return new Voluntario(this);
    }
    
}
