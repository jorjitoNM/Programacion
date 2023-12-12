package Arrays;

import java.io.IOException;

public class Ej26 {
    public static void main(String[] args) throws IOException {
        char[] palabra = new char[15];
        boolean exit = false;
        char aux;
        boolean invalido = false;
        boolean enter = false;

        System.out.println("Introduzca una palabra");
        for (int i = 0; i < palabra.length && enter==false; i++) {
            palabra[i] = (char)System.in.read();
            if (invalido==true) {
                i--;
            }
            if ((palabra[i]>=65&&palabra[i]<=90)||(palabra[i]>=90&&palabra[i]<=122)) {
                invalido = false;
            }
            else {
                if (palabra[i]==10) {
                    enter = true;
                    palabra[i] = 0;
                }
                else {
                    if (palabra[i]==32) {
                        palabra[i] = 0;
                    }
                    else {
                        System.out.println("Introduzca un carácter válido");
                        if (i!=0) {
                            i--;
                        }
                        else {
                            invalido = true;
                        }
                    }
                }
            }
        }


        for (int i = 0; exit==false ; i++) {
            exit = true;
            for (int j = 0; j < palabra.length-1; j++) {
                if (palabra[j]>palabra[j+1]) {
                    aux = palabra[j];
                    palabra[j] = palabra[j+1];
                    palabra[j+1] = aux;
                    exit = false;
                }
            }
        }
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i]!=0) {
                System.out.print(palabra[i] + "-");
            }
        }
    }
}
