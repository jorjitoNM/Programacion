package org.example;

public class Juego {
    private int turno  = 0;
    private Jugador jugador1;
    private Jugador jugador2;
    public boolean darTurno () {
        return turno % 2 == 0;
    }
    public String darTurnoString () {
        return (turno % 2 == 0)?jugador1.getNombre():jugador2.getNombre();
    }
    /*public Juego (Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
     */
    public Juego () {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
    }
    public Jugador devuelveJugador () {
        if (darTurno()) {
            return jugador1;
        }
        else
            return jugador2;
    }
    public void siguienteTurno () {
        turno++;
    }

    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
}
