package org.example.domain;

import lombok.Data;
import org.example.common.Constantes;
import org.example.common.DificultadException;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Alpina extends Pista implements Serializable {
    private String dificultad;

    public Alpina(String nombre, String provincia, double km,String dificultad) throws DificultadException {
        super(nombre, provincia, km);
        this.dificultad = dificultad;
        comprobarDificultad(dificultad);
    }

    public Alpina(int id, String nombre, String provincia, double km, String dificultad) {
        super(id, nombre, provincia, km);
        this.dificultad = dificultad;
    }

    public Alpina() {
        super();
        this.dificultad = Constantes.DIFICULTADES[(int)(Math.random()*Constantes.DIFICULTADES.length)];
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dificultad);
    }

    public static void comprobarDificultad (String dificultad) throws DificultadException {
        boolean encontrado = false;
        for (String d:Constantes.DIFICULTADES) {
            if (d.equalsIgnoreCase(dificultad))
                encontrado = true;
        }
        if (!encontrado)
            throw new DificultadException();
    }

    @Override
    public String toString() {
        return super.toString() + " Dificultad: " + dificultad;
    }
    public String toStringFichero () {
        return super.toStringFichero() + dificultad;
    }
}
