package Arrays;

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        int numero;
        double hexadecimal [] = new double[4];
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Introduzca un número entre 0 y 3200");
            numero = teclado.nextInt();
        } while(numero<0||numero>3200);
        hexadecimal[0] = (numero%16);
        hexadecimal[1] = ((numero/16)%16);
        hexadecimal[2] = (((numero/16)/16)%16);
        hexadecimal[3] = ((((numero/16)/16)/16)%16);
        for (int i = 0; i < hexadecimal.length; i++) {
           if (hexadecimal[i]>9) {
               hexadecimal[i] = hexadecimal[i]+55;
           }
           else {
               hexadecimal[i] = hexadecimal[i]+48;
           }
        }
        for (int i = (hexadecimal.length-1); i >= 0 ; i--) {
            System.out.print((char)hexadecimal[i] + " ");
        }

// if (numero/16<=9)


    }
}
