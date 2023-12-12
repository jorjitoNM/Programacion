package PracticaExamen;

import java.io.IOException;
import java.util.Scanner;

public class Menutipoexamen {
    public static void main(String[] args) throws IOException {
        int numeros;
        char opcion;
        boolean exitA = false;
        int suma = 0;
        String apellido2;
        String apellido1;
        String nombre;
        String DNI;
        String aux;
        StringBuilder usuario;
        boolean exitstr = false;
        boolean exitC = false;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("-Introduzca 'A' para comenzar sumar los números que quieras\n-Introduzca 'B' para convertir el texto que desee, limpio y a mayusculas\n-Introduzca 'C' para pedir saber tu usuario de educamadrid\n-Introduzca 'D' para salir del menu");
            opcion = (char) System.in.read();
            System.in.read();
            switch (opcion) {
                case 'A':
                case 'a':
                    System.out.println("Introduzca los números que desee");
                    do {
                        numeros = teclado.nextInt();
                        for (int i = 2; exitA == false && i < numeros / 2; i++) {
                            if (numeros % i == 0) {
                                exitA = true;
                            }
                        }
                        if (exitA == false) {
                            suma += numeros;
                        }
                        else {
                            exitA = false;
                        }
                    } while ((numeros != -1) && (numeros != 1));
                    if (numeros == 1) {
                        suma += -1;
                    }
                    else {
                        suma += 1;
                    }
                    System.out.println("La suma de los números primos introducidos es " + suma);
                    break;
                case 'B':
                case 'b':
                    System.out.println("Introduzca un texto para que se lo limpie y lo ponga en mayúscualas");
                    do {
                        opcion = (char) System.in.read();
                        if ((opcion >= 97) && (opcion <= 122)) {
                            opcion -= 32;
                            System.out.print(opcion);
                        }
                        else {
                            if ((opcion >= 65) && (opcion <= 90)) {
                                System.out.print(opcion);
                            }
                        }
                    } while ((opcion != 10) && (opcion != 46));
                    System.out.println();
                    break;
                case 'C':
                case 'c':
                    System.out.println("Introduzca su nombre");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca su primer apellido");
                    apellido1 = teclado.nextLine();
                    System.out.println("Introduzca su segundo apellido");
                    apellido2 = teclado.nextLine();
                    do {
                        System.out.println("Introduzca su DNI (8 números)");
                        aux = teclado.nextLine();
                        if (aux.length() == 8) {
                            for (int i = 0; i < aux.length() && exitstr == false; i++) {
                                if (!(Character.isDigit(aux.charAt(i)))) {
                                    exitstr = true;
                                }
                            }
                            if (exitstr == false) {
                                exitC = true;
                            }
                        }
                    } while (exitC != true);
                    DNI = aux;
                    usuario = new StringBuilder(nombre.toLowerCase().substring(0,1)).append(apellido1.toLowerCase(), 0, 3).append(apellido2.toLowerCase(), 0, 3).append(DNI.toLowerCase(), 5, 8);
                    System.out.println(usuario);
                    break;
                case 'D':
                case 'd':
                    break;
                default:
                    System.out.println("Introduzca un carácter válido");
            }
        } while (opcion != 'D' && opcion!= 'd');
    }
}
