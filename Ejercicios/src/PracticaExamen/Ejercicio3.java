package PracticaExamen;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] canastas = new int[10];
        int[] canastasordenadas = new int[10];
        int aux = 0;
        int k = 0;
        boolean exit = false;
        boolean cambio = true;
        int diferencia = 0;

        for (int i = 0; i < canastas.length; ) {
            exit = false;
            aux = (int) (Math.random() * 100 + 1);
            for (int j = 0; j < canastas.length && exit == false && canastas[j]!=0; j++) { //el canastas[i]!=0 para máxima optimización :)
                if (aux == canastas[j]) {
                    exit = true;
                }
            }
            if (exit == false) {
                canastas[i] = aux;
                System.out.print(canastas[i] + " ");
                i++;
            }
        }
        System.out.println();
        for (int i = 0; i < canastas.length; i++) {
            System.out.println("El jugador " + (i + 1) + " ha anotado " + canastas[i] + " canastas");
        }
        for (int i = 0; i < canastasordenadas.length; i++) {
            canastasordenadas[i] = canastas[i];
        }
        for (int i = 0; cambio == true; i++) {
            cambio = false;
            for (int j = 0; j < canastasordenadas.length - 1; j++) {
                if (canastasordenadas[j] > canastasordenadas[j + 1]) {
                    aux = canastasordenadas[j];
                    canastasordenadas[j] = canastasordenadas[j + 1];
                    canastasordenadas[j + 1] = aux;
                    cambio = true;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < canastasordenadas.length; i++) {
            System.out.print(canastasordenadas[i] + " ");
        }
        System.out.println();
        for (int i = canastasordenadas.length - 1; i > canastasordenadas.length - 6; i--) {
            for (int j = 0; j < canastas.length; j++) {
                if (canastasordenadas[i] == canastas[j]) {
                    System.out.println("El jugador " + (j + 1) + " ha anotado " + canastasordenadas[i] + " canastas");
                }
            }
        }
        System.out.println();
        diferencia = canastasordenadas[9] - canastasordenadas[0];
        for (int j = 0; j < canastas.length; j++) {
            if (canastasordenadas[0] == canastas[j]) {
                aux = j + 1;
            }
            if (canastasordenadas[9] == canastas[j]) {
                k = j+1;
            }
        }
        System.out.println("El jugador " + k + " ha anotado " + diferencia + " canastas más que el jugador " + aux);
    }
}
