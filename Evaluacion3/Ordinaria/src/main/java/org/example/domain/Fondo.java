package org.example.domain;

import lombok.Data;
import org.example.common.Constantes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

@Data
public class Fondo extends Pista implements Serializable {
    private String[] poblaciones;

    public Fondo(String nombre, String provincia, double km, String poblaciones) {
        super(nombre, provincia, km);
        this.poblaciones = parsearPoblaciones(poblaciones);
    }

    public Fondo(int id, String nombre, String provincia, double km, String[] poblaciones) {
        super(id, nombre, provincia, km);
        this.poblaciones = poblaciones;
    }

    private String[] parsearPoblaciones(String poblaciones) {
        String[] parsed = poblaciones.split(Constantes.SEPARADOR_POBLACIONES);
        Arrays.stream(parsed).forEach(s -> s = s.trim());
        return parsed;
    }

    public Fondo() {
        super();
        this.poblaciones = rellenarPoblaciones();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(poblaciones);
        return result;
    }

    private String[] rellenarPoblaciones() {
        HashSet<String> poblaciones = new HashSet<>();
        int random = (int)(Math.random()*Constantes.POBLACIONES.length);
        for (int i = 0; i < random; ) {
            if (poblaciones.add(Constantes.POBLACIONES[(int)(Math.random()*Constantes.POBLACIONES.length)]))
                i++;
        }
        StringBuilder sb = new StringBuilder();
        poblaciones.forEach(p -> sb.append(p).append(Constantes.SEPARADOR_POBLACIONES));
        return sb.toString().split(Constantes.SEPARADOR_POBLACIONES);
    }

    @Override
    public String toString() {
        return super.toString() + " Poblaciones por las que pasas: " + mostrarPoblaciones();
    }

    private String mostrarPoblaciones() {
        StringBuilder sb = new StringBuilder();
        for (String p:poblaciones) {
            sb.append(p).append(", ");
        }
        return sb.toString();
    }
    public void addPoblacion (String poblacion) {
        String[] nuevo = new String[poblaciones.length+1];
        for (int i = 0; i < poblaciones.length; i++) {
            nuevo[i] = poblaciones[i];
        }
        nuevo[poblaciones.length] = poblacion;
        setPoblaciones(nuevo);
    }
    public String toStringFichero () {
        return super.toStringFichero() + parsedPoblaciones();
    }

    private String parsedPoblaciones() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < poblaciones.length; i++) {
            sb.append(poblaciones[i]);
            sb.append(Constantes.SEPARADOR_POBLACIONES);
        }
        return sb.toString();
    }

}
