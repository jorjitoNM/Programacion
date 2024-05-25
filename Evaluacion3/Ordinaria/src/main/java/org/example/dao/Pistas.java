package org.example.dao;

import org.example.common.DificultadException;
import org.example.domain.Alpina;
import org.example.domain.Fondo;
import org.example.domain.Pista;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Pistas implements Serializable {
    private HashSet<Pista> pistas;

    public Pistas() {
        pistas = new HashSet<>();
        int contador = 0;
        while(contador < 4) {
            if (pistas.add(new Alpina()))
                contador++;
        }
        while (contador < 8) {
            if (pistas.add(new Fondo()))
                contador++;
        }
    }
    public String getListaPistas () {
        StringBuilder sb= new StringBuilder();
        pistas.forEach(p -> sb.append("- ").append(p).append("\n"));
        return sb.toString();
    }
    public String getListaPistas (String tipo) {
        StringBuilder sb= new StringBuilder();
        pistas.stream().filter(p -> p.getClass().getSimpleName().equalsIgnoreCase(tipo)).forEach(p -> sb.append("- ").append(p).append("\n"));
        return sb.toString();
    }

    public Map<String, List<Pista>> getPistasprovincia() {
        return pistas.stream().collect(groupingBy(Pista::getProvincia));
    }

    public void validarDificultad(String dificultad) throws DificultadException {
        Alpina.comprobarDificultad(dificultad);
    }

    public boolean nuevaPistaFondo(String nombre, String provincia, double km, String poblaciones) {
        return pistas.add(new Fondo(nombre,provincia,km,poblaciones));
    }

    public boolean nuevaPistaAlpina(String nombre, String provincia, double km, String dificultad) throws DificultadException {
        return pistas.add(new Alpina(nombre,provincia,km,dificultad));
    }

    public double extensionProvincia(String provincia) {
        return pistas.stream().filter(pista -> pista.getProvincia().equalsIgnoreCase(provincia)).mapToDouble(Pista::getKm).sum();
    }

    public boolean nuevoPueblo(int id, String pueblo) {
        boolean exit = false;
        Fondo pista =  (Fondo)pistas.stream().filter(p -> p.getId()==id).findFirst().orElse(null);
        pista.addPoblacion(pueblo);
        for (int i = 0; i < pista.getPoblaciones().length; i++) { //revisar lambda de esto
            if (pista.getPoblaciones()[i].equalsIgnoreCase(pueblo))
                exit = true;
        }
        return exit;
    }

    public boolean eliminarPista(int id) {
        return pistas.removeIf(p -> p.getId()==id);
    }

    public boolean guardarJSON() throws IOException {
        return DaoFicheros.guardarFicheroJSON(pistas);
    }

    public void guardarBinario() throws IOException {
        DaoFicheros.guardarFicheroBinario(pistas);
    }

    public void leerBinario() throws IOException {
        pistas = DaoFicheros.leerFicheroBinario();
    }
    public String mostrarPistasPorProvincia() {
        Map<String,List<Pista>> map = pistas.stream().collect(groupingBy(Pista::getProvincia));
        StringBuilder sb = new StringBuilder();
        Set<String> claves = map.keySet();
        claves.forEach(k -> {
            sb.append(k).append(":\n");
            pistas.stream().filter(p -> p.getProvincia().equalsIgnoreCase(k)).forEach(p -> sb.append("- ").append(p).append("\n"));
            sb.append("Pistas en esta provincia: ").append(pistas.stream().filter(p -> p.getProvincia().equalsIgnoreCase(k)).count()).append("\n");
            sb.append("Km totales en esta provincia: ").append(pistas.stream().filter(p -> p.getProvincia().equalsIgnoreCase(k)).mapToDouble(Pista::getKm).sum()).append("\n");
            sb.append("\n");
        });
        return sb.toString();
    }

    public String toStringFichero() {
        StringBuilder sb = new StringBuilder();
        pistas.forEach(p -> {
            sb.append(p.toStringFichero());
            sb.append("\n");
        });
        return sb.toString();
    }

    public void leerTXT() throws IOException {
        pistas = DaoFicheros.leerFicheroTXT();
    }

    public boolean escribirTXT() throws IOException {
        return DaoFicheros.escribirFicheroTXT(toStringFichero());
    }

    public boolean addPista(Pista pista) {
        return pistas.add(pista);
    }
}
