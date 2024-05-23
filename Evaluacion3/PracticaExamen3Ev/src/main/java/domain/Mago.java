package domain;

import common.Constantes;
import common.HabilidadNoValidaException;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Mago extends Campeon implements Serializable {
    private boolean stunt;

    public Mago(String nombre, int ataque, int skins, String habilidades, double altura, boolean stunt) throws HabilidadNoValidaException {
        super(nombre, ataque, skins, habilidades, altura);
        this.stunt = stunt;
    }

    public Mago(int id, String nombre, int ataque, int skins, String habilidades, double altura, boolean stunt) {
        super(id, nombre, ataque, skins, habilidades, altura);
        this.stunt = stunt;
    }

    public Mago() {
        super();
        if (Math.random()*10>5)
            stunt = true;
        else
            stunt = false;
    }

    private int numeroHabilidades () {
        return habilidades.size();
    }
    @Override
    public double ataqueReal() {
        if (numeroHabilidades()<1)
            return ataque;
        else
            return ataque*(1.05*numeroHabilidades());
    }

    @Override
    public String toString() {
        return super.toString() + " stunt: " + traduccionStunt();
    }
    @Override
    public String toStringFichero() {
        return super.toStringFichero() + traduccionStunt() + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON + getClass().getSimpleName() + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON;
    }

    private String traduccionStunt() {
        return stunt?"si":"no";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stunt);
    }
}
