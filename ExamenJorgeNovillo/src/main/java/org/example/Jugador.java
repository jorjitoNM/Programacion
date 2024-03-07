package org.example;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private boolean boost;
    public Jugador () {
        this.nombre = pedirNombre();
    }
    public String pedirNombre () {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        do {
            System.out.println("Introduzca su nombre:");
            nombre = teclado.nextLine();
        }while (nombre.length()<3);
        return nombre;
    }

    public boolean isBoost() {
        return boost;
    }
    public void setBoost(boolean boost) {
        this.boost = boost;
    }

    public int filaJugador (Juego partida) {
        if (partida.darTurno())
            return 0;
        else
            return 1;
    }
    @Override
    public String toString() {
        return String.format("%c%c%c",nombre.toUpperCase().charAt(0),nombre.charAt(1),nombre.charAt(2));
    }

    public String getNombre() {
        return nombre;
    }
}
