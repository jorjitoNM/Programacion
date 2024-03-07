package org.example;

public class Mercadillo extends Casilla {
    @Override
    public int avanzar(int dado) {
        return dado-10;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("¿Pero a donde vas?");
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }
    public void turnoExtra (Juego partida) {
        partida.devuelveJugador().setBloquearTurno(true);
    }
    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
        turnoExtra(partida);
    }
}
