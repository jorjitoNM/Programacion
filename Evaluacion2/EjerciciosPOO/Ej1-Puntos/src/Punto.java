public class Punto {

    private double coordenada1;
    private double coordenada2;

    public Punto () {
        coordenada1 = Math.random()*21-10;
        coordenada2 = Math.random()*21-10;
    }
    public Punto(double Coordenada1,double Coordenada2) {
        this.coordenada1 = Coordenada1;
        this.coordenada2 = Coordenada2;

    }

    public double getCoordenada1 () {
        return coordenada1;
    }
    public double getCoordenada2 () {
        return coordenada2;
    }
    public void setCoordenada1 (double Coordenada1) {
        this.coordenada1 = Coordenada1;
    }
    public void setCoordenada2 (double Coordenada2) {
        this.coordenada2 = Coordenada2;
    }
    public double calcularDistancia (Punto punto1,Punto punto2) {
        return Math.sqrt((Math.pow(punto1.coordenada1 -punto2.coordenada1,2))-(Math.pow(punto1.coordenada2-punto2.coordenada2,2)));
    }
}