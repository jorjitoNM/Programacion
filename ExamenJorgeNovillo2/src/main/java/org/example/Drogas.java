package org.example;

public class Drogas extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado-94;
    }

    public Drogas(Juego partida) {
        super(partida);
    }

    @Override
    public String lanzarMensaje() {
        return "Drogas No!!" ;
    }

    @Override
    public String toString() {
        return " D ";
    }
}
