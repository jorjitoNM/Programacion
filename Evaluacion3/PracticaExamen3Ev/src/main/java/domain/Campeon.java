package domain;

import common.Constantes;
import common.HabilidadNoValidaException;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public abstract class Campeon implements Serializable {
    protected int id;
    private static final ArrayList<Integer> ids = new ArrayList<>();
    protected String nombre;
    protected int ataque;
    protected int skins;
    protected HashSet<Habilidad> habilidades;
    protected double altura;
    public abstract double ataqueReal ();

    public Campeon(String nombre, int ataque, int skins, String habilidades, double altura) throws HabilidadNoValidaException {
        this.nombre = nombre;
        this.ataque = ataque;
        this.skins = skins;
        this.habilidades = parsearHabilidades(habilidades);
        comprobarHabilidades(this.habilidades);
        this.altura = altura;
        this.id = darID();
        ids.add(id);
    }

    public Campeon(int id, String nombre, int ataque, int skins, String habilidades, double altura) {
        this.id = id;
        this.nombre = nombre;
        this.ataque = ataque;
        this.skins = skins;
        this.habilidades = parsearHabilidades(habilidades);
        this.altura = altura;
    }

    public static HashSet<Habilidad> parsearHabilidades(String habilidades) {
        HashSet<Habilidad> habilidadesSet = new HashSet<>();
        String[] split = habilidades.trim().split(Constantes.SEPARADOR_HABILIDADES_USUARIO);
        for (String s : split) {
            habilidadesSet.add(new Habilidad(s.trim()));
        }
        return habilidadesSet;
    }
    public static HashSet<Habilidad> parsearHabilidadesUsuario (String habilidades) {
        HashSet<Habilidad> habilidadesSet = new HashSet<>();
        String[] split = habilidades.split(Constantes.SEPARADOR_HABILIDADES_USUARIO);
        for (String s : split) {
            habilidadesSet.add(new Habilidad(s));
        }
        return habilidadesSet;
    }

    public Campeon() {
        this.id = darID();
        ids.add(id);
        nombre = Constantes.NOMBRES[(int)(Math.random()*Constantes.NOMBRES.length)];
        ataque = (int)(Math.random()*100+20);
        skins = (int)(Math.random()*10+1);
        habilidades = rellenarHabilidades();
        altura = (Math.random()*1+1.5);
    }

    public static void comprobarHabilidades (HashSet<Habilidad> habilidades) throws HabilidadNoValidaException { //como hago este metodo en notacion lambda
        boolean exit = false;
        /*for (String habilidaeses:habilidaeseses) {
            if (Arrays.stream(Constantes.HABILIDADES).anyMatch(h -> h.equalsIgnoreCase(Constantes.HABILIDADES[])))
        }*/
        for (Habilidad h:habilidades) {
            exit = false;
            for (int j = 0; j < Constantes.HABILIDADES.length && !exit; j++) {
                if (h.getNombre().equalsIgnoreCase(Constantes.HABILIDADES[j]))
                    exit = true;
            }
            if (!exit)
                throw new HabilidadNoValidaException();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campeon campeon = (Campeon) o;
        return id == campeon.id && Objects.equals(nombre, campeon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ataque, skins, habilidades, altura);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", nombre: " + nombre +
                ", ataque: " + ataque +
                ", skins: " + skins +
                ", habilidades: " + habilidades +
                ", altura: " + altura;
    }

    public String toStringFichero() {
        return id + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON
                + nombre + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON
                + ataque + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON
                + skins + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON
                + habilidades + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON
                + altura + Constantes.SEPARADOR_ATRIBUTOS_CAMPEON;
    }

    /*public Habilidad getHabilidad() {
        return habilidades.iterator().next();
    }*/
    /*public String[] getHabilidadesString () {
        return this.habilidades.toArray();
    }*/
}
