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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Juego { //tengo que guardar los errores y las palabras que se han intentado
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    //private Palabra incognita; //o el String directamente
    private Jugador jugador;
    private int ronda = 0;
    private int puntos = 0;
    //mitad de puntos al usuario que introduzca la categoria
    private Palabra palabra;
    private final int ID;
    public Juego (Palabra palabra) throws ErrorEntradaException, IOException {
        DaoPalabrasFicheros.crearFicheroPartida();
        nuevaRonda(palabra);
        ID = Utilities.darIDPartida();
    }
    public Juego (String palabra) throws ErrorEntradaException, IOException {
        DaoPalabrasFicheros.crearFicheroPartida();
        nuevaRondaPersonalizada(palabra);
        ID = Utilities.darIDPartida();
    }
    public void nuevaRonda (Palabra palabra) throws ErrorEntradaException, IOException {
        System.out.println(Constantes.RONDA + ronda);
        this.palabra = palabra;
        String incognita = palabra.getIncognita();
        System.out.println(incognita);
        boolean[] aciertos = new boolean[incognita.length()];
        Arrays.fill(aciertos,false);
        int contador = 0;
        System.out.println(imprimirRayas(aciertos,incognita));
        do {
            System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita)); //aqui no esta pidiendo letra
            contador++;
        }while (!finRonda(aciertos) || contador < 8);
        if (finRonda(aciertos)) {
            puntos += calcularPuntos(palabra);
            System.out.println(Constantes.VICTORIA + puntos);
        }
        ronda++;
    }
    public void nuevaRondaPersonalizada (String incognita) throws ErrorEntradaException, IOException {
        palabra.setIncognita(incognita);
        System.out.println(incognita);
        boolean[] aciertos = new boolean[incognita.length()];
        Arrays.fill(aciertos,false);
        int contador = 0;
        System.out.println(imprimirRayas(aciertos,incognita));
        do {
            System.out.println(imprimirRayas(buscarLetra(aciertos,incognita),incognita));
            contador++;
        }while (!finRonda(aciertos) || contador < 8);
        if (finRonda(aciertos)) {
            puntos += calcularPuntosPersonalizado(incognita);
            System.out.println(Constantes.VICTORIA + puntos);
        }
    }
    private String imprimirRayas (boolean[] aciertos, String incognita) throws IOException {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < incognita.length(); i++) {
            if (incognita.charAt(i)==32) {
                palabra.append("   ");
                aciertos[i] = true;
            }
            if (!aciertos[i])
                palabra.append(" _ ");
            else
                palabra.append(" ").append(incognita.charAt(i)).append(" ");
        }
        imprimirMuñeco(aciertos);
        DaoPalabrasFicheros.guardarPartida(this);
        return palabra.toString();
    }
    private boolean[] buscarLetra (boolean[] aciertos,String incognita) throws ErrorEntradaException {
        String intento = validarIntento(incognita);
        boolean exit = false;
        if (intento.length()==1) {
            ArrayList<Integer> coincidencias = new ArrayList<>();
            for (int i = 0; i < incognita.length(); i++) {
                if (Character.toLowerCase(intento.charAt(0))==Character.toLowerCase(incognita.charAt(i)))
                    coincidencias.add(i);
            }
            for (int i = 0; i < coincidencias.size(); i++) {
                aciertos[coincidencias.get(i)] = true;
            }
        } else if (intento.length() == incognita.length()) {
            for (int i = 0; i < incognita.length() && !exit; i++) {
                if (Character.toLowerCase(intento.charAt(i))!=Character.toLowerCase(incognita.charAt(i)))
                    exit = true;
            }
            if (!exit) {
                Arrays.fill(aciertos, true);
            }
        }
        return aciertos;
    }
    private String validarIntento (String incognita) throws ErrorEntradaException {
        String intento = MenuUsuario.getIntento();
        if (intento.length()>incognita.length() || intento.length()>1)
            throw new ErrorEntradaException();
        return intento;
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
    private int calcularPuntosPersonalizado (String incognita) {
        int puntos = 0;
        for (int i = 0; i < incognita.length(); i++) {
            puntos++;
        }
        return puntos*Utilities.asignarNivel(incognita);
    }
}