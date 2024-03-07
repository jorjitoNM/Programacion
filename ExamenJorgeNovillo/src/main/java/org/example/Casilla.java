package org.example;

public abstract class Casilla {
    public Casilla() {
    }
    public abstract int avanzar(int dado);

    public abstract void lanzarMensaje();
    public abstract boolean cambiarTurno ();
    public abstract void accion (Juego partida);
    @Override
    public String toString() {
        return String.format("  %s  ",getClass().getSimpleName().charAt(0));
    }
}
