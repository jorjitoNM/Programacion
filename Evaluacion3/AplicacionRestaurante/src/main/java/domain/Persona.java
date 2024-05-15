package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    private ArrayList<Integer> ids = new ArrayList();

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        id = darID();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
}
