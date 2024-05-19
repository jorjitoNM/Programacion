package domain;

import common.Constantes;
import common.HabilidadNoValidaException;
import lombok.Data;

import java.util.*;

@Data
public abstract class Campeon {
    protected int id;
    private ArrayList<Integer> ids = new ArrayList<>();
    protected String nombre;
    protected int ataque;
    protected int skins;
    protected HashSet<Habilidad> habilidades;
    protected int altura;
    public abstract double ataqueReal ();

    public Campeon(String nombre, int ataque, int skins, String[] habilidades, int altura) throws HabilidadNoValidaException {
        this.nombre = nombre;
        this.ataque = ataque;
        this.skins = skins;
        comprobarHabilidades(habilidades);
        this.altura = altura;
        this.id = darID();
        ids.add(id);
    }

    public Campeon() {
        this.id = darID();
        ids.add(id);
        nombre = Constantes.NOMBRES[(int)(Math.random()*Constantes.NOMBRES.length)];
        ataque = (int)(Math.random()*100+20);
        skins = (int)(Math.random()*10+1);
        habilidades = rellenarHabilidades();
        altura = (int)(Math.random()*100+150);
    }

    private void comprobarHabilidades (String[] habilidades) throws HabilidadNoValidaException {
        /*for (String habilidaeses:habilidaeseses) {
            if (Arrays.stream(Constantes.HABILIDADES).anyMatch(h -> h.equalsIgnoreCase(Constantes.HABILIDADES[])))
        }*/
        for (int i = 0; i < habilidades.length; i++) {
            for (int j = 0; j < Constantes.HABILIDADES.length; j++) {
                if (habilidades[i].equalsIgnoreCase(Constantes.HABILIDADES[j]))
                    throw new HabilidadNoValidaException();
            }
        }
    }
    private int darID () {
        int id = (int)(Math.random()*1000);
        return ids.contains(id)?darID():id;
    }
    private HashSet<Habilidad> rellenarHabilidades () {
        HashSet<Habilidad> habilidades = new HashSet<>();
        int cuantas = (int)(Math.random()*Constantes.HABILIDADES.length);
        for (int i = 0; i < cuantas; ) {
            if (habilidades.add(new Habilidad(Constantes.HABILIDADES[(int)(Math.random()*Constantes.HABILIDADES.length)])))
                i++;
        }
        return habilidades;
    }

    @Override
    public boolean equals(Object o) { //revisar logica de esto, no lo pillo muy bien
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campeon campeon = (Campeon) o;
        return id == campeon.id && ataque == campeon.ataque && skins == campeon.skins && altura == campeon.altura && Objects.equals(nombre, campeon.nombre) && Objects.equals(habilidades, campeon.habilidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ataque, skins, habilidades, altura);
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre +
                ", ataque:" + ataque +
                ", skins:" + skins +
                ", habilidades:" + habilidades +
                ", altura:" + altura;
    }
}
