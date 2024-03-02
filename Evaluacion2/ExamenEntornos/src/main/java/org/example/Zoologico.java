package org.example;

public class Zoologico extends Centro {
    private boolean delfinario;
    private boolean pinguino;
    public Zoologico () {
        super();
        if (Math.random()>0.5)
            delfinario = true;
        else
            delfinario = false;
        if (Math.random()>0.5)
            pinguino = true;
        else
            pinguino = false;
        precioEntrada = Math.random()*10+10;
    }

    @Override
    public double calcularPrecio(boolean festivo, int edad) {
        double precio = 0;
        if (edad>7) {
            if (festivo)
                precio = Math.random()*10+10*1.3;
            else
                precio = Math.random()*10+10;
        }
        else
            precio = 0;
        return precio;
    }
}
