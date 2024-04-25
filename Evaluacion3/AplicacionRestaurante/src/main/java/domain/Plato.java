package domain;

public class Plato {
    private int precio;
    private String nombre;
    private int calorias;
    private int id;
    private String tipo; //principal, guarnicion, aompañante, postre...
    private String extras;

    public Plato(int precio, String extras, int id, String tipo, int calorias, String nombre) {
        this.precio = precio;
        this.extras = extras;
        this.id = id;
        this.tipo = tipo;
        this.calorias = calorias;
        this.nombre = nombre;
    }
}
