package Arrays;

public class Ej11 {
    public static void main(String[] args) {
        int numeros[] = new int [10];
        int aux = 0;
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = (int) (Math.random()*-20+10);
            System.out.print(numeros[i] + " ");
        }

        for (int i = 0, n = (numeros.length-1); i < (numeros.length/2) ; i++,n--) {
            aux = numeros[i];
            numeros[i] = numeros[n];
            numeros[n] = aux;
        }
        System.out.println();
        for (int i = 0; i < numeros.length ; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
