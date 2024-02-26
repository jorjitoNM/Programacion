package org.example;

public abstract class Carta {
    protected String tipo;
    protected int puntos;
    private String[] tipos = {"Tijera","Piedra","Papel"};

    public Carta () {
        this.tipo = tipos[(int)(Math.random()*3)];
        this.puntos = calcularValor();
    }
    public abstract int calcularValor () ;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
