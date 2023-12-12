package Arrays;

import java.io.IOException;

public class Ej16 {
    public static void main(String[] args) throws IOException {
        char[] letras = new char [10];
        boolean exit = false;
        boolean fin = false;
        int j = 0;
        System.out.println("Introduzca una palabra");
        for (int i = 0; i < letras.length && fin==false; i++,j++) {
            letras[i] = (char)System.in.read();
            System.out.print(letras[i]);
            if (letras[i]==10) {
                fin=true;
                j--;
            }
        }
        System.out.println(j);
        int tamaño = j;
        j--;
        for (int i = 0; i < tamaño/2 && exit==false; i++,j--)  {
            if(letras[i]!=letras[j]) {
                exit=true;
            }
        }
        if (exit==false) {
            for (int i = 0; i < tamaño; i++) {
                System.out.print(letras[i]);
            }
            System.out.printf("\nes paíndromo\n");
        }
        else {
            for (int i = 0; i < tamaño; i++) {
                System.out.print(letras[i]);
            }
            System.out.print(" no es palíndromo");
        }
    }
}
