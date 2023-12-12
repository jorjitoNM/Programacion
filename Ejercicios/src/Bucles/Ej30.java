package Bucles;

import java.util.Scanner;

public class Ej30 {
    public static void main(String[] args) {


    int numero;
    int suma;
    Scanner teclado = new Scanner(System.in);

    for (suma=0;suma<=50;) {
        System.out.println("Introduzca un número");
        numero = teclado.nextInt();
        suma+=numero;
        System.out.println("Vas por " + suma);
    }
    teclado.close();
}
}