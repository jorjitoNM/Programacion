package org.example;

public class Mercadillo extends Casilla {
    @Override
    public int avanzar(int dado) {
        return dado-10;
    }

    @Override
    public String lanzarMensaje() {
        return "¿Pero a donde vas?";
    }

    @Override
    public String toString() {
        return " M ";
    }
}
