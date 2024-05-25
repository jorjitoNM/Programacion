package org.example.dao;

import org.example.common.DificultadException;
import org.example.domain.Pista;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DaoUsuario {
    private Pistas database;

    public DaoUsuario() {
        database = new Pistas();
    }
    public String getListaPistas ()  {
        return database.getListaPistas();
    }
    public String getListaPistas (String tipo)  {
        return database.getListaPistas(tipo);
    }

    public Map<String, List<Pista>> getPistasProvincia() {
        return database.getPistasprovincia();
    }

    public void validarDificultad(String dificultad) throws DificultadException {
        database.validarDificultad(dificultad);
    }

    public boolean nuevaPistaFondo(String nombre, String provincia, double km, String poblaciones) {
        return database.nuevaPistaFondo(nombre,provincia,km,poblaciones);
    }

    public boolean nuevaPistaAlpina(String nombre, String provincia, double km, String dificultad) throws DificultadException {
        return database.nuevaPistaAlpina(nombre,provincia,km,dificultad);
    }

    public double extensionprovincia(String provincia) {
        return database.extensionProvincia(provincia);
    }

    public boolean nuevoPueblo(int id, String pueblo) {
        return database.nuevoPueblo(id,pueblo);
    }

    public boolean eliminarPista(int id) {
        return database.eliminarPista(id);
    }

    public boolean guardarJSON() throws IOException {
        return database.guardarJSON();
    }

    public void guardarBinario() throws IOException {
        database.guardarBinario();
    }

    public void leerBinario() throws IOException {
        database.leerBinario();
    }

    /*public boolean leerJSON() {
        return database.leerJSON();
    }*/

    public String mostrarPistasPorProvincia() {
        return database.mostrarPistasPorProvincia();
    }

    public void leerTXT() throws IOException {
        database.leerTXT();
    }

    public boolean escribirTXT() throws IOException {
        return database.escribirTXT();
    }

    public boolean addPista(Pista pista) {
        return database.addPista(pista);
    }
}
