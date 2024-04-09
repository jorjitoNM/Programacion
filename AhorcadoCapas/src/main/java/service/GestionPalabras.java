package service;

import common.CategoriaException;
import common.ErrorEntradaException;
import common.RepeatedException;
import dao.DaoPalabras;
import dao.DaoPalabrasFicheros;
import dao.DaoPalabrasImplementacion;
import domain.Juego;
import domain.Palabra;

import java.io.IOException;
import java.util.List;

public class GestionPalabras implements IGestionPalabras {
    private final DaoPalabras daoPalabras;
    private Juego partida = null;

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
    public String eliminarPalabra(int id) {
        return daoPalabras.eliminarPalabra(id);
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
    public String ordenarDiccionario(boolean ascendente) {
        return daoPalabras.ordenarDiccionario(ascendente).toString();
    }
    @Override
    public void añadirPalabra(String palabra,String categoria) throws RepeatedException {
        daoPalabras.añadirPalabra(palabra,categoria);
    }
    @Override
    public void cambiarIncognita(int ID, String incognita) throws RepeatedException {
        daoPalabras.cambiarIncognita(ID,incognita);
    }
    /*@Override
    public String cambiarIncognita(int ID, String incognita) {
        return daoPalabras.cambiarIncognita(ID,incognita);
    }*/
    /*@Override
    public String cambiarCategoria(int ID, String categoria) {
        return daoPalabras.cambiarCategoria(ID,categoria);
    }*/
    @Override
    public void cambiarCategoria(int ID, String categoria) throws CategoriaException {
        daoPalabras.cambiarCategoria(ID,categoria);
    }

    @Override
    public void nuevaRonda(int ID) throws ErrorEntradaException, IOException {
        if (ID==-1) {
            if (partida==null)
                partida = new Juego(daoPalabras.palabraAleatoria());
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria());
        } else {
            if (partida==null) {
                partida = DaoPalabrasFicheros.retomarPartida();
                partida.nuevaRonda(daoPalabras.palabraAleatoria());
            }
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria());
        }
    }

    @Override
    public void nuevaRondaDificultad(int ID, int dificultad) throws ErrorEntradaException, IOException {
        if (ID==-1) {
            if (partida==null)
                partida = new Juego(daoPalabras.palabraAleatoria(dificultad));
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria(dificultad));
        } else {
            if (partida==null) {
                partida = DaoPalabrasFicheros.retomarPartida();
                partida.nuevaRonda(daoPalabras.palabraAleatoria(dificultad));
            }
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria(dificultad));
        }
    }

    @Override
    public void nuevaRondaIncognita(int ID, String incognita) throws ErrorEntradaException, IOException {
        if (ID==-1) {
            if (partida==null)
                partida = new Juego(incognita);
            else
                partida.nuevaRondaPersonalizada(incognita);
        } else {
            if (partida==null) {
                partida = DaoPalabrasFicheros.retomarPartida();
                partida.nuevaRondaPersonalizada(incognita);
            }
            else
                partida.nuevaRondaPersonalizada(incognita);
        }
    }

    @Override
    public void nuevaRondaCategoria(int ID, String categoria) throws ErrorEntradaException, IOException {
        if (ID==-1) {
            if (partida==null)
                partida = new Juego(daoPalabras.palabraAleatoria(categoria));
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria(categoria));
        } else {
            if (partida==null) {
                partida = DaoPalabrasFicheros.retomarPartida();
                partida.nuevaRonda(daoPalabras.palabraAleatoria(categoria));
            }
            else
                partida.nuevaRonda(daoPalabras.palabraAleatoria(categoria));
        }
    }
    @Override
    public void guardarPartida() throws IOException {
        DaoPalabrasFicheros.guardarPartida(partida);
    }
}