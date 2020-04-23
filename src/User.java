public class User {

    // Variáveis de instância
    private String nome;       
    private String username;     //username -> username
    private String password;
    private Coordenadas posicao;

    /**
     * Construtor parametrizado da classe user.
     * @param n
     * @param mail
     * @param pass
     * @param x
     * @return
     */
    public User(String n, String mail, String pass, Coordenadas x){
        setNome(n);
        setUsername(mail);
        setPassword(pass);
        setPosicao(x);
    }

     /**
     * Construtor de cópia da classe User.
     * @param a
     * @return
     */
    public User(User a){
        this.nome = a.getNome();
        this.username = a.getUsername();
        this.password = a.getPassword();
        this.posicao = a.getPosicao();
    }

    /**
     * Devolve o nome do user.
     * @param
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Atualiza o nome do user.
     * @param nome
     * @return
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o username do user.
     * @param
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Atualiza o mail do user.
     * @param username
     * @return
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devolve a password do user.
     * @param
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Atualiza a password do user.
     * @param password
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

     /**
     * Devolve as coordenados do user.
     * @param
     * @return posicao
     */
     public Coordenadas getPosicao() {
        return posicao;
    }

     /**
     * Atualiza a Posicao do user.
     * @param posicao
     * @return
     */
    public void setPosicao(Coordenadas posicao) {
        this.posicao = posicao.clone();
    }

     /**
     * Método que faz uma cópia da classe User.
     * Para tal invoca o construtor de cópia.
     * @param
     * @return User clone da classe User
     */
    public User clone(){
        return new User(this);
    }

     /**
     * Método que devolve a representação em String da classe User.
     * @param
     * @return String
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("User:\n");
        sb.append("\tNome: ").append(this.getNome()).append("\n");
        sb.append("\tEmail: ").append(this.getUsername()).append("\n");
        sb.append("\tPassword: ").append(this.getPassword()).append("\n");
        sb.append("\tPosicao: ").append(this.getPosicao()).append("\n");
        return sb.toString();
    }
    
    /**
     * Método que verifica se um Object é igual à classe User atual.
     * @param o
     * @return boolean
     */
      public boolean equals(Object o){
        if (o==this)return true;
        if ((o==null) || o.getClass()!=this.getClass())return false;

        User a = (User) o;

        return this.getUsername().equals(a.getUsername());
    }
}
