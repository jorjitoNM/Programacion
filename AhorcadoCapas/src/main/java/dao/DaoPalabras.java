package dao;

import common.CategoriaException;
import common.RepeatedException;
import domain.Palabra;

import java.io.IOException;
import java.util.List;

public interface DaoPalabras {
    public boolean isEmptyPalabrasList() ;
    public boolean insertarPalabra(Palabra Palabra) ;
    public boolean insertarPalabra(int id, int level, String incognita, String categoria);
    public List<Palabra> getPalabrasCategoria(String categoria);
    public List<Palabra> getPalabrasNivelCategoria(int nivel, String categoria);
    public List<Palabra> getPalabrasNivel (int nivel);
    public List<Palabra> getPalabras(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria);
    public boolean modificarPalabra(int id, String incognita);
    public void eliminarPalabra(Palabra Palabra) ;
    public String eliminarPalabra(int id) ;
    public List<Palabra> ordenarDiccionario (boolean ascendente) ;
    public void añadirPalabra (String palabra,String categoria) throws RepeatedException, CategoriaException, IOException;
    public void cambiarIncognita (int ID, String incognita) throws RepeatedException, IOException;
    //public String cambiarIncognita (int ID, String incognita) ;
    //public String cambiarCategoria (int ID, String categoria) ;
    public void cambiarCategoria (int ID, String categoria) throws CategoriaException, IOException;
    public Palabra palabraAleatoria(int dificultad);
    public Palabra palabraAleatoria();
    public Palabra palabraAleatoria(String categoria);
    public boolean buscarPalabra (String incognita);
}
