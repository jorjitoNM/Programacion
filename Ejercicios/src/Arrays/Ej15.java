package Arrays;

import java.io.IOException;

public class Ej15 {
    public static void main(String[] args) throws IOException {
        char caracter;
        int contador = 0;
        int letras [] = new int [contador];
        System.out.print("Escribe");
        for (int i = 0; letras[i]!=10; i++) {
            letras[i] = System.in.read();
        }
        for (int i = 0; i < letras.length; i++) {
            /*if (letras[i]==97||letras[i]==101||letras[i]==105||letras[i]==111||letras[i]==117||letras[i]==65||letras[i]==69||letras[i]==73||letras[i]==79||letras[i]=85) {
                    letras[i] = 42;
            }
            */
        }
        for (int i = 0; i < letras.length; i++) {
            System.out.print((char)letras[i]);
        }
    }
}
