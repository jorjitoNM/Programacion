package Arrays;

import java.io.IOException;

public class Ej20 {
    public static void main(String[] args) throws IOException {
        char[] letras = new char[50];
        System.out.println("Escribe");
        for (int i = 0; i < letras.length; i++) {
            letras[i] = (char)System.in.read();
            System.out.print(letras[i]);
        }
        for (int i = 0; i < letras.length; i++) {
            if ((letras[i]>=97&&letras[i]<=122)) {
                letras[i] = (char)(letras[i] - 32);
            }
            else {
                if ((letras[i]<65)||(letras[i]>122)) {
                    letras[i] = '-';
                }
            }
        }
        System.out.println();
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
        }
    }
}
