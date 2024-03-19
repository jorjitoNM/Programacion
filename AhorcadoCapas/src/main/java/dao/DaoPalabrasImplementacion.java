package dao;

import common.Constantes;
import domain.Palabra;

import java.util.Collections;
import java.util.List;

public class DaoPalabrasImplementacion implements DaoPalabras {
    protected final Palabras lista;

    public DaoPalabrasImplementacion() {
        this.lista = new Palabras();
    }

    @Override
    public boolean isEmptyPalabrasList() {
        return false;
    }

    @Override
    public boolean insertarPalabra(Palabra Palabra) {
        return false;
    }

    @Override
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) {
        return false;
    }

    @Override
    public List<Palabra> getPalabrasCategoria(String categoria) {
        return null;
    }

    @Override
    public List<Palabra> getPalabrasNivelCategoria(int nivel, String categoria) {
        return null;
    }

    @Override
    public List<Palabra> getPalabrasNivel(int nivel) {
        return null;
    }

    @Override
    public List<Palabra> getPalabras(boolean ascendente) {
        return null;
    }

    @Override
    public void eliminarPalabra(Palabra Palabra) {

    }

    @Override
    public void eliminarPalabra(int id) {

    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        return false;
    }

    @Override
    public boolean modificarPalabra(int id, String incognita) {
        return false;
    }
    @Override
    public List<Palabra> ordenarDiccionario (boolean ascendente) {
        List<Palabra> aux = lista.getListaPalabras();
        Collections.sort(aux);
        if (!ascendente)
            Collections.reverse(aux);
        return aux;
    }

    @Override
    public String añadirPalabra() {
        String feedback = Constantes.ERRORDESCONOCIDO;
        if (lista.añadirPalabra())
            feedback = Constantes.NUEVAPALABRAAÑADIDA;
        return feedback;
    }
}