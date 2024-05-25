package org.example.service;

import org.example.common.DificultadException;
import org.example.dao.DaoUsuario;
import org.example.domain.Pista;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GestionUsuario implements ServiceInterface{
    private DaoUsuario daoUsuario;

    public GestionUsuario() {
        daoUsuario = new DaoUsuario();
    }

    @Override
    public String getListaPistas() {
        return daoUsuario.getListaPistas();
    }
    @Override
    public String getListaPistas(String tipo) {
        return daoUsuario.getListaPistas(tipo);
    }

    @Override
    public boolean addPista(Pista pista) throws DificultadException {
        return daoUsuario.addPista(pista);
    }
    @Override
    public boolean addPuebloListaPueblos(int id, String pueblo) {
        return daoUsuario.nuevoPueblo(id,pueblo);
    }

    @Override
    public Map<String, List<Pista>> getPistasProvincia() {
        return daoUsuario.getPistasProvincia();
    }

    public double extensionProvincia(String provincia) {
        return daoUsuario.extensionprovincia(provincia);
    }

    public boolean eliminarPista(int id) {
        return daoUsuario.eliminarPista(id);
    }

    public boolean guardarJSON() throws IOException {
        return daoUsuario.guardarJSON();
    }

    public void guardarBinario() throws IOException {
        daoUsuario.guardarBinario();
    }

    public void leerBinario() throws IOException {
        daoUsuario.leerBinario();
    }

    /*public boolean leerJSON() {
        return daoUsuario.leerJSON();
    }*/

    public String mostrarPistasPorProvincia() {
        return daoUsuario.mostrarPistasPorProvincia();
    }

    public void leerTXT() throws IOException {
        daoUsuario.leerTXT();
    }

    public boolean escribirTXT() throws IOException {
        return daoUsuario.escribirTXT();
    }
}
