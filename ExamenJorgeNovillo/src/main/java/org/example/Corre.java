package org.example;

public class Corre extends Casilla{
    @Override
    public int avanzar(int dado) {
        return dado;
    }

    @Override
    public String lanzarMensaje() {
        return "Corre corre que te pillan";
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }

    @Override
    public String toString() {
        return " / ";
    }
}
