package domain;

import common.HabilidadNoValidaException;
import lombok.Data;

@Data
public class Asesino extends Campeon {
    private boolean busrt;

    public Asesino(String nombre, int ataque, int skins, String[] habilidades, int altura, boolean busrt) throws HabilidadNoValidaException {
        super(nombre, ataque, skins, habilidades, altura);
        this.busrt = busrt;
    }

    public Asesino() {
        super();
        if (Math.random()*10>5)
            busrt = true;
        else
            busrt = false;
    }

    @Override
    public double ataqueReal() {
        return ataque*1.15;
    }
}
