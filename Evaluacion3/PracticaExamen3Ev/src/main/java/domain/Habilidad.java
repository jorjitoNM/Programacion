package domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class Habilidad {
    private String nombre;
    private int id;
    private ArrayList<Integer> ids;

    public Habilidad(String nombre) {
        id = darID();
        ids.add(id);
        this.nombre = nombre;
    }
    private int darID () {
        int id = (int)(Math.random()*1000);
        return ids.contains(id)?darID():id;
    }

    @Override
    public boolean equals(Object o) { //aqui solo quiero comparar ids
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return id == habilidad.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
