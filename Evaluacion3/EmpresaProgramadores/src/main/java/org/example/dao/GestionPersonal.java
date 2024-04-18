package org.example.dao;

import org.example.domain.JefeProyecto;
import org.example.domain.Trabajador;
import org.example.domain.Programadores;
import org.example.domain.Trabajador;

import java.util.*;
import java.util.stream.Collectors;

public class GestionPersonal {
    private HashSet<Trabajador> empleados;
    public GestionPersonal() {
        empleados = new HashSet<>();
    }
    public boolean nuevoProgramador (String nombre, String apellido, int añoIncorporacion, String departamento, int sueldo, String lenguajes) {
        if(empleados.add(new Programadores(nombre, apellido, añoIncorporacion, departamento, sueldo,lenguajes)))
            //if (buscarEmpleado()) //como saco ahora a este empleado??
            return false;
        else
            return true;

    }
    public boolean nuevoJefe (String nombre, String apellido, int añoIncorporacion, String departamento, int sueldo, int personas) {
        if(empleados.add(new JefeProyecto(nombre,apellido,añoIncorporacion,departamento,sueldo,personas)))
    }
    private boolean buscarEmpleado (Trabajador empelado) {
        Iterator<Trabajador> it = empleados.iterator();
        empleados.forEach(e -> (e.equals(it.next())?true:false)); // alguna forma de hacer esto??
        boolean exit = false;
        while (it.hasNext() && !exit) {
            if (it.next().equals(empelado))
                exit = true;
        }
        return true;
    }
    public boolean eliminarTrabajadores (int año) {
        empleados.stream().filter(t -> t.getAñoIncorporacion()<año).forEach(t -> empleados.remove(t)); //no entiendo esta logica, el iterador esta dentro del remove o dentro del foreach??
        if (empleados.stream().anyMatch(t -> t.getAñoIncorporacion() < año))
            return false;
        else
            return true;
    }
    public boolean eliminarTrabajador () {

    }
}
