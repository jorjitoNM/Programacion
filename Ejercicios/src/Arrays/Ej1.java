package Arrays;

import java.util.Random;

public class Ej1 {
    public static void main(String[] args) {
        int vector[] = new int[15];
        int contador;

        for (contador = 0; contador < vector.length; contador++) {
            vector[contador] = (int) (Math.random() * 10 + 1);
        }
        for (contador = (vector.length-1); contador >= 0; contador--) {
            System.out.println(vector[contador] / contador);
        }
    }
}
