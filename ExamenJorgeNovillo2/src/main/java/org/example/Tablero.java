package org.example;

import java.util.Scanner;

public class Tablero {
    private Casilla[] casillas = new Casilla[96];
    private Jugador[][] jugadores = new Jugador[2][96];
    public Tablero (Juego partida) {
        casillas[0] = new Salida(partida);
        casillas[10] = new Bicicleta(partida);
        casillas[40] = new Bicicleta(partida);
        casillas[60] = new Bicicleta(partida);
        casillas[94] = new Drogas(partida);
        casillas[95] = new Final(partida);

        for (int i = 16; i < 81; i+=16) {
            casillas[i] = new Atajo(partida);
        }
        for (int i = 14; i < 79; i+=16) {
            casillas[i] = new Mercadillo(partida);
        }
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i]==null)
                casillas[i] = new Corre(partida);
        }
    }
    public void pintarTablero () {
        int i = 0;
        int j = 0;
        for (; i < 16; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 16; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 32; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 32; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 48; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 48; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 64; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 64; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 80; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 80; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 96; i++) {
            System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; j < 96; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
    }
    public boolean turno (Juego partida) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        boolean turno = true;
        String respuesta;
        System.out.println(partida.getJugador1().getNombre() + " en la casilla " + devuelveCasillaPersonalizado(0));
        System.out.println(partida.getJugador2().getNombre() + " en la casilla " + devuelveCasillaPersonalizado(1));
        System.out.println("Turno de " + partida.darTurnoString());
        System.out.println("¿Desea continuar? (s/n)");
        respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            int tirada = (int)(Math.random()*10+1);
            System.out.println("Dado: " + tirada);
            if (dimeCasilla(partida) instanceof Atajo) {
                turno = false;
            }
            mover(partida,tirada);
            System.out.println("Casilla nueva: " + devuelveCasilla(partida));
            System.out.println(casillas[devuelveCasilla(partida)].lanzarMensaje());
            if (turno)
                partida.siguienteTurno();
            pintarTablero();
        }
        else
            exit = true;
        return exit;
    }
    public int devuelveCasillaPersonalizado (int jugador) {
        boolean exit = false;
        if (jugador==0) {
            for (int i = 0; i < casillas.length && !exit; i++) {
                if (casillas[i].hayJugador1()) {
                    exit = true;
                    return i;
                }
            }
        }
        else if (jugador==1) {
            for (int i = 0; i < casillas.length && !exit; i++) {
                if (casillas[i].hayJugador2()) {
                    exit = true;
                    return i;
                }
            }
        }
        return 0;
    }
    public int devuelveCasilla (Juego partida) {
        boolean exit = false;
        if (partida.darTurno()) {
            for (int i = 0; i < casillas.length && !exit; i++) {
                if (casillas[i].hayJugador1()) {
                    exit = true;
                    return i;
                }
            }
        } else {
            for (int i = 0; i < casillas.length && !exit; i++) {
                if (casillas[i].hayJugador2()) {
                    exit = true;
                    return i;
                }
            }
        }
        return 0;
    }
    public void ponerJugador (Juego partida, int casilla) {
        if (partida.darTurno())
            casillas[casilla].setJugador1(true);
        else
            casillas[casilla].setJugador2(true);
    }
    public void quitarJugador (Juego partida, int casilla) {
        if (partida.darTurno())
            casillas[casilla].setJugador1(false);
        else
            casillas[casilla].setJugador2(false);
    }
    public void mover (Juego partida, int destino) {
        int casilla = devuelveCasilla(partida);
        if ((casilla+destino) > 95)
            destino = 95-destino;
        if (casillas[casilla].devuelveJugador1().isBoost())
            destino = destino*2;
        else if (casillas[casilla].devuelveJugador2().isBoost())
            destino = destino*2;
        else {
            if (casillas[casilla] instanceof Mercadillo)
                System.out.println(casillas[casilla].lanzarMensaje());
            destino = casillas[(casilla+destino)].avanzar(destino);
            if (casillas[(casilla+destino)] instanceof Bicicleta)
                partida.devuelveJugador().setBoost(true);
        }
        quitarJugador(partida,casilla);
        ponerJugador(partida,(casilla+destino));
    }
    public Casilla dimeCasilla (Juego partida) {
        return casillas[devuelveCasilla(partida)];
    }
}