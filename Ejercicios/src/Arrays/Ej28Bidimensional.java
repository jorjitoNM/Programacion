package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class Ej28Bidimensional {
    public static void main(String[] args) throws IOException {
        int opcion;
        int huevostotales;
        int[][] huevos = new int [20][15];
        int mayor = 0;
        int[] fila0 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < huevos.length; i++) {
            for (int j = 0; j < huevos[i].length; j++) {
                huevos[i][j] = (int)(Math.random()*5+1);
                System.out.print(huevos[i][j] + " ");
            }
            System.out.println();
        }

        do {
            System.out.println("Bienvenido al 'Gallinero':\n-Introduzca 'A' para ver la media de huevos al día\n-Introduzca 'B' para ver la media de huevos de cada gallina\n-Introduzca 'C' para ver las gallinas que no son rentables\n-Introduzca 'D' para ver que gallina ha puesto más huevos en un día en concreto\n-Introduzca 'E' para salir del menú");
            opcion = (char) System.in.read();
            System.in.read();
            switch(opcion) {
                case 'A':
                    System.out.println("La media de huevos ha sido:");
                    for (int i = 0; i < huevos[i].length; i++) {
                        huevostotales = 0;
                        for (int j = 0; j <huevos.length; j++) {
                            huevostotales+=huevos[j][i];
                        }

                        System.out.printf("\n-El dia %d la media de huevos fue de %d",i+1,(huevostotales/20));
                    }
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("La media de huevos por gallina ha sido:");
                    for (int i = 0; i < huevos.length; i++) {
                        huevostotales = 0;
                        for (int j = 0; j < huevos[i].length; j++) {
                            huevostotales+=huevos[i][j];
                        }
                        System.out.printf("\n-La gallina %d ha conseguido una media de %d huevos",i+1,(huevostotales/15));
                    }
                    System.out.println();
                    break;
                case 'C':
                    for (int i = 0; i < huevos.length; i++) {
                        huevostotales = 0;
                        for (int j = 0; j < huevos[i].length; j++) {
                            huevostotales+=huevos[i][j];
                        }
                        if ((huevostotales/15)<3) {
                            System.out.printf("\n-La gallina %d, con una media de %d huevos al día, no es rentable, pasara a una vida mejor :'( :'(",i+1,huevostotales/15);
                            huevos[i] = fila0;
                        }
                    }
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("Introduzca un día");
                    opcion = teclado.nextInt();
                    int i = 0;
                    for (; i < huevos[i].length; i++) {
                        if (huevos[i][opcion-1]>mayor) {
                            mayor = huevos[i][opcion-1];
                            i = opcion;
                        }
                    }
                    System.out.println("La gallina " + opcion + " ha sido la mayor ponedora del día " + opcion + ", con " + mayor + " huevos puestos");
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Introduzca un carácter válido");

            }
        }while(opcion!='E');
    }
}
