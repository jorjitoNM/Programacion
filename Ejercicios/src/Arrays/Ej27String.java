package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class Ej27String {
    public static void main(String[] args) throws IOException {
        char opcion;
        boolean exit = false;
        int auxiliares [] ={3,8,4};
      //  String auxiliar0 = Integer.toString(auxiliares[0]);
        String auxiliar1= String.format("%02d", auxiliares[0]);
        String[] codigosAuxiliares = {String.format("",auxiliares[0])};
        String[] codigos = new String[30];
        double[] precio = new double[30];
        double[] top5 = new double[30];
        int buscadoropcion;
        boolean exitbuscador = false;
        String respuesta;
        double aux;
        char auxc;
        int auxi;
        String auxs;
        boolean noencontrado = false;
        boolean ordenados = false;
        int posicion;
        int ventas;
        boolean encontrado = false;
        boolean repeticion = true;
        Scanner teclado = new Scanner(System.in);

        /*
        do {
            System.out.println("Bienvenido a su menu de una tienda deportiva\n-Introduzca 'A' para acceder a imprimir todos los códigos de los articulos con su precio correspondiente\n-Introduzca 'B' para  buscar una articulo por código y decir su precio\n-Introduzca 'C' para listar todos los códigos de las prendas más caras\n-Introduzca 'D' para listar todos los códigos de las prendas más baratas\n-Introduzca 'E' para ordenar las listas por código\n-Introduzca 'F' para borrar algun elemento por su código\n-Introduzca 'G' para calcular las ganancias obtenidas\n-Introduzca 'H' para salir");
            opcion = (char)System.in.read();
            System.in.read();
            switch(opcion) {
                case 'A':
                    for (int i = codigos.length-1; i >= 0; i--) {
                            do {
                                repeticion = true;
                                auxs = String.format("%02d",(int)(Math.random()*30));
                                for (int j = codigos.length-1; j > i+1 && repeticion==true ; j--) {
                                    if (auxs.equals(codigos[j])) {
                                        repeticion = false;
                                    }
                                }
                            }while(repeticion==false);
                            codigos[i]=auxs;
                            precio[i] = Math.random()*6;
                    }
                    for (int i = 0; i < codigos.length; i++) {
                        System.out.printf("Producto %d:\n-Codigo:%s\n-Precio:%.2f\n",i+1,codigos[i],precio[i]);
                    }
                    break;
                case 'B':
                    do {
                        System.out.println("\nBienvenido al buscador, introduzca '1' para busca un objeto y '2' para salir");
                        buscadoropcion = teclado.nextInt();
                        if (buscadoropcion==1) {
                            System.out.println("Introduzca el código del objeto");
                            respuesta = teclado.nextLine();
                            for (int i = 0; i < codigos.length && noencontrado==false; i++) {
                                if (codigos[i].equals(respuesta)) {
                                    noencontrado = true;
                                    System.out.printf("Su producto con el código %s tiene un precio de %.2f",codigos[i],precio[i] );
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
                                auxs = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxs;
                                exit = false;
                            }
                        }
                    }
                    for (int i = 1,j = top5.length-1; i <6 ; i++,j--) {
                        System.out.printf("%dª posicion: %s por %.2f€\n",i,codigos[j],precio[j]);
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
                                auxs = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxs;
                                exit = false;
                            }
                        }
                    }
                    for (int i = 1,j = 0; i < 6 ; i++,j++) {
                        if (codigos[i].equals("null")) {
                            i--;
                        }
                        else {
                            System.out.printf("%dª posicion: %s por %.2f€\n",i,codigos[j],precio[j]);
                        }
                    }
                    break;
                case 'E':
                    for (int i = 0; exit==false; i++) {
                        exit = true;
                        for (int j = 0; j < codigos.length-1; j++) {
                            if (codigos[j].compareTo(codigos[j+1])>1) {
                                auxs = codigos[j];
                                codigos[j] = codigos[j+1];
                                codigos[j+1] = auxs;
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
                   respuesta = teclado.nextLine();
                    for (int i = 0; i < codigos.length && encontrado==false; i++) {
                        if (respuesta.equals(codigos[i])) {
                            encontrado = true;
                        }
                        else {
                            encontrado = false;
                        }
                    }
                    if (encontrado==false) {
                        if (ordenados==true) {
                            if (respuesta.compareTo(codigos[codigos.length/3])<=0) {
                                for (int i = 0; i < codigos.length/3; i++) {
                                    if (respuesta.equals(codigos[i])) {
                                        codigos[i] = "null";
                                    }
                                }
                            }
                            else {
                                if (respuesta.compareTo(codigos[codigos.length/3])>=0 && respuesta.compareTo(codigos[2*codigos.length/3])<0) {
                                    for (int i = codigos.length/3; i < 2*codigos.length/3; i++) {
                                        if (respuesta.equals(codigos[i])) {
                                            codigos[i+10] = "null";
                                        }
                                    }
                                }
                                else {
                                    if (respuesta.compareTo(codigos[2*codigos.length/3])>=0) {
                                        for (int i = 2*codigos.length/3; i < codigos.length; i++) {
                                            if (respuesta.equals(codigos[i])) {
                                                codigos[i+20] = "null";
                                            }
                                        }
                                    }
                                }
                            }
                            encontrado = false;
                        }
                        else {
                            for (int i = 0; i < codigos.length; i++) {
                                if (respuesta.equals(codigos[i])) {
                                    codigos[i] = "null";
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
                    respuesta = teclado.nextLine();
                    for (int i = 0; i < codigos.length && encontrado==false; i++) {
                        if (respuesta.equals(codigos[i])) {
                            encontrado = true;
                        }
                        else {
                            encontrado = false;
                        }
                    }
                    if (encontrado==false) {
                        if (ordenados == true) {
                            if (respuesta.compareTo(codigos[codigos.length/3])<=0) {
                                for (int i = 0; i < codigos.length / 3; i++) {
                                    if (respuesta.equals(codigos[i])) {
                                        ventas = codigos.[i + 1]*codigos[i];
                                    }
                                }
                            } else {
                                if (respuesta.compareTo(codigos[codigos.length/3])>=0 && respuesta.compareTo(codigos[2*codigos.length/3])<0) {
                                    for (int i = codigos.length / 3; i < 2 * codigos.length / 3; i++) {
                                        if (respuesta.equals(codigos[i])) {
                                            ventas = codigos[i + 11];
                                        }
                                    }
                                } else {
                                    if (respuesta.compareTo(codigos[2*codigos.length/3])>=0) {
                                        for (int i = 2 * codigos.length / 3; i < codigos.length-1; i++) {
                                            if (respuesta.equals(codigos[i])) {
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
                            if (respuesta.equals(codigos[29])) {
                                ventas = codigos[0];
                            }
                            for (int i = 0; i < codigos.length-1; i++) {
                                if (respuesta.equals(codigos[i])) {
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
        */
    }

}