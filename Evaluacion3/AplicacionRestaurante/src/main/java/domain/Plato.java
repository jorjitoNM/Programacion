package domain;

import common.Constantes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Plato implements Serializable {
    private double precio;
    private String nombre;
    private int calorias;
    private int id;
    private String tipo; //principal, guarnicion, aompañante, postre...
    private String extras;
    private ArrayList<Integer> ids = new ArrayList<>();
    private boolean preparado;
    private double tiempoPreparacion;

    public Plato(String nombre, double precio, String extras, String tipo) {
        this.precio = precio;
        this.extras = extras;
        this.id = darID();
        this.tipo = tipo;
        this.calorias = (int) (Math.random() * 1500 + 250);
        this.nombre = nombre;
        this.tiempoPreparacion = calcularTiempoPreparacion();
    }

    public Plato(int id) {
        this.id = id;
    }

    private double calcularTiempoPreparacion () {
        return Math.random()*calorias+1;
    }
    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isPreparado() {
        return preparado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setPreparado(boolean preparado) {
        this.preparado = preparado;
    }

    @Override
    public String toString() {
        return "- Nombre: " + nombre +
                " , precio: " + precio +
                "€ , calorias:" + calorias +
                "Kcal , tipo:" + tipo +
                " , extras:" + extras + "\n";
    }
    public String toStringCocinero () {
        return "- Nombre: " + nombre +
                " , precio: " + precio +
                "€ , calorias: " + calorias +
                "Kcal , tipo: " + tipo +
                " , extras: " + extras +
                " , estado: " + devolverEstado(preparado) + "\n";
    }
    public String toStringAdmin () {
        return "- Nombre: " + nombre +
                " , precio:" + precio +
                "€ , calorias: " + calorias +
                "Kcal , tipo: " + tipo +
                " , extras: " + extras +
                " , estado: " + devolverEstado(preparado) + "\n";
    }
    private String devolverEstado (boolean preparado) {
        if (preparado)
            return Constantes.PREPARADO;
        else
            return Constantes.NO_PREPARADO;
    }
}
