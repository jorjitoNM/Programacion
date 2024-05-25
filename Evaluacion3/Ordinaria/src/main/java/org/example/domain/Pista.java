package org.example.domain;

import lombok.Data;
import net.datafaker.Faker;
import org.example.common.Constantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@Data
public class Pista implements Serializable{
    protected int id;
    protected String nombre;
    protected String provincia;
    protected double km;
    private static final ArrayList<Integer> ids = new ArrayList<>();

    public Pista(String nombre, String provincia, double km) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.km = km;
        this.id = darID();
        ids.add(id);
    }

    public Pista(int id, String nombre, String provincia, double km) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.km = km;
    }

    public Pista() {
        Faker faker = new Faker();
        this.id = darID();
        ids.add(id);
        this.nombre = faker.nation().capitalCity();
        this.provincia = Constantes.PROVINCIAS[(int)(Math.random()*Constantes.PROVINCIAS.length)];
        this.km = Math.random()*13+2;
    }

    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pista pista = (Pista) o;
        return id == pista.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("(id: %d) Pista %s en %s con %.2f  km de longitud.",id,nombre,provincia,km);
    }
    public String toStringFichero() {
        return getClass().getSimpleName() + Constantes.SEPARADOR_ATRIBUTOS
                + id + Constantes.SEPARADOR_ATRIBUTOS
                + nombre + Constantes.SEPARADOR_ATRIBUTOS
                + provincia + Constantes.SEPARADOR_ATRIBUTOS
                + km + Constantes.SEPARADOR_ATRIBUTOS;

    }
}