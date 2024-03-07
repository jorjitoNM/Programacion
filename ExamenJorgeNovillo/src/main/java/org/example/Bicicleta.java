package org.example;

public class Bicicleta extends Casilla {

    @Override
    public int avanzar(int dado) {
        return dado;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("No hay quien te pare");
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }
    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
        setBoost(partida);
    }
    public void setBoost (Juego partida) {
        partida.devuelveJugador().setBoost(true);
    }
}
