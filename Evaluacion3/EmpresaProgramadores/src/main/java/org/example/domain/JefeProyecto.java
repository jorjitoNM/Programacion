package org.example.domain;

public class JefeProyecto extends Trabajador {
    private int personas;

    public JefeProyecto() {
        super();
    }

    public JefeProyecto(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldoDia, int personas) {
        //super(nombre, apellido, añoIncorporacion, departamento, calcularSueldo(sueldoDia,personas)); //como calculo el sueldo
        super(nombre, apellido, añoIncorporacion, departamento, sueldoDia);
        this.personas = personas;
    }
    private int calcularSueldo (int dias, int sueldoDia, int personas) {
        return (int)((dias)*(sueldoDia*personas*1.02));
    }
}
