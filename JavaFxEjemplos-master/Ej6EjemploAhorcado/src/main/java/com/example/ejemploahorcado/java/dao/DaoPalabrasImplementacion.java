package com.example.ejemploahorcado.java.dao;

import com.example.ejemploahorcado.java.common.CategoriaException;
import com.example.ejemploahorcado.java.common.Constantes;
import com.example.ejemploahorcado.java.common.RepeatedException;
import com.example.ejemploahorcado.java.domain.Palabra;

import java.io.IOException;
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
    public String eliminarPalabra(int id) {
        String feedback = Constantes.PALABRANOELIMINADA;
        lista.eliminarPalabra(id);
        if (lista.buscarPalabra(id)!=null)
            feedback = Constantes.PALABRAELIMINADA;
        return feedback;
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
    public void añadirPalabra(String palabra,String categoria) throws RepeatedException, CategoriaException, IOException {
        lista.añadirPalabra(palabra,categoria);
    }

    @Override
    public void cambiarIncognita (int ID, String incognita) throws RepeatedException, IOException {
        lista.cambiarIncognita(ID,incognita);
    }
    /*@Override
    public String cambiarIncognita (int ID, String incognita) {
        String feedback = Constantes.ERRORDESCONOCIDO;
        if (lista.cambiarIncognita(ID,incognita))
            feedback = Constantes.INCOGNITACAMBIADA;
        return feedback;
    }*/

    /*@Override
    public String cambiarCategoria(int ID, String categoria) throws CategoriaException {
        String feedback = Constantes.ERRORDESCONOCIDO;
        if (lista.cambiarCategoria(ID,categoria))
            feedback = Constantes.INCOGNITACAMBIADA;
        return feedback;
    }*/
    @Override
    public void cambiarCategoria(int ID, String categoria) throws CategoriaException, IOException {
        lista.cambiarCategoria(ID,categoria);
    }
    @Override
    public Palabra palabraAleatoria(int dificultad) {
        return lista.palabraAleatoria(dificultad);
    }
    @Override
    public Palabra palabraAleatoria() {
        return lista.palabraAleatoria();
    }
    @Override
    public Palabra palabraAleatoria(String categoria) {
        return lista.palabraAleatoria(categoria);
    }
    @Override
    public boolean buscarPalabra (String incognita) {
        return lista.buscarPalabra(incognita);
    }

}