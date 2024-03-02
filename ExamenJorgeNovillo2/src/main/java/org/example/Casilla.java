package org.example;

public abstract class Casilla {
    protected Jugador jugador1;
    protected Jugador jugador2;

    public Casilla(Juego partida) {
        this.jugador1 = partida.getJugador1();
        this.jugador2 = partida.getJugador2();
    }

    public abstract int avanzar(int dado);

    public abstract String lanzarMensaje();

    public boolean hayJugador1() {
        return jugador1.isEsta();
    }

    public void setJugador1(boolean jugador1) {
        this.jugador1.setEsta(jugador1);
    }

    public boolean hayJugador2() {
        return jugador2.isEsta();
    }

    public void setJugador2(boolean jugador2) {
        this.jugador2.setEsta(jugador2);
    }
    public Jugador devuelveJugador1 () {
        return jugador1;
    }
    public Jugador devuelveJugador2 () {
        return jugador2;
    }
}