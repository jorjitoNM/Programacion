package org.example;

import java.util.Scanner;

public class Juego {
    Scanner teclado = new Scanner(System.in);
    private int turno  = 0;
    private Jugador jugador1;
    private Jugador jugador2;
    public boolean darTurno () {
        return turno % 2 == 0;
    }
    public String darTurnoString () {
        return (turno % 2 == 0)?jugador1.getNombre():jugador2.getNombre();
    }
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
    public boolean finalizarPartida () {
        String respuesta;
        System.out.println("Vas a abandonar la partida, estas seguro de que quieres salir?");
        respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("Si")|| respuesta.equalsIgnoreCase("si"))
            return true;
        else
            return true;
    }
    public boolean continuar () {
        String respuesta;
        System.out.println("¿Desea continuar? (s/n)");
        respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("s"))
            return true;
        else
            return false;
    }
}
