package domain;

import common.Constantes;
import common.HabilidadNoValidaException;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Asesino extends Campeon implements Serializable {
    private double burst;

    public Asesino(String nombre, int ataque, int skins, String habilidades, double altura, double burst) throws HabilidadNoValidaException {
        super(nombre, ataque, skins, habilidades, altura);
        this.burst = burst;
    }

    public Asesino(int id, String nombre, int ataque, int skins, String habilidades, double altura, double burst) {
        super(id, nombre, ataque, skins, habilidades, altura);
        this.burst = burst;
    }

    public Asesino() {
        super();
        this.burst = Math.random();
    }

    @Override
    public double ataqueReal() {
        return ataque*1.15;
    }

    @Override
    public String toString() {
        return super.toString() + " burst: " + burst;
    }
    public String toStringFichero() {
        return super.toStringFichero() + burst + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON + getClass().getSimpleName() + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), burst);
    }
}
