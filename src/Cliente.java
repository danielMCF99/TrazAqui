import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cliente extends User implements Serializable{
    private List<Encomenda> hist_encomendas;

    public Cliente(String username, String nome, Coordenadas x){
        super(username,nome,x);
        this.hist_encomendas = new ArrayList<>();
    }

    public Cliente(String nome,String username, String pass, Coordenadas x, List<Encomenda> aux){
        super(username,nome,pass,x);
        setHistorico(aux);
    }

    public Cliente(Cliente c){
        super(c);
        setHistorico(c.getHistorico());
    }

    public List<Encomenda> getHistorico(){
        return this.hist_encomendas.stream().map(Encomenda :: clone).collect(Collectors.toList());
    }

    public void setHistorico(List<Encomenda> aux){
        this.hist_encomendas = aux.stream().map(Encomenda :: clone).collect(Collectors.toList());
    }

    public void addEnc(Encomenda enc){
        if (!this.hist_encomendas.contains(enc)) {
            this.hist_encomendas.add(enc.clone());
        }
    }

    public Cliente clone(){
        return new Cliente(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Loja:\n").append(super.toString()).append("\n")
                .append("Histórico:\n").append("\t"+this.hist_encomendas);
            return sb.toString();
    }

    public boolean equals(Object o){
        if (o==this)return true;
        if(o==null || o.getClass()!=this.getClass())return false;
        Loja l = (Loja) o;
        return l.getUsername().equals(((Loja) o).getUsername());
    }

    public int hashCode(){
        int hash = 5;
        hash = 31 * hash + super.hashCode();
        hash = 31*hash + this.hist_encomendas.stream().mapToInt(Encomenda :: hashCode).sum();
        return hash;
    }
}
