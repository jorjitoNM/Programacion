package domain;

import common.HabilidadNoValidaException;
import lombok.Data;

@Data
public class Mago extends Campeon {
    private boolean stunt;

    public Mago(String nombre, int ataque, int skins, String[] habilidades, int altura, boolean stunt) throws HabilidadNoValidaException {
        super(nombre, ataque, skins, habilidades, altura);
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
}
