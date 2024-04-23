package domain;

public class Salado extends Plato {
    private int proteinas;
    private int sal;

    public Salado(int precio, String nombre, int calorias, int id, String tipo) {
        super(precio, nombre, calorias, id, tipo);
    }
}
