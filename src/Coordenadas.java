public class Coordenadas {

    private double latitude;
    private double longitude;

    public Coordenadas(){
        this.latitude = 0;
        this.longitude = 0;
    }
    public Coordenadas(double lat, double longi) {
        setLongitude(lat);
        setLatitude(longi);
    }


    public Coordenadas(Coordenadas c) {
        this.longitude = c.getLongitude();
        this.latitude = c.getLatitude();

    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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