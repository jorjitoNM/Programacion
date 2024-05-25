package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ParqueAtracciones extends Centro {
    private int edadMinima;

    public ParqueAtracciones () {
        super();
        edadMinima = 12;
        precioEntrada = Math.random()*10+15;
    }

    public ParqueAtracciones(String nombre, double precioEntrada, String provincia, int anyoConstruccion, int edadMinima) {
        super(nombre, precioEntrada, provincia, anyoConstruccion);
        this.edadMinima = edadMinima;
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
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + ". Edad minima: " + edadMinima;
    }
}
