package service;

import common.CategoriaException;
import dao.DaoPalabras;
import dao.DaoPalabrasImplementacion;
import domain.Palabra;

import java.io.IOException;
import java.util.List;

public class GestionPalabras implements IGestionPalabras {
    private final DaoPalabras daoPalabras;

    public GestionPalabras() {
        this.daoPalabras = new DaoPalabrasImplementacion();
    }

    public GestionPalabras(DaoPalabras daoPalabras) {
        this.daoPalabras = daoPalabras;
    }

    @Override
    public boolean isEmptyPalabrasList() {
        return false;
    }

    @Override
    public List<Palabra> getListaPalabras() {
        return null;
    }

    @Override
    public boolean insertarPalabra(Palabra Palabra) {
        return false;
    }

    @Override
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException {
        return false;
    }


    @Override
    public List<Palabra> listar(String categoria) {
        return null;
    }

    @Override
    public List<Palabra> listar(int nivel, String categoria) {
        return null;
    }

    @Override
    public List<Palabra> listar(int nivel) {
        return null;
    }

    @Override
    public List<Palabra> listarPalabras(boolean ascendente) {
        return null;
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException {
        return false;
    }

    @Override
    public boolean modificarPalabra(int id, String incognita) {
        return false;
    }

      @Override
    public List<Palabra> getListaPalabrasCategoria() {
        return null;
    }

    @Override
    public String eliminarPalabra() {
        return daoPalabras.eliminarPalabra();
    }


    @Override
    public void crearFicheros() throws IOException {

    }

    @Override
    public boolean cargarFichero() throws IOException {
        return false;
    }

    @Override
    public boolean escribirFichero() {
        return false;
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }

    @Override
    public void ordenarDiccionario(boolean ascendente) {
        System.out.println(daoPalabras.ordenarDiccionario(ascendente).toString());
    }
    @Override
    public String añadirPalabra() {
        return daoPalabras.añadirPalabra();
    }
    @Override
    public String cambiarIncognita() {
        return daoPalabras.cambiarIncognita();
    }
    @Override
    public String cambiarCategoria() {
        return daoPalabras.cambiarCategoria();
    }

    @Override
    public void nuevaPartida() {
        daoPalabras.nuevaPartida();
    }

}