package org.example;

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


    public abstract double calcularPrecio (boolean festivo, int edad);
    /*public abstract String calcularPrecioMedio (boolean festivo, int edad);*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getAnyoConstruccion() {
        return anyoConstruccion;
    }

    public void setAnyoConstruccion(int anyoConstruccion) {
        this.anyoConstruccion = anyoConstruccion;
    }
}
