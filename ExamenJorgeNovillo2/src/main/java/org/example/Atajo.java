package org.example;

public class Atajo extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado+16;
    }

    public Atajo(Juego partida) {
        super(partida);
    }

    @Override
    public String lanzarMensaje() {
        return "De atajo en atajo porque eres el mas majo";
    }

    @Override
    public String toString() {
        return " A ";
    }
}
