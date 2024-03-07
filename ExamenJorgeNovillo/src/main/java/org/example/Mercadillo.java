package org.example;

public class Mercadillo extends Casilla {
    @Override
    public int avanzar(int dado) {
        return dado-10;
    }

    @Override
    public String lanzarMensaje() {
        return "¿Pero a donde vas?";
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s",getClass().getSimpleName().charAt(0));
    }
    public void turnoExtra () {

    }
}
