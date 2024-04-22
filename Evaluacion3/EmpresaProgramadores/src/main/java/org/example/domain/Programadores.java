package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Programadores extends Trabajador {
    private ArrayList<String> lenguajes;

    public Programadores(){
        super();
        lenguajes = new ArrayList<>();
    }

    public Programadores(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldoDia, String lenguajes) {
        super(nombre, apellido, añoIncorporacion, departamento, sueldoDia);
        ArrayList<String> aux;
        String[] parseado = lenguajes.split(",");
        aux = (ArrayList<String>) Arrays.stream(parseado).toList();
        this.lenguajes = aux;
    }

    public ArrayList<String> getLenguajes() {
        return lenguajes;
    }

    @Override
    public int calcularSueldo(int dias) {
        return dias*sueldoDia;
    }

    @Override
    public String toString() {
        return super.toString() + " Lenguajes:" + lenguajes;
    }
    @Override
    public int sueldoMensual () {
        return (int)(sueldoDia*30);
    }
}
