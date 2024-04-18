package org.example.domain;

public abstract class Trabajador {
    private String nombre;
    private String apellido;
    private int añoIncorporacion;
    private String departamento;
    private int sueldoDia;

    public Trabajador(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldoDia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoIncorporacion = añoIncorporacion;
        this.departamento = departamento;
        this.sueldoDia = sueldoDia;
    }

    public Trabajador() {
    }
    public abstract int calcularSueldo (int dias) ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAñoIncorporacion() {
        return añoIncorporacion;
    }

    public void setAñoIncorporacion(int añoIncorporacion) {
        this.añoIncorporacion = añoIncorporacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSueldoDia() {
        return sueldoDia;
    }

    public void setSueldoDia(int sueldoDia) {
        this.sueldoDia = sueldoDia;
    }
}
