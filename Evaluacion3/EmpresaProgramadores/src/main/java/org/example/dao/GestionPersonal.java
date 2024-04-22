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
        return (empleados.add(new Programadores(nombre, apellido, añoIncorporacion, departamento, sueldo,lenguajes)));
    }
    public boolean nuevoJefe (String nombre, String apellido, int añoIncorporacion, String departamento, int sueldo, int personas) {
        return empleados.add(new JefeProyecto(nombre, apellido, añoIncorporacion, departamento, sueldo, personas));
    }
    private boolean buscarEmpleado (Trabajador empelado) {
        return empleados.stream().filter(e -> e.equals(empelado)).findFirst().orElse(null) != null;
        //Iterator<Trabajador> it = empleados.iterator();
        /*boolean exit = false;
        while (it.hasNext() && !exit) {
            if (it.next().equals(empelado))
                exit = true;
        }
        return exit;*/
    }
    public boolean eliminarTrabajadores (int año) {
        //empleados.stream().filter(t -> t.getAñoIncorporacion()<año).forEach(t -> empleados.remove(t)); //no entiendo esta logica, el iterador esta dentro del remove o dentro del foreach??/es el remove que tiene el iterator??
        empleados.removeAll(empleados.stream().filter(t -> t.getAñoIncorporacion()<año).toList());
        if (empleados.stream().anyMatch(t -> t.getAñoIncorporacion() < año))
            return false;
        else
            return true;
    }
    public boolean eliminarTrabajador (String nombre, String apellido) {
        //empleados.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombre) && e.getApellido().equalsIgnoreCase(apellido)).iterator().remove();
        empleados.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre) && e.getApellido().equalsIgnoreCase(apellido));
        if (empleados.stream().anyMatch(e -> e.getNombre().equalsIgnoreCase(nombre) && e.getApellido().equalsIgnoreCase(apellido)))
            return false;
        else
            return true;
    }
    public String mostrarPorSalario (int numeroA, int numeroB) {
        return empleados.stream().filter(e -> numeroA < e.sueldoMensual() && e.sueldoMensual() < numeroB).toList().toString();
    }
}