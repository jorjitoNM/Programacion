package domain;

public class Plato {
    protected int precio;
    protected String nombre;
    protected int calorias;
    protected int id;
    protected String tipo;

    public Plato(int precio, String nombre, int calorias, int id, String tipo) {
        this.precio = precio;
        this.nombre = nombre;
        this.calorias = calorias;
        this.id = id;
        this.tipo = tipo;
    }
}
