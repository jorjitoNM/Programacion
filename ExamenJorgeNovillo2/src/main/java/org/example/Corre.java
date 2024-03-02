package org.example;

public class Corre extends Casilla{
    @Override
    public int avanzar(int dado) {
        return dado;
    }

    public Corre(Juego partida) {
        super(partida);
    }

    @Override
    public String lanzarMensaje() {
        return "Corre corre que te pillan";
    }

    @Override
    public String toString() {

        return " / ";
    }
}
