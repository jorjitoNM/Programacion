package Bucles;

import java.util.Scanner;

public class Ej32 {
    public static void main(String[] args) {
        int numero;
        int suma;
        Scanner teclado = new Scanner(System.in);

        for(suma=0;suma<30;) {
            System.out.println("Introduzca un número");
            numero = teclado.nextInt();
            if ((numero%6==0)||(numero%3==0)) {
                suma+=numero;
            }
            System.out.println("Llevas " + suma);
        }
        teclado.close();
    }
}
