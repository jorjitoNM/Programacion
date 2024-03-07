package org.example;

public class Atajo extends Casilla {
    @Override
    public boolean cambiarTurno() {
        return false;
    }

    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
    }

    @Override
    public int avanzar(int dado) {
        return dado+16;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("De atajo en atajo porque eres el mas majo");
    }
}
