package domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
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
    public Persona (int id) {
        this.id = id;
    }
    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }

    public Persona() {
    }
}
