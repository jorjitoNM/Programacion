package org.example;

public class Baraja {
    Carta[] baraja = new Carta[24];

    public Baraja () {
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
    }
}
