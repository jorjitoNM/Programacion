package EmpresaProgramadores.src.main.java.org.example.domain;

import java.util.ArrayList;

public class Programadores extends Trabajador {
    private ArrayList<String> lenguajes;

    public Programadores(){
        super();
        lenguajes = new ArrayList<>();
    }

    public Programadores(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldo, ArrayList<String> lenguajes) {
        super(nombre, apellido, añoIncorporacion, departamento, sueldo);
        this.lenguajes = lenguajes;
    }

    public ArrayList<String> getLenguajes() {
        return lenguajes;
    }
}
