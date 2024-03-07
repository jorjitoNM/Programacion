package org.example;

public class Drogas extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado-94;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("Drogas No!!");
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }
    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
    }
}
