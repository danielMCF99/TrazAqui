public class User {

    private String nome;
    private String email;
    private String password;
    private Coordenadas posicao;

    public User(String n, String mail, String pass, Coordenadas x){
        setEmail(mail);
        setNome(n);
        setPassword(pass);
        setPosicao(x);
    }

    public User(User a){
        this.nome = a.getNome();
        this.email = a.getEmail();
        this.password = a.getPassword();
        this.posicao = a.getPosicao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Coordenadas getPosicao() {
        return posicao;
    }

    public void setPosicao(Coordenadas posicao) {
        this.posicao = posicao.clone();
    }
}
