package org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido a la Maraton del Quevedo");
        Juego partida = new Juego();
        Tablero tablero = new Tablero(partida);
        tablero.pintarTablero();
        do {
            tablero.turno(partida);
        } while(!tablero.turno(partida));
    }
}
