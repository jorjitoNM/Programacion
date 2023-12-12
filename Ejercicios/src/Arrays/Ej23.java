package Arrays;

import java.util.Scanner;

public class Ej23 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int numero;
        int posicion = 0;
        boolean exit = false;
        Scanner teclado = new Scanner(System.in);


        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*11-5);
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        System.out.println("Introduzca un número entero entre -5 y 5");
        numero = teclado.nextInt();
        for (int i = 0; i < numeros.length || exit==true; i++) {
            if (numero==numeros[i]) {
                exit = true;
            }
            posicion = i;
        }
        if (exit==true) {
            System.out.println("El número " + numero + " se encuentra el arrays, concretamente en la posicion " + posicion);
        }
        else {
            System.out.println("El número " + numero + " no se encuentra en el array");
        }
    }
}
