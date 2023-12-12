package Arrays;

import java.io.IOException;

public class Ej17 {
    public static void main(String[] args) throws IOException {
        char[] letras = new char[100];
        boolean exit = false;
        int palabras = 1;
        boolean espacio = false;
        System.out.println("Escriba");
        int j = 0;
        for (int i = 0; i < letras.length && exit==false; i++,j++) {
            letras[i]= (char) System.in.read();
            if (letras[i]==10) {
                exit=true;
            }
        }
        j--;
        for (int i = 0; i < j; i++) {
            if (letras[i]==32) {
                palabras++;
            }
        }
        System.out.println("Ha introducido "  + palabras + " palabras");

    }
}
