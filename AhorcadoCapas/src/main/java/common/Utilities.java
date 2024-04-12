package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    private static ArrayList<Integer> codigos = new ArrayList<>();
    private static ArrayList<Integer> codigosPartida = new ArrayList<>();
    public static int darID () {
        int id = (int)(Math.random()*1000);
        for (int i = 0; i < codigos.size(); ) {
            if (id == codigos.get(i))
                id = (int)(Math.random()*1000);
            else
                i++;
        }
        codigos.add(id);
        return id;
    }
    public static int darIDPartida () {
        int id = (int)(Math.random()*100);
        for (int i = 0; i < codigosPartida.size(); ) {
            if (id == codigos.get(i))
                id = (int)(Math.random()*100);
            else
                i++;
        }
        codigos.add(id);
        return id;
    }
    public static int asignarNivel (String palabra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (esVocal(palabra.charAt(i)))
                contador++;
        }
        return contador;
    }
    public static boolean esVocal (char letra) {
        boolean esVocal = false;
        switch(letra) {
            case 'A':
            case 'a':
                esVocal = true;
                break;
            case 'E':
            case 'e':
                esVocal = true;
                break;
            case 'I':
            case 'i':
                esVocal = true;
                break;
            case 'O':
            case 'o':
                esVocal = true;
                break;
            case 'U':
            case 'u':
                esVocal = true;
                break;
            default:
        }
        return esVocal;
    }
    public static boolean comfirmarSalida () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.COMFIRMARSALIDA);
        return teclado.nextLine().equalsIgnoreCase("si");
    }
}
