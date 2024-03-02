package org.example;

public class Bicicleta extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado;
    }

    @Override
    public String lanzarMensaje() {
        return "No hay quien te pare";
    }

    @Override
    public String toString() {
        return " B ";
    }
}
