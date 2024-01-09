public class Punto {

    private double Coordenada1;
    private double Coordenada2;

    public Punto () {
        Coordenada1 = Math.random()*21-10;
        Coordenada2 = Math.random()*21-10;
    }
    public Punto(double Coordenada1,double Coordenada2) {
        this.Coordenada1 = Coordenada1;
        this.Coordenada2 = Coordenada2;
    }

    public double getCoordenada1 () {
        return Coordenada1;
    }
    public double getCoordenada2 () {
        return Coordenada2;
    }
    public void setCoordenada1 (double Coordenada1) {
        this.Coordenada1 = Coordenada1;
    }
    public void setCoordenada2 (double Coordenada2) {
        this.Coordenada2 = Coordenada2;
    }
}