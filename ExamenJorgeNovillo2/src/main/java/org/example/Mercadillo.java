package org.example;

public class Mercadillo extends Casilla {
    @Override
    public int avanzar(int dado) {
        return dado-10;
    }

    public Mercadillo(Juego partida) {
        super(partida);
    }

    @Override
    public String lanzarMensaje() {
        return "¿Pero a donde vas?";
    }

    @Override
    public String toString() {
        return " M ";
    }
}
