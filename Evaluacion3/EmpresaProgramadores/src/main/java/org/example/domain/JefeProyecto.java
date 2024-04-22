package org.example.domain;

public class JefeProyecto extends Trabajador {
    private int personas;

    public JefeProyecto() {
        super();
    }

    public JefeProyecto(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldoDia, int personas) {
        super(nombre, apellido, añoIncorporacion, departamento, sueldoDia);
        this.personas = personas;
    }
    @Override
    public int calcularSueldo (int dias) {
        return (int)((dias)*(getSueldoDia()*personas*1.02));
    }

    @Override
    public String toString() {
        return super.toString() + " Personas al cargo:" + personas;
    }
}
