package domain;

public class Dulce extends Plato {
    private int azucares;

    public Dulce(int precio, String nombre, int calorias, int id, String tipo) {
        super(precio, nombre, calorias, id, tipo);
    }
}
