package org.example;

public abstract class Carta {
    protected String tipo;
    protected int puntos;
    private static String[] tipos = {"Tijera","Piedra","Papel"};

    public Carta () {
        tipo = tipos[(int)(Math.random()*3)];
        puntos = calcularValor();
    }
    public Carta (String tipo) {
        this.tipo = tipo;
        puntos = calcularValor();
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

    public static String[] getTipos() {
        return tipos;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "tipo='" + tipo + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
