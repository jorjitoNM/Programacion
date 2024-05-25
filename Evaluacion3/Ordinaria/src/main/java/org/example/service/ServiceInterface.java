package org.example.service;

import org.example.common.DificultadException;
import org.example.domain.Pista;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ServiceInterface {
    String getListaPistas();
    String getListaPistas(String tipo);
    boolean addPista(Pista pista) throws DificultadException;
    boolean addPuebloListaPueblos(int id, String pueblo);
    Map<String,List<Pista>> getPistasProvincia();
}