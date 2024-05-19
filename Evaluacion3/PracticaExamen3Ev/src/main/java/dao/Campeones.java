package dao;

import common.HabilidadNoValidaException;
import domain.Asesino;
import domain.Campeon;
import domain.Mago;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Campeones {
    private HashSet<Campeon> campeones;

    public Campeones() throws HabilidadNoValidaException {
        campeones = rellenarCampeones();
    }
    private HashSet<Campeon> rellenarCampeones () throws HabilidadNoValidaException {
        HashSet<Campeon> campeones = new HashSet<>();
        int contador = 0;
        while(contador<4) {
            if (campeones.add(new Mago()))
                contador++;
        }
        while(contador<8){
            if (campeones.add(new Asesino()))
                contador++;
        }
        return campeones;
    }
    public String getCampeones () {
        StringBuilder sb = new StringBuilder();
        campeones.forEach(c -> sb.append(c.toString()));
        return sb.toString();
    }
    public String getCampeonesNombre (boolean orden) {
        if (orden)
            return campeones.stream().sorted(Comparator.comparing(Campeon::getNombre)).toString();
        else
            return Collections.reverseOrder(Comparator.comparing(Campeon::getNombre)).toString();
    }


    public boolean nuevoAsesino(String nombre, int ataque, int skins, String[] habilidades, int altura, boolean busrt) throws HabilidadNoValidaException {
        Asesino asesino = new Asesino(nombre,ataque,skins,habilidades,altura,busrt);
        return campeones.add(asesino);
    }

    public boolean nuevoMago(String nombre, int ataque, int skins, String[] habilidades, int altura, boolean stunt) throws HabilidadNoValidaException {
        Mago mago = new Mago(nombre,ataque,skins,habilidades,altura,stunt);
        return campeones.add(mago);
    }
}
