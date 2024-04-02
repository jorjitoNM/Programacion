package dao;

import domain.Palabra;

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
    public String eliminarPalabra() ;
    public List<Palabra> ordenarDiccionario (boolean ascendente) ;
    public String añadirPalabra (String palabra,String categoria) ;
    public String cambiarIncognita (int ID, String incognita) ;
    public String cambiarCategoria (int ID, String categoria) ;
    public void nuevaPartida();
    public void nuevaPartida(int dificultad);
    public Palabra palabraAleatoria(int dificultad);
    public Palabra palabraAleatoria();
}
