package org.example;

public class Bicicleta extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado;
    }

    public Bicicleta(Juego partida) {
        super(partida);
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
