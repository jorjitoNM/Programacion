import java.util.Arrays;

public abstract class Animal {

    protected int edad;
    protected double peso;
    protected String nombre;

    public Animal () {
        nombre = Utilidades.nombres[(int)(Math.random()*Utilidades.nombres.length)];
        edad = (int)(Math.random()*20+1);
        //this("animalito",3,2);
    }
    public Animal (String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public Animal(double pesoMinimoGallina, double pesoMinimoGallina1) {
        this();
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }



    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract String calcularProduccion();

    @Override
    public String toString() {
        return String.format("Me llamo %s, peso %.2f, tengo %d primaveras",nombre,peso,edad);
    }
}