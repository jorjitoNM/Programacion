package domain;

import common.Constantes;
import common.ErrorEntradaException;
import common.Utilities;
import dao.DaoPalabrasFicheros;
import dao.Palabras;
import ui.MenuUsuario;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Juego implements Serializable { //tengo que guardar los errores y las palabras que se han intentado
    //private Jugador jugador;
    private int ronda = 0;
    private int errores = 0;
    private int puntos = 0;
    //mitad de puntos al usuario que introduzca la categoria
    private Palabra palabra;
    private boolean[] aciertos;
    private ArrayList<Character> letrasProbadas;
    private final int ID;
    public Juego (Palabra palabra) throws IOException {
        DaoPalabrasFicheros.crearFicheroPartida();
        letrasProbadas = new ArrayList<>();
        ID = Utilities.darIDPartida();
        nuevaRonda(palabra);
    }
    public Juego (String palabra) throws IOException {
        DaoPalabrasFicheros.crearFicheroPartida();
        letrasProbadas = new ArrayList<>();
        ID = Utilities.darIDPartida();
        nuevaRondaPersonalizada(palabra);
    }
    public void nuevaRonda (Palabra palabra) throws IOException {
        errores = 0;
        this.palabra = palabra;
        aciertos = new boolean[palabra.getIncognita().length()];
        Arrays.fill(aciertos,false);
        System.out.println(Constantes.RONDA + ronda);
        System.out.println(palabra.getIncognita());
        System.out.println(imprimirRayas());
        do {
            buscarLetra();
            System.out.println(imprimirRayas());
        }while (!finRonda() || errores < 8);
        if (finRonda()) {
            puntos += calcularPuntos();
            System.out.println(Constantes.VICTORIA + puntos);
            ronda++;
        }
        else {
            System.out.println(Constantes.MENSAJEPERDEDOR + this.palabra.getIncognita());
        }
    }
    public void nuevaRondaPersonalizada (String incognita) throws IOException {
        palabra.setIncognita(incognita);
        errores = 0;
        aciertos = new boolean[incognita.length()];
        Arrays.fill(aciertos,false);
        System.out.println(Constantes.RONDA + ronda);
        System.out.println(incognita);
        System.out.println(imprimirRayas());
        do {
            buscarLetra();
            System.out.println(imprimirRayas());
        }while (!finRonda() || errores < 8);
        if (finRonda()) {
            puntos += calcularPuntosPersonalizado();
            System.out.println(Constantes.VICTORIA + puntos);
            ronda++;
        }
        else {
            System.out.println(Constantes.MENSAJEPERDEDOR + this.palabra.getIncognita());
        }
    }
    public void retomarRonda () throws IOException {
        System.out.println(imprimirRayas());
        do {
            buscarLetra();
            System.out.println(imprimirRayas());
        }while (!finRonda() || errores < 8);
        if (finRonda()) {
            puntos += calcularPuntos();
            System.out.println(Constantes.VICTORIA + puntos);
            ronda++;
        }
        else {
            System.out.println(Constantes.MENSAJEPERDEDOR + this.palabra.getIncognita());
        }
    }
    public void retomarRondaPersonalizada () throws IOException {
        System.out.println(imprimirRayas());
        do {
            buscarLetra();
            System.out.println(imprimirRayas());
        }while (!finRonda() || errores < 8);
        if (finRonda()) {
            puntos += calcularPuntosPersonalizado();
            System.out.println(Constantes.VICTORIA + puntos);
            ronda++;
        }
        else {
            System.out.println(Constantes.MENSAJEPERDEDOR + this.palabra.getIncognita());
        }
    }
    private String imprimirRayas () throws IOException {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < this.palabra.getIncognita().length(); i++) {
            if (this.palabra.getIncognita().charAt(i)==32) {
                palabra.append("   ");
                aciertos[i] = true;
            }
            if (!aciertos[i])
                palabra.append(" _ ");
            else
                palabra.append(" ").append(this.palabra.getIncognita().charAt(i)).append(" ");
        }
        imprimirMuñeco();
        System.out.println(imprimirIntentos());
        DaoPalabrasFicheros.guardarPartida(this);
        return palabra.toString();
    }
    private void buscarLetra () {
        String intento = validarIntento();
        boolean exit = false;
        if (intento.length()==1) {
            ArrayList<Integer> coincidencias = new ArrayList<>();
            for (int i = 0; i < palabra.getIncognita().length(); i++) {
                if (Character.toLowerCase(intento.charAt(0))==Character.toLowerCase(palabra.getIncognita().charAt(i))) {
                    coincidencias.add(i);
                    exit = true;
                }
            }
            if (!exit) {
                letrasProbadas.add(intento.charAt(0));
                errores++;
            }
            for (int i = 0; i < coincidencias.size(); i++) {
                aciertos[coincidencias.get(i)] = true;
            }
        } else if (intento.length() == palabra.getIncognita().length()) {
            if (intento.equalsIgnoreCase(palabra.getIncognita()))
                exit = true;
            if (exit) {
                Arrays.fill(aciertos, true);
                errores = aciertos.length;
            }
        }
    }
    private String validarIntento () {
        String intento = MenuUsuario.getIntento();
        return (intento.length()>palabra.getIncognita().length() || (intento.length()>1&&intento.length()<palabra.getIncognita().length()))?validarIntento():intento;
    }
    private boolean finRonda () {
        boolean exit = true;
        for (int i = 0; i < aciertos.length && exit; i++) {
            if (!aciertos[i])
                exit = false;
        }
        return exit;
    }
    private void imprimirMuñeco(){
        System.out.println(Constantes.MUÑECOS[errores]);
    }
    private int calcularPuntos () {
        int puntos = 0;
        for (int i = 0; i < palabra.getIncognita().length(); i++) {
            puntos++;
        }
        return puntos*palabra.getLevel();
    }
    private int calcularPuntosPersonalizado () {
        int puntos = 0;
        for (int i = 0; i < palabra.getIncognita().length(); i++) {
            puntos++;
        }
        return puntos*Utilities.asignarNivel(palabra.getIncognita());
    }
    private String imprimirIntentos () {
        StringBuilder intentos = new StringBuilder();
        for (int i = 0; i < letrasProbadas.size(); i++) {
            intentos.append(" ").append(letrasProbadas.get(i)).append(" ");
        }
        return intentos.toString();
    }
    public Palabra getPalabra() {
        return palabra;
    }
}