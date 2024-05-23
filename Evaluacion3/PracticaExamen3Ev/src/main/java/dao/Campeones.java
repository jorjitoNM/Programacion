package dao;

import common.Constantes;
import common.HabilidadNoValidaException;
import domain.Asesino;
import domain.Campeon;
import domain.Habilidad;
import domain.Mago;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class Campeones implements Serializable {
    private HashSet<Campeon> campeones;

    public Campeones() {
        campeones = rellenarCampeones();
    }

    private HashSet<Campeon> rellenarCampeones () {
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
        campeones.forEach(c -> sb.append(c.toString()).append("\n"));
        return sb.toString();
    }
    public String getCampeones (String tipo) {
        StringBuilder sb = new StringBuilder();
        campeones.stream().filter(c -> c.getClass().getSimpleName().equalsIgnoreCase(tipo)).forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }
    public String getCampeonesNombre (boolean orden) {
        StringBuilder sb = new StringBuilder();
        if (orden)
            campeones.stream().sorted(Comparator.comparing(Campeon::getNombre)).forEach(c -> sb.append(c).append("\n"));
        else
            campeones.stream().sorted(Comparator.comparing(Campeon::getNombre).thenComparing(Campeon::getId).reversed()).forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }


    public boolean nuevoAsesino(String nombre, int ataque, int skins, String habilidades, double altura, double busrt) throws HabilidadNoValidaException {
        Asesino asesino = new Asesino(nombre,ataque,skins,habilidades,altura,busrt);
        return campeones.add(asesino);
    }

    public boolean nuevoMago(String nombre, int ataque, int skins, String habilidades, double altura, boolean stunt) throws HabilidadNoValidaException {
        Mago mago = new Mago(nombre,ataque,skins,habilidades,altura,stunt);
        return campeones.add(mago);
    }

    public String mostrarCampeonesPorAtaque(int minimo, int maximo) {
        StringBuilder sb = new StringBuilder();
        campeones.stream().filter(c -> c.getAtaque()>minimo && c.getAtaque()<maximo).forEach(c -> sb.append(c.toString()).append("\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        campeones.forEach(c -> sb.append("- ").append(c.toString()).append("\n"));
        return sb.toString();
    }

    public boolean actualizarBurst(int id,double burst) throws NullPointerException { //esta bien lanzar esta excepcion??
        Asesino asesino = (Asesino) campeones.stream().filter(c -> c.getId()==id).findFirst().orElse(null);
        asesino.setBurst(burst);
        return asesino.getBurst()==burst;
    }

    public boolean eliminarCampeon(int id) {
        return campeones.removeIf(c -> c.getId()==id);
    }
    public String toStringFichero () {
        StringBuilder sb = new StringBuilder();
        campeones.forEach(c -> sb.append(c.toStringFichero()).append(Constantes.SEPARADOR_CAMPEONES));
        return sb.toString();
    }

    public void guardarFicheroTXT() throws FileNotFoundException {
        DaoFicheros.guardarFicheroTXT(toStringFichero());
    }

    public void cargarFicheroTXT() {
        campeones = DaoFicheros.leerFicheroTXT();
    }

    public void guardarFicheroBinario() {
        DaoFicheros.guardarFicheroBinario(campeones);
    }

    public void cargarFicheroBinario() { //como cargo la clase??
        campeones = DaoFicheros.leerFicheroBinario();
    }

    public String mostrarCampeonesPorHabilidad() {
        Map<HashSet<Habilidad>, List<Campeon>> map;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        map = campeones.stream().collect(groupingBy(Campeon::getHabilidades));
        map.forEach((k,v) -> {
            v.forEach(sb2::append);
            sb.append(k).append("   ->   ").append(sb2.toString());
            sb2.setLength(0);
        });
        return sb.toString();
    }
    /*public Map<Habilidad,List<Campeon>> mostrarCampeonesPorHabilidadMap() {
        Map<Habilidad, List<Campeon>> map;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        map = campeones.stream().collect(groupingBy(Campeon::getHabilidad));
        return map;
    }*/
    public String mostrarCampeonesPorHabilidadNoLambda () {
        StringBuilder sb = new StringBuilder();
        for (String habilidad:Constantes.HABILIDADES) {
            sb.append(habilidad).append("  -->  ");
            for (Campeon c : campeones) {
                if (c.getHabilidades().contains(new Habilidad(habilidad)))
                    sb.append(c.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    public String map () {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Constantes.HABILIDADES).forEach(h -> {
            sb.append(h).append(":\n");
            campeones.forEach(c -> {
                if (c.getHabilidades().contains(new Habilidad(h)))
                    sb.append("- ").append(c.toString()).append("\n");
            });
        });
        return sb.toString();
    }
    private String habilidadesString () {
        StringBuilder sb = new StringBuilder();
        campeones.forEach(c -> sb.append(c.getHabilidades().toString()));
        return sb.toString();
    }
}
