package org.example;

public class Corre extends Casilla{
    @Override
    public int avanzar(int dado) {
        return dado;
    }

    @Override
    public void lanzarMensaje() {
        System.out.println("Corre corre que te pillan");
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }
    public String toString () {
        return "  /  ";
    }
    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
    }
}
