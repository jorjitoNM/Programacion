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
    public void pintarFila (int comienzo, int fin) {
        int i = comienzo;
        for (; i < fin ; i++) {
            if (jugadores[0][i]!=null) {
                System.out.print(jugadores[0][i].toString());
            }
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (i = comienzo; i < fin; i++) {
            if (   jugadores[1][i] != null) {
                System.out.print(jugadores[1][i].toString());
            }
            else
                System.out.print(casillas[i].toString());
        }
        System.out.println();
        for (i = comienzo; i < fin; i++) {
            System.out.printf(" %3d ",i);
        }
        System.out.println();
    }
    public void pintarTablero () {
        for (int i = 0; i < casillas.length; i+=16) {
            pintarFila(i,i+16);
        }
    }
    public boolean turno (Juego partida) {
        boolean exit = false;
        boolean turnoExtra = false;
        System.out.println(partida.getJugador1().getNombre() + " en la casilla " + devuelveCasillaPeronsalizada(partida,0));
        System.out.println(partida.getJugador2().getNombre() + " en la casilla " + devuelveCasillaPeronsalizada(partida,1));
        if (turnoExtra)
            partida.siguienteTurno();
        System.out.println("Turno de " + partida.darTurnoString());
        if (partida.continuar()) {
            int tirada = (int)(Math.random()*10+1);
            System.out.println("Dado: " + tirada);
            mover(partida,tirada);
            System.out.println("Casilla nueva: " + devuelveCasilla(partida));
            dimeCasilla(partida).accion(partida); //no etra nunca al mercadillo
            if (devuelveCasilla(partida)==95) {
                System.out.println("Has ganado " + partida.devuelveJugador());
                exit = true;
            }
            if (casillas[devuelveCasilla(partida)].cambiarTurno()) {
                if (partida.devuelveJugador().isBloquearTurno())
                    turnoExtra = true;
                partida.siguienteTurno();
            }
            pintarTablero();
        } else
            if (partida.finalizarPartida())
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
            destino = 95-(destino+casilla)+(95-casilla);
        if (partida.devuelveJugador().isBoost())
            destino = destino*2;
        else {
            destino = casillas[(casilla+destino)].avanzar(destino);
        }
        quitarJugador(partida,casilla);
        ponerJugador(partida,(casilla+destino));
    }
}