public class User {

    // Variáveis de instância
    private String nome;       
    private String email;     
    private String password;
    private Coordenadas posicao;

    /**
     * Construtor parametrizado da classe user.
     * @param Nome
     * @param Email
     * @param password
     * @param posicao
     * @return
     */
    public User(String n, String mail, String pass, Coordenadas x){
        setNome(n);
        setEmail(mail);
        setPassword(pass);
        setPosicao(x);
    }

     /**
     * Construtor de cópia da classe User.
     * @param User a
     * @return
     */
    public User(User a){
        this.nome = a.getNome();
        this.email = a.getEmail();
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
     * @param Nome
     * @return
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o email do user.
     * @param
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atualiza o mail do user.
     * @param Email
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @param Password
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
     * @param Posicao
     * @return
     */
    public void setPosicao(Coordenadas posicao) {
        this.posicao = posicao.clone();
    }

     /**
     * Método que faz uma cópia da classe User.
     * Para tal invoca o construtor de cópia.
     * @param
     * @return User clone da classe User.
     */
    public User clone(){
        return new User(this);
    }

     /**
     * Método que devolve a representação em String da classe User.
     * @param
     * @return String.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("User:\n");
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Email: ").append(this.getEmail()).append("\n");
        sb.append("Password: ").append(this.getPassword()).append("\n");
        sb.append("Posicao: ").append(this.getIndex_Agregado()).append("\n");
        return sb.toString();
    }
    
    /**
     * Método que verifica se a classe User é igual à classe User que recebe a mensagem.
     * @param Object
     * @return boolean
     */
      public boolean equals(Object o){
        if (o==this)return true;
        if ((o==null) || o.getClass()!=this.getClass())return false;

        User a = (User) o;

        return this.getEmail().equals(a.getEmail());
    }
}
