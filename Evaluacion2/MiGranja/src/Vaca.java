public class Vaca extends Animal{

    private String raza;
    private String color;
    private int[] lLeche = new int[7];
    private static final double pesoMinimo = 100;
    private static final double pesoMaximo = 600;



    public Vaca() {
        super();
        peso = peso = Math.random()*(pesoMaximo-pesoMinimo)+pesoMinimo;
        raza = Utilidades.razas[(int)(Math.random()* Utilidades.razas.length)];
        color = Utilidades.colores[(int)(Math.random()* Utilidades.colores.length)];
        for (int i = 0; i < lLeche.length; i++) {
            lLeche[i] = (int)(Math.random()*20+10);
        }
    }
    public Vaca(String nombre, int edad, double peso, String raza,String color, int[] lLeche) {
        super(nombre,edad,peso);
        this.raza = raza;
        this.color = color;
        this.lLeche = lLeche;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLleche(int[] lLeche) {
        this.lLeche = lLeche;
    }

    public String getRaza() {
        return raza;
    }
    public String getColor() {
        return color;
    }
    public int[] getLleche() {
        return lLeche;
    }


    public String toString() {
        return String.format("Soy %s, una vaca de raza %s de %s, peso %skg y tengo %s primaveras",nombre,raza,peso,edad);
    }

    public static boolean controlPeso(double peso) {
        return (peso >= pesoMaximo);
    }
    public static boolean controlEdad (int edad) {
        return (edad >= 20);
    }
    public String calcularProduccion () {
        double media = 0;
        for (int i = 0; i < lLeche.length; i++) {
            media+=lLeche[i];
        }
        return String.format("Esta vaca ha producido %.2fl de leche",media/ lLeche.length);
    }

}
