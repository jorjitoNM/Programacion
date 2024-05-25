package org.example;

import lombok.Data;

@Data
public abstract class Centro {
    protected int id;
    protected String nombre;
    protected double precioEntrada;
    protected String provincia;
    protected int anyoConstruccion;

    public Centro () {
        id = (int)(Math.random()*100);
        nombre = "Centro " + id;
        provincia = Empresa.devuelveProvincia();
        anyoConstruccion = (int)(Math.random()*20+2000);
    }

    public Centro(String nombre, double precioEntrada, String provincia, int anyoConstruccion) {
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
        this.provincia = provincia;
        this.anyoConstruccion = anyoConstruccion;
    }

    public abstract double calcularPrecio (boolean festivo, int edad);
    /*public abstract String calcularPrecioMedio (boolean festivo, int edad);*/

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + nombre + ", en " + provincia + " desde " + anyoConstruccion + ". Entrada a " + precioEntrada + "€";
    }
}
