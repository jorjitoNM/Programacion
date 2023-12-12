package Arrays;

public class OrdenarunArraysBurbuja {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        boolean exit = false;
        int aux;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*11-5);
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0; exit==false; i++) {
            exit = true;
            for (int j = 0; j < numeros.length-1; j++) {
                if (numeros[j]>numeros[j+1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = aux;
                    exit = false;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
