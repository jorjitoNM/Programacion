package domain;

import common.Constantes;
import dao.Palabras;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    //private Palabra incognita; //o el String directamente
    private Jugador jugador;
    private int ronda;
    private int puntos = 0;
    private Palabra palabra;
    public Juego (Palabra palabra) {
        this.palabra = palabra;
        nuevaPartida();
    }

    public void nuevaPartida () {
        Scanner teclado = new Scanner(System.in);
        boolean exit;
        do{
            exit = false;
            System.out.println(Constantes.NUEVARONDA);
            if (teclado.nextLine().equalsIgnoreCase("si")) {
                System.out.println(Constantes.RONDA + ronda);
                exit = true;
                nuevaRonda();
                ronda++;
            }
        }while(exit);
    }
    private void nuevaRonda () {
        String incognita = palabra.getIncognita();
        System.out.println(incognita);
        boolean[] aciertos = new boolean[incognita.length()];
        int contador = 0;
        //Character incognita[] = new Character[];
        System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita));
        do {
            System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita)); //aqui no esta pidiendo letra
            contador++;
        }while (!finRonda(aciertos) || contador < 8);
        if (finRonda(aciertos)) {
            puntos += calcularPuntos(palabra);
            System.out.println(Constantes.VICTORIA + puntos);
        }
    }
    private String imprimirRayas (boolean[] adivinadas, String incognita) {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < incognita.length(); i++) {
            if (incognita.charAt(i)==32) {
                palabra.append("   ");
                adivinadas[i] = true;
            }
            if (!adivinadas[i])
                palabra.append(" _ ");
            else
                palabra.append(" ").append(incognita.charAt(i)).append(" ");
        }
        imprimirMuñeco(adivinadas);
        return palabra.toString();
    }
    private Character pedirLetra () {
        boolean exit = false;
        Character letra = null;
        System.out.println(Constantes.NUEVALETRA);
        do {
            try {
                letra = (char)System.in.read();
                exit = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while(!exit);
        return letra;
    }
    private boolean[] buscarLetra (boolean[] aciertos,String incognita) {
        Character letra = pedirLetra();
        ArrayList<Integer> coincidencias = new ArrayList<>();
        for (int i = 0; i < incognita.length(); i++) {
            if (letra.equals(incognita.charAt(i)))
                coincidencias.add(i);
        }
        for (int i = 0; i < coincidencias.size(); i++) {
            aciertos[coincidencias.get(i)] = true;
        }
        return aciertos;
    }
    private boolean finRonda (boolean[] aciertos) {
        boolean exit = true;
        for (int i = 0; i < aciertos.length && exit; i++) {
            if (!aciertos[i])
                exit = false;
        }
        return exit;
    }
    private void imprimirMuñeco(boolean[] aciertos){
        int contador = 0;
        for (int i = 0; i < aciertos.length; i++) {
            if (aciertos[i])
                contador++;
        }
        System.out.print(Constantes.MUÑECOS[contador]);
    }
    private int calcularPuntos (Palabra palabra) {
        int puntos = 0;
        for (int i = 0; i < palabra.getIncognita().length(); i++) {
            puntos++;
        }
        return puntos*palabra.getLevel();
    }
}
