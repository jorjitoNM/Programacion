package org.example;

public class Azul extends Carta {

    @Override
    public int calcularValor() {
        int puntos = 0;
        if (tipo.equalsIgnoreCase("piedra"))
            puntos = 2;
        else if (tipo.equalsIgnoreCase("papel"))
            puntos = 1;
        else
            puntos = 3;
        return puntos;
    }
}
