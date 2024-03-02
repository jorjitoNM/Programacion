package org.example;

import java.util.Arrays;

public class Baraja {
    Carta[] baraja = new Carta[24];

    /*public Baraja () {
        int contadorV = 0;
        int contadorA = 0;
        do {
            int random = (int) (Math.random() * baraja.length / 2);
            if (baraja[random] == null) {
                baraja[random] = new Verde();
                contadorV++;
            }
        }while(contadorV < baraja.length/2);
        do {
            int random = (int) (Math.random() * baraja.length / 2);
            if (baraja[random] == null) {
                baraja[random] = new Azul();
                contadorV++;
            }
        }while(contadorV < baraja.length/2);
    }*/
    public Baraja () {
        int contadorV = 0;
        int contadorA = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                baraja[contadorV] = new Verde(Carta.getTipos()[i]);
                contadorV++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                baraja[contadorA] = new Azul(Carta.getTipos()[i]);
                contadorA++;
            }
        }
    }

    @Override
    public String toString() {
        return "Baraja{" +
                "baraja=" + Arrays.toString(baraja) + '}';
    }
}
