package PracticaExamen;

public class OrdenarunBidimensional {
    public static void main(String[] args) {
        int[][] numeros = new int[10][10];
        int aux;
        boolean cambio = true;
        int[] auxarr;
        int[] medias = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = (int) (Math.random() * 21 - 10);
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < medias.length; i++) {
            medias[i] = 0;
            for (int j = 0; j < numeros[i].length; j++) {
                medias[i] += numeros[i][j];
            }
            System.out.println(medias[i]);
        }
        while (cambio == true) {
            cambio = false;
            for (int i = 0; i < numeros.length; i++) {
                if (medias[i]>medias[i+1]) {

                }
            }
        }
        while (cambio == true) {
            cambio = false;
            for (int i = 0; i < numeros.length; i++) {
                for (int j = 0; j < numeros[i].length - 1; j++) {
                    if (numeros[i][j] > numeros[i][j + 1]) {
                        aux = numeros[i][j];
                        numeros[i][j] = numeros[i][j + 1];
                        numeros[i][j + 1] = aux;
                        cambio = true;
                    }
                }
            }
            for (int i = 0; i < numeros.length - 1; i++) {
                if (numeros[i][9] > numeros[i + 1][9]) {
                    auxarr = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = auxarr;
                    cambio = true;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println();
        }

    }
}
