package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class Ej27conchar {
    public static void main(String[] args) throws IOException {
        char opcion;
        boolean exit = false;
        char[] codigos = new char[30];
        double[] precio = new double[30];
        double[] top5 = new double[30];
        int buscadoropcion;
        boolean exitbuscador = false;
        char respuesta;
        double aux;
        char auxc;
        int auxi;
        boolean noencontrado = false;
        boolean ordenados = false;
        int posicion;
        int ventas;
        boolean encontrado = false;
        boolean repeticion = true;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Bienvenido a su menu de una tienda deportiva\n-Introduzca 'A' para acceder a imprimir todos los códigos de los articulos con su precio correspondiente\n-Introduzca 'B' para  buscar una articulo por código y decir su precio\n-Introduzca 'C' para listar todos los códigos de las prendas más caras\n-Introduzca 'D' para listar todos los códigos de las prendas más baratas\n-Introduzca 'E' para ordenar las listas por código\n-Introduzca 'F' para borrar algun elemento por su código\n-Introduzca 'G' para calcular las ganancias obtenidas\n-Introduzca 'H' para salir");
            opcion = (char)System.in.read();
            System.in.read();
            switch(opcion) {
                case 'A':
                    for (int i = codigos.length-1; i >= 0; i--) {
                        posicion = (int)(Math.random()*2);
                        if (posicion==0) {
                            do {
                                repeticion = true;
                                auxc = (char) (Math.random()*26+97);
                                for (int j = codigos.length-1; j > i+1 && repeticion==true ; j--) {
                                    if (auxc==codigos[j]) {
                                        repeticion = false;
                                    }
                                }
                            }while(repeticion==false);
                            codigos[i]=auxc;
                            precio[i] = Math.random()*6;
                        }
                        else {
                            do {
                                repeticion = true;
                                auxc = (char) (Math.random()*26+65);
                                for (int j = codigos.length-1; j > i+1 && repeticion==true ; j--) {
                                    if (auxc==codigos[j]) {
                                        repeticion = false;
                                    }
                                }
                            }while(repeticion==false);
                            codigos[i]=auxc;
                            precio[i] = Math.random()*6;
                        }

                    }
                    for (int i = 0; i < codigos.length; i++) {
                        System.out.printf("Producto %d:\n-Codigo:%c\n-Precio:%.2f\n",i+1,codigos[i],precio[i]);
                    }
                    break;
                case 'B':
                    do {
                        System.out.println("\nBienvenido al buscador, introduzca '1' para busca un objeto y '2' para salir");
                        buscadoropcion = teclado.nextInt();
                        if (buscadoropcion==1) {
                            System.out.println("Introduzca el código del objeto");
                            respuesta = (char)System.in.read();
                            for (int i = 0; i < codigos.length && noencontrado==false; i++) {
                                if (codigos[i]==respuesta) {
                                    noencontrado = true;
                                    System.out.printf("Su producto con el código %c tiene un precio de %.2f",codigos[i],precio[i] );
                                }
                            }
                        }
                        else {
                            if (buscadoropcion==2) {
                                exitbuscador = true;
                            }
                            else {
                                System.out.println("Introduzca un carácter válido");
                            }
                        }
                    }while (exitbuscador==false);
                    break;
                case 'C':
                    System.out.println("Las 5 prendas más caras son:");
                    for (int i = 0; exit==false; i++) {
                        exit = true;
                        for (int j = 0; j < precio.length-1; j++) {
                            if (precio[j]>precio[j+1]) {
                                aux = precio[j];
                                precio[j] = precio[j+1];
                                precio[j+1] = aux;
                                auxc = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxc;
                                exit = false;
                            }
                        }
                    }
                    for (int i = 1,j = top5.length-1; i <6 ; i++,j--) {
                        System.out.printf("%dª posicion: %c por %.2f€\n",i,codigos[j],precio[j]);
                    }
                    ordenados = false;
                    break;
                case 'D':
                    System.out.println("Las 5 prendas más baratas son:");
                    for (int i = 0; exit==false; i++) {
                        exit = true;
                        for (int j = 0; j < precio.length-1; j++) {
                            if (precio[j]>precio[j+1]) {
                                aux = precio[j];
                                precio[j] = precio[j+1];
                                precio[j+1] = aux;
                                auxc = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxc;
                                exit = false;
                            }
                        }
                    }
                    for (int i = 1,j = 0; i < 6 ; i++,j++) {
                        if (codigos[i]=='0') {
                            i--;
                        }
                        else {
                            System.out.printf("%dª posicion: %c por %.2f€\n",i,codigos[j],precio[j]);
                        }
                    }
                    break;
                case 'E':
                    for (int i = 0; exit==false; i++) {
                        exit = true;
                        for (int j = 0; j < codigos.length-1; j++) {
                            if (codigos[j]>codigos[j+1]) {
                                auxc = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxc;
                                aux = precio[j];
                                precio[j] = precio[j+1];
                                precio[j+1] = aux;
                                exit = false;
                            }
                        }
                    }
                    ordenados = true;
                    break;
                case 'F':
                    System.out.println("Introduzca el código del artículo que quiere buscar para borrar");
                   respuesta = (char)System.in.read();
                    for (int i = 0; i < codigos.length && encontrado==false; i++) {
                        if (respuesta==codigos[i]) {
                            encontrado = true;
                        }
                        else {
                            encontrado = false;
                        }
                    }
                    if (encontrado==false) {
                        if (ordenados==true) {
                            if (respuesta < codigos.length/3) {
                                for (int i = 0; i < codigos.length/3; i++) {
                                    if (respuesta==codigos[i]) {
                                        codigos[i] = 0;
                                    }
                                }
                            }
                            else {
                                if (respuesta >= codigos.length/3 && respuesta < 2*codigos.length/3) {
                                    for (int i = codigos.length/3; i < 2*codigos.length/3; i++) {
                                        if (respuesta==codigos[i]) {
                                            codigos[i+10] = 0;
                                        }
                                    }
                                }
                                else {
                                    if (respuesta >= 2*codigos.length/3) {
                                        for (int i = 2*codigos.length/3; i < codigos.length; i++) {
                                            if (respuesta==codigos[i]) {
                                                codigos[i+20] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            encontrado = false;
                        }
                        else {
                            for (int i = 0; i < codigos.length; i++) {
                                if (respuesta==codigos[i]) {
                                    codigos[i] = 0;
                                }
                            }
                        }
                        System.out.println("Borrado con éxito");
                    }
                    else {
                        System.out.println("El codigo no es valido o el producto ha sido borrado");
                    }
                    break;
                case 'G':
                    System.out.println("Introduzca el código del producto del que desea conocer las ventas");
                    respuesta = (char) System.in.read();
                    for (int i = 0; i < codigos.length && encontrado==false; i++) {
                        if (respuesta==codigos[i]) {
                            encontrado = true;
                        }
                        else {
                            encontrado = false;
                        }
                    }
                    if (encontrado==false) {
                        if (ordenados == true) {
                            if (respuesta < codigos.length / 3) {
                                for (int i = 0; i < codigos.length / 3; i++) {
                                    if (respuesta == codigos[i]) {
                                        ventas = codigos[i + 1];
                                    }
                                }
                            } else {
                                if (respuesta >= codigos.length / 3 && respuesta < 2 * codigos.length / 3) {
                                    for (int i = codigos.length / 3; i < 2 * codigos.length / 3; i++) {
                                        if (respuesta == codigos[i]) {
                                            ventas = codigos[i + 11];
                                        }
                                    }
                                } else {
                                    if (respuesta >= 2 * codigos.length / 3) {
                                        for (int i = 2 * codigos.length / 3; i < codigos.length-1; i++) {
                                            if (respuesta == codigos[i]) {
                                                ventas = codigos[i + 21];
                                            }
                                        }
                                    }
                                    else {
                                        ventas = codigos[0];
                                    }
                                }
                            }
                        } else {
                            if (respuesta==codigos[29]) {
                                ventas = codigos[0];
                            }
                            for (int i = 0; i < codigos.length-1; i++) {
                                if (respuesta == codigos[i]) {
                                    ventas = codigos[i+1];
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("El codigo no es valido o el producto ha sido borrado");
                    }
                    break;
                case 'H':
                    exit = true;
                    break;
                default:
                System.out.println("Introduzca un carácter válido");
            }
        }while(exit!=true);
    }

}