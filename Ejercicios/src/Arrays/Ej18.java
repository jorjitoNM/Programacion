package Arrays;

import java.io.IOException;

public class Ej18 {
    public static void main(String[] args) throws IOException {
        char[] letras = new char[100];
        boolean exit = false;
        int contador = 0;
        boolean stop = false;
        int aux;
        System.out.println("Escribe");
        for (int i = 0; i < letras.length && letras[i]!=10;) {
            letras[i] = (char) System.in.read();
            if (letras[i]!=10) {
                i++;
            }
        }
        for (int i = 0; i < letras.length && exit==false; i++) {
            contador = 0;
            aux = i;
            stop = false;
            if (letras[i]=='s' || letras[i]=='S') {
                contador++;
                i++;
                stop = true;
            }
            if ((letras[i]=='t'|| letras[i]=='T') && contador==1) {
                contador++;
                i++;
            }
            if ((letras[i]=='o' || letras[i]=='O') && contador==2) {
                contador++;
                i++;
            }
            if ((letras[i]=='p' || letras[i]=='P') && contador==3) {
                exit = true;
            }
            if (exit==false) {
                i = aux;
                System.out.print(letras[i]);
            }

        }
    }
}
