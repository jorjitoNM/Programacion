package org.example.service;

import org.example.dao.GestionPersonal;

public class Servicio {
    private GestionPersonal gestionPersonal;

    public Servicio() {
        gestionPersonal = new GestionPersonal();
    }

    public boolean nuevoProgramador (String nombre, String apellido, int año, String departamento, int sueldoDia, String lenguajes) {
        return gestionPersonal.nuevoProgramador(nombre,apellido,año,departamento,sueldoDia,lenguajes);
    }
    public boolean nuevoJefe (String nombre, String apellido, int año, String departamento, int sueldoDia, int personas) {
        return gestionPersonal.nuevoJefe(nombre,apellido,año,departamento,sueldoDia,personas);
    }
    public boolean eliminarTrabajadores (int año) {
        return gestionPersonal.eliminarTrabajadores(año);
    }
    public boolean eliminarTrabajador (String nombre, String apellido) {
        return gestionPersonal.eliminarTrabajador(nombre,apellido);
    }
    public String mostrarTrabajadores() {
        return gestionPersonal.toString();
    }
    public String mostrarPorSalario (int numeroA, int numeroB) {
        return gestionPersonal.mostrarPorSalario(numeroA, numeroB);
    }
}
