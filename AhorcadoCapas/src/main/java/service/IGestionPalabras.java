package service;

import common.CategoriaException;
import common.ErrorEntradaException;
import common.RepeatedException;
import domain.Palabra;

import java.io.IOException;
import java.util.List;

public interface IGestionPalabras {
    public boolean isEmptyPalabrasList();
    public List<Palabra> getListaPalabras();
    public boolean insertarPalabra(Palabra Palabra);

    /**
     *
     * @param id
     * @param level
     * @param incognita
     * @param categoria si la categoria no es válida se lanzará una excepción y no será insertado el elememto
     * @return
     * @throws CategoriaException
     */
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Palabra> listar(String categoria);
    public List<Palabra> listar(int nivel, String categoria);
    public List<Palabra> listar (int nivel);
    public List<Palabra> listarPalabras(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException;
    public boolean modificarPalabra(int id, String incognita);

    public List<Palabra> getListaPalabrasCategoria();
    public String eliminarPalabra(int id);
    public void crearFicheros()throws IOException;
    public boolean cargarFichero() throws IOException;
    public boolean escribirFichero();
    public boolean escribirFicheroBinario();
    public boolean cargarFicheroBinario();
    public String ordenarDiccionario (boolean ascendente) ;
    public void añadirPalabra (String palabra,String categoria) throws RepeatedException, CategoriaException, IOException;
    public void cambiarIncognita (int ID, String incognita) throws RepeatedException, IOException;
    //public String cambiarIncognita (int ID, String incognita) ;
    public void cambiarCategoria (int ID, String categoria) throws CategoriaException, IOException;
    //public String cambiarCategoria (int ID, String categoria) ;
    public void nuevaRonda() throws IOException;
    public void nuevaRondaDificultad(int dificultad) throws IOException;
    public void nuevaRondaIncognita(String incognita) throws IOException;
    public void nuevaRondaCategoria(String categoria) throws IOException;
    public void guardarPartida () throws IOException;
    public void retomarPartida (int ID) throws IOException;
}
