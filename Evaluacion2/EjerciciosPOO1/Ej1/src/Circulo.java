public class Circulo {

    private Punto centro;
    private double radio;

    public Circulo () {
        centro = new Punto();
        radio = Math.random()*4+1;
    }
    public Circulo (double Coordenada1, double Coordenada2, double radio) {
        centro = new Punto(Coordenada1,Coordenada2);
        this.radio = radio;
    }
    public void setCentro (Punto punto){
        this.centro = punto;
    }
    public void setRadio (double radio) {
        this.radio = radio;
    }
    public Punto getCentro () {
        return centro;
    }
    public double getRadio () {
        return radio;
    }
    public double calcularDistancia (Punto punto) {
        return (Punto.calcularDistancia(punto,centro))-radio;
    }
    public double calcularArea () {
        return Math.PI*Math.pow(radio,2);
    }
    public double calcularPerímetro () {
        return Math.PI*radio*2;
    }

}
