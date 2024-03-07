package org.example;

public class Atajo extends Casilla {
    @Override
    public boolean cambiarTurno() {
        return false;
    }

    @Override
    public int avanzar(int dado) {
        return dado+16;
    }

    @Override
    public String lanzarMensaje() {
        return "De atajo en atajo porque eres el mas majo";
    }

    @Override
    public String toString() {
        return String.format("%s",getClass().getSimpleName().charAt(0));
    }
}
