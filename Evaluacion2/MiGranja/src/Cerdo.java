import java.util.Arrays;

public class Cerdo extends Animal{
    private String pureza;
    private String alimentacion;
    private static final double pesoMinimo = 50;
    private static final double pesoMaximo = 300;

    public Cerdo () {
        super();
        peso = Math.random()*(pesoMaximo-pesoMinimo)+pesoMinimo;
        pureza = Utilidades.purezas[(int)(Math.random()*Utilidades.purezas.length)];
        alimentacion = Utilidades.alimentaciones[(int)(Math.random()* Utilidades.alimentaciones.length)];
    }
    public Cerdo (String pureza, String alimentacion) {
        this.pureza = pureza;
        this.alimentacion = alimentacion;
    }

    public String getPureza() {
        return pureza;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setPureza(String pureza) {
        this.pureza = pureza;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String toString() {
        return String.format("Soy %s, un cerdo %s de %s, peso %skg y tengo %s primaveras",nombre,pureza,alimentacion,peso,edad);
    }

    public static boolean controlPeso(double peso) {
        return (peso >= pesoMaximo);
    }
    public static boolean controlEdad (int edad) {
        return (edad >= 20);
    }
    public String calcularProduccion () {
        double carne = peso*0.80;
        return String.format("De este cerdo se pueden aprovechar %.2fkg aprovechabeles",carne);
    }
}
