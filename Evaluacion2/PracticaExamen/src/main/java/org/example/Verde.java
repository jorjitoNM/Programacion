package org.example;

public class Verde extends Carta{

    @Override
    public int calcularValor() {
        int puntos = 0;
        if (tipo.equalsIgnoreCase("piedra"))
            puntos = 3;
        else if (tipo.equalsIgnoreCase("papel"))
            puntos = 2;
        else
            puntos = 1;
        return puntos;
    }
}
