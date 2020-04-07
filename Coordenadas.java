public class Coordenadas {
    private double latitude;
    private double longitude;
    private double raio;

    public Coordenadas(double lat, double longi) {
        setLongitude(lat);
        setLatitude(longi);
        this.raio = 0;
    }

    public Coordenadas(double lat, double longi, double raio) {
        setLatitude(lat);
        setLongitude(longi);
        setRaio(raio);
    }

    public Coordenadas(Coordenadas c) {
        this.longitude = c.getLongitude();
        this.latitude = c.getLatitude();
        this.raio = c.getRaio();

    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getRaio() {
        return raio;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Coordenadas clone() {
        return new Coordenadas(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coordenadas:\n").append("\tLatitude:").append(this.getLatitude()).append("\n")
                .append("\tLongitude:").append(this.getLatitude()).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;

        Coordenadas c = (Coordenadas) o;

        return this.longitude == c.getLongitude() && this.latitude == c.getLongitude();
    }
}