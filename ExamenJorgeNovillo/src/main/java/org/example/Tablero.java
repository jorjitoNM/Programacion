package org.example;

import java.util.Scanner;

public class Tablero {
    private Casilla[] casillas = new Casilla[96];
    private Jugador[][] jugadores = new Jugador[2][96];
    public Tablero (Juego partida) {
        casillas[0] = new Salida();
        casillas[10] = new Bicicleta();
        casillas[40] = new Bicicleta();
        casillas[60] = new Bicicleta();
        casillas[94] = new Drogas();
        casillas[95] = new Final();

        for (int i = 16; i < 81; i+=16) {
            casillas[i] = new Atajo();
        }
        for (int i = 14; i < 79; i+=16) {
            casillas[i] = new Mercadillo();
        }
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i]==null)
                casillas[i] = new Corre();
        }
        jugadores[0][0] = partida.getJugador1();
        jugadores[1][0] = partida.getJugador2();
    }
    public void pintarTablero () {
        boolean exit = false;
        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < 16 && !exit; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 16 && !exit; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
        }
        System.out.println();
        for (; j < 16; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 32; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 32; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
        }
        System.out.println();
        for (; j < 32; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 48; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 48; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
        }
        System.out.println();
        for (; j < 48; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 64; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 64; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
        }
        System.out.println();
        for (; j < 64; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 80; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 80; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
        }
        System.out.println();
        for (; j < 80; j++) {
            System.out.printf(" %d ",j);
        }
        System.out.println();
        for (; i < 96; i++) {
            if (jugadores[0][i]!=null)
                System.out.print(jugadores[0][i].toString());
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (; k < 96; k++) {
            if (jugadores[1][k]!=null)
                System.out.print(jugadores[1][k].toString());
            else
                System.out.print(casillas[k].toString());
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
        System.out.println(partida.getJugador1().getNombre() + " en la casilla " + devuelveCasillaPeronsalizada(partida,0));
        System.out.println(partida.getJugador2().getNombre() + " en la casilla " + devuelveCasillaPeronsalizada(partida,1));
        System.out.println("Turno de " + partida.darTurnoString());
        System.out.println("¿Desea continuar? (s/n)");
        respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            int tirada = (int)(Math.random()*10+1);
            System.out.println("Dado: " + tirada);
            mover(partida,tirada);
            System.out.println("Casilla nueva: " + devuelveCasilla(partida));
            System.out.println(casillas[devuelveCasilla(partida)].lanzarMensaje());
            if (devuelveCasilla(partida)==95) {
                System.out.println("Has ganado " + partida.devuelveJugador());
                exit = true;
            }
            if (casillas[devuelveCasilla(partida)].cambiarTurno())
                partida.siguienteTurno();
            pintarTablero();
        }
        else
            exit = true;
        return exit;
    }
    public int devuelveCasilla (Juego partida) {
        for (int i = 0; i < jugadores[0].length; i++) {
            if (jugadores[partida.devuelveJugador().filaJugador(partida)][i]!=null)
               return i;
        }
        return 0;
    }
    public int devuelveCasillaPeronsalizada (Juego partida,int jugador) {
        for (int i = 0; i < jugadores[jugador].length; i++) {
            if (jugadores[jugador][i]!=null)
                return i;
        }
        return 0;
    }
    public Casilla dimeCasilla (Juego partida) {
        return casillas[devuelveCasilla(partida)];
    }
    public void ponerJugador (Juego partida, int casilla) {
        jugadores[partida.devuelveJugador().filaJugador(partida)][casilla] = partida.devuelveJugador();
    }
    public void quitarJugador (Juego partida, int casilla) {
        jugadores[partida.devuelveJugador().filaJugador(partida)][casilla] = null;
    }
    public void mover (Juego partida, int destino) {
        int casilla = devuelveCasilla(partida);
        if ((casilla+destino) > 95)
            destino = 95-destino;
        if (partida.devuelveJugador().isBoost())
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
}