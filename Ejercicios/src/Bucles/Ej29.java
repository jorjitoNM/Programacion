package Bucles;

import java.io.IOException;

public class Ej29 {
    public static void main(String[] args) throws IOException {
        char letra;
        int mayusculas;
        boolean exit=false;

        for (mayusculas=0; exit==false;) {
            letra = (char)System.in.read();
            if (letra=='.') {
                exit=true;
            }
            else {
                if ((letra=='A')||(letra=='E')||(letra=='I')||(letra=='O')||(letra=='U')||(letra=='a') || (letra=='e') || (letra=='i') || (letra=='o')||(letra=='u')) {
                    mayusculas++;
                }
            }
        }
        System.out.println("Ha introducido " + mayusculas + " letras mayúsculas");

    }
}
