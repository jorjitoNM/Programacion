package org.example;

public class Salida extends Casilla {

    @Override
    public int avanzar(int dado) {
        return 0;
    }
    public Salida(Juego partida) {
        super(partida);
    }
    @Override
    public String lanzarMensaje() {
        return "Que comienze la partida";
    }

    @Override
    public String toString() {
        return " S ";
    }
}
