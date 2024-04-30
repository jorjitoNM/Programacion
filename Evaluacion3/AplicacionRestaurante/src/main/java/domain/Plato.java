package domain;

import java.util.ArrayList;

public class Plato {
    private double precio;
    private String nombre;
    private int calorias;
    private int id;
    private String tipo; //principal, guarnicion, aompañante, postre...
    private String extras;
    private ArrayList<Integer> ids = new ArrayList<>();

    public Plato(String nombre, double precio, String extras, String tipo) {
        this.precio = precio;
        this.extras = extras;
        this.id = darID();
        this.tipo = tipo;
        this.calorias = (int) (Math.random() * 1500 + 250);
        this.nombre = nombre;
    }

    public Plato(int id) {
        this.id = id;
    }

    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?id:darID();
    }
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "- Nombre='" + nombre +
                " , precio=" + precio +
                "€ , calorias=" + calorias +
                "Kcal , tipo='" + tipo +
                " , extras='" + extras + "\n";
    }
}
