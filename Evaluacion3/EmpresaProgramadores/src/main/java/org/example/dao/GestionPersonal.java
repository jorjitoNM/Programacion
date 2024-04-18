package EmpresaProgramadores.src.main.java.org.example.dao;

import EmpresaProgramadores.src.main.java.org.example.domain.Trabajador;

import java.util.HashSet;

public class GestionPersonal {
    private HashSet<Trabajador> empleados;
    public GestionPersonal() {
        empleados = new HashSet<>();
    }
}
