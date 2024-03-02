package org.example;

public class ParqueAtracciones extends Centro{
    private int edadMinima;

    public ParqueAtracciones () {
        super();
        edadMinima = 12;
        precioEntrada = Math.random()*10+15;
    }


    @Override
    public double calcularPrecio(boolean festivo, int edad) {
        double precio = 0;
        if (edad < 65) {
            if (festivo)
                precio = Math.random()*10+15*1.6;
            else
                precio = Math.random()*10+15;
        }
        else
            precio = 0;
        return precio;
    }


    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
}
