package Arrays;

public class Ej4 {
    public static void main(String[] args) {
    int numeros [] = new int [30];
        for (int i = 0; i < numeros.length; i++) {
            numeros [i] = (int) (Math.random()*10);
        }
        for (int i = 0; i < numeros.length ; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            numeros [i] = (int) (Math.random()*-10-1);
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros [i] + " ");
        }
    }
}
