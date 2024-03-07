package org.example;

public class Salida extends Casilla {

    @Override
    public int avanzar(int dado) {
        return 0;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("Que comienze la partida");
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
