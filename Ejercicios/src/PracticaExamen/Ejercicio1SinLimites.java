package PracticaExamen;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1SinLimites {
    public static void main(String[] args) throws IOException {
        int planta = 0;
        int plantaanterior = 0;
        char opcion;
        int aux;
        boolean exitA = false;
        int contador = 0;
        StringBuilder ruta = new StringBuilder();
        String ala = " a la ";
        Scanner teclado  = new Scanner(System.in);

        do {
            System.out.println("Bienvenido al ascensor:\n-Introduzca 'A' para Subir a la planta que desee\n-introduzca 'B' para bajar a la planta que desee\n-Introduzca 'C' para ver en que planta se encuntra\n-Introduzca 'D' para mostrar la planta recorrida\n-Introduzca 'E' para resetear le historico del ascensor\n-Introduzca 'F' para salir del menú");
            opcion = (char) System.in.read();
            System.in.read(); //"Chapuza" para quitar el enter
            switch (opcion) {
                case 'A':
                case 'a':
                    do {
                        System.out.println("Introduzca la planta a la que quiere subir");
                        plantaanterior = planta;
                        aux = teclado.nextInt();
                        if (aux>plantaanterior) {
                            for (; planta <= aux ;planta++) {
                                System.out.println(planta);
                            }
                            planta = planta-1;
                            exitA = true;
                            ruta = ruta.append(plantaanterior).append(ala).append(planta).append(" \n");
                            contador++;
                        }
                        else {
                            System.out.println("Opcion no válida, si lo que desea es bajar o ver en que planta esta, introduzca 26, sino introduzca otro número");
                            aux = teclado.nextInt();

                        }
                    }while(exitA==false && aux != 26);
                    break;
                case 'B':
                case 'b':
                    do {
                        System.out.println("Introduzca la planta a la que quiere bajar (el ascensor tiene de la -10 a la 25)");
                        plantaanterior = planta;
                        aux = teclado.nextInt();
                        if (aux<plantaanterior) {
                            for (; planta >= aux; planta--) {
                                System.out.println(planta);
                            }
                            planta = planta+1;
                            exitA = true;
                            ruta = ruta.append(plantaanterior).append(ala).append(planta).append(" \n");
                            contador++;
                        }
                        else {
                            System.out.println("Opcion no válida, si lo que desea es subir o ver en que planta esta, introduzca 26, sino introduzca otro número");
                            aux = teclado.nextInt();
                        }
                    }while(exitA==false && aux != 26);
                    break;
                case 'C':
                case 'c':
                    System.out.println("Usted se encuentra en la planta " + (planta));
                    break;
                case 'D':
                case 'd':
                    System.out.println(ruta);
                    System.out.println(contador);
                    break;
                case 'E':
                case 'e':
                    planta = 0;
                    contador = 0;
                    ruta = ruta.delete();
                    break;
                case 'F':
                case 'f':
                    break;
                default:
                    System.out.println("Introduzca una opcion válida");
            }
        }while (opcion!='F' && opcion!='f');
    }
}
