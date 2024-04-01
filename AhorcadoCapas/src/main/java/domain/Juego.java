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
    private Palabras diccionario;
    public Juego () {
        diccionario = new Palabras();
        nuevaPartida();
    }

    public void nuevaPartida () {
        Scanner teclado = new Scanner(System.in);
        boolean exit;
        do{
            exit = false;
            System.out.println(Constantes.NUEVARONDA);
            if (teclado.nextLine().equalsIgnoreCase("si")) {
                exit = true;
                nuevaRonda();
                ronda++;
            }
        }while(exit);

    }
    private void nuevaRonda () {
        Palabra palabra = diccionario.palabraAleatoria();
        String incognita = palabra.getIncognita();
        System.out.println(incognita);
        boolean[] aciertos = new boolean[incognita.length()];
        int contador = 0;
        //Character incognita[] = new Character[];
        System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita)); //aqui iria la ejecucion inicial
        do {
            System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita)); //aqui no esta pidiendo letra
            contador++;
        }while (!finRonda(aciertos) || contador < 8);
        if (finRonda(aciertos))
            System.out.println(Constantes.VICTORIA + calcularPuntos(palabra));
    }
    private void nuevaRonda (int dificultad) {

    }
    private String imprimirRayas (boolean[] adivinadas, String incognita) {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < incognita.length(); i++) {
            if (incognita.charAt(i)==32) { //se puede optimizar con una ejecucion o tratamiento incial de la palabra en otro metodo, quizas cuando la imprimo
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
        System.out.print(Constantes.MUÑECO1); //podria hacer como en la ruta de las piezas del ajedrez y ponerle el nuemro que es??, luego incluso puedo tratarlo con una excepcion propia
    }
    private int calcularPuntos (Palabra palabra) {
        int puntos = 0;
        for (int i = 0; i < palabra.getIncognita().length(); i++) {
            puntos++;
        }
        return puntos*palabra.getLevel();
    }
}
