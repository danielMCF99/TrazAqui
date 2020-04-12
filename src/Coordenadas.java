public class Coordenadas {
    
    // Variáveis de instância
    private double latitude;
    private double longitude;

     /**
     * Construtor por omissão de Fatura.
     * @param
     * @return
     */
    public Coordenadas()
    {
        this.latitude = 0;
        this.longitude = 0;
    }
     
     /**
     * Construtor parametrizado da classe user.
     * @param Latitude
     * @param Longitude
     * @return
     */
    public Coordenadas(double lat, double longi) {
        setLongitude(lat);
        setLatitude(longi);
    }

    /**
     * Construtor de cópia da classe Coordenadas.
     * @param Coordenadas c
     * @return
     */
    public Coordenadas(Coordenadas c) {
        this.longitude = c.getLongitude();
        this.latitude = c.getLatitude();

    }

    /**
     * Devolve a longitude
     * @param
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }
    
     /**
     * Devolve a latitude
     * @param
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Atualiza a latitude.
     * @param latitude
     * @return
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * Atualiza a longitude.
     * @param longitude
     * @return
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Método que faz uma cópia da classe Coordenadas.
     * Para tal invoca o construtor de cópia.
     * @param
     * @return User clone da classe Coordenadas
     */
    public Coordenadas clone() {
        return new Coordenadas(this);
    }

    /**
     * Método que devolve a representação em String da classe Coordenadas.
     * @param
     * @return String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coordenadas:\n").append("\tLatitude:").append(this.getLatitude()).append("\n")
                .append("\tLongitude:").append(this.getLatitude()).append("\n");
        return sb.toString();
    }

     /**
     * Método que verifica se um Object é igual à classe Coordenadas atual.
     * @param Object
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;

        Coordenadas c = (Coordenadas) o;

        return this.longitude == c.getLongitude() && this.latitude == c.getLongitude();
    }
}
