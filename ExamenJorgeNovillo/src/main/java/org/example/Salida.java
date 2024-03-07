package org.example;

public class Salida extends Casilla {

    @Override
    public int avanzar(int dado) {
        return 0;
    }

    @Override
    public String lanzarMensaje() {
        return "Que comienze la partida";
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s",getClass().getSimpleName().charAt(0));
    }
}
