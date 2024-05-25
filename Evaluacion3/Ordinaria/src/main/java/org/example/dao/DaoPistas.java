package org.example.dao;

import org.example.domain.Pista;

import java.util.List;
import java.util.Map;

public interface DaoPistas {

    List<Pista> getListaPistas();

    void setPistas(List<Pista> pistas);

    List<Pista> listadoOrdenadoProvinciaKm();

    boolean addPista(Pista pista);

    double consulta(String provincia);

    boolean addPuebloListaPueblos(int id, String pueblo);

    boolean removePista(int id);

    Map<String,List<Pista>> getPistasProvincia();
}
