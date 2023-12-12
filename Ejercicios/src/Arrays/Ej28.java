package Arrays;

import java.io.IOException;

public class Ej28 {
    public static void main(String[] args) throws IOException {
        char opcion;
        int huevostotales;
        int[] gallinas = new int[10];
        int[] huevos = new int[10];
        int[] huevos15 = new int[15];
        int mayor = 0;

        for (int i = 0; i < huevos.length; i++) {
            huevos[i] = (int)(Math.random()*5+1);
        }

        do {
            System.out.println("Bienvenido al 'Gallinero':\n-Introduzca 'A' para ver la media de huevos al día\n-Introduzca 'B' para ver la media de huevos de cada gallina\n-Introduzca 'C' para ver las gallinas que no son rentables\n-Introduzca 'D' para ver que gallina ha puesto más huevos en un día en concreto\n-Introduzca 'E' para salir del menú");
            opcion = (char) System.in.read();
            System.in.read();
            switch(opcion) {
                case 'A':
                    System.out.println("La media de huevos ha sido:");
                    for (int i = 0; i < 15; i++) {
                        huevostotales = 0;
                        for (int j = 0; j < huevos.length; j++) {
                            huevos[j] = (int)(Math.random()*5+1);
                            huevostotales+=huevos[j];
                        }
                        System.out.printf("\n-El dia %d la media de huevos fue de %d",i+1,(huevostotales/10));
                    }
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("La media de huevos por gallina ha sido:");
                    for (int i = 0; i < gallinas.length; i++) {
                        huevostotales = 0;
                        for (int j = 0; j < huevos15.length; j++) {
                            huevos15[j] = (int)(Math.random()*5+1);
                            huevostotales+=huevos15[j];
                        }
                        System.out.printf("\n-La gallina %d ha conseguido una media de %d huevos",i+1,(huevostotales/15));
                        huevos[i] = (huevostotales/15);
                    }
                    System.out.println();
                    break;
                case 'C':
                    for (int i = 0; i < gallinas.length; i++) {
                        if (huevos[i]<3) {
                            System.out.printf("\n-La gallina %d, con una media de %d huevos al día, no es rentable, pasara a una vida mejor :'( :'(",i+1,huevos[i]);
                            gallinas[i] = 0;
                        }
                    }
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("Introduzca un día");
                    opcion = (char)System.in.read();
                    for (int i = 0; i < gallinas.length; i++) {
                        gallinas[i] = (int)(Math.random()*5+1);
                        System.out.print(gallinas[i] + " ");
                        if (gallinas[i]>mayor) {
                            mayor = gallinas[i];
                            i = huevos15[0];
                        }
                    }
                    System.out.println("\nLa gallina " + huevos[0] + " ha sido la mayor ponedora del día " + opcion + ", con " + mayor + " huevos puestos");
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Introduzca un carácter válido");

            }
        }while(opcion!='E');
    }
}
