package Arrays;

public class Ej10 {
    public static void main(String[] args) {
        int numeros[] = new int[10];
        int aux = 0;
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = (int) (Math.random()*-20+10);
            System.out.print(numeros[i] + " ");
        }
        aux = numeros[9];
        numeros[9] = numeros[0];
        numeros[0] = aux;
        System.out.println();
        for (int i = 0; i < numeros.length ; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
