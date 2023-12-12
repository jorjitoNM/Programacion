package Arrays;

public class OrdenarunArrays2 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int numeromayor = -10;
        int[] ordenados = new int[10];
        boolean exit = false;
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*21-10);
            System.out.print(numeros[i] + " ");
        }
        for (int i = numeros.length-1; i >= 0; i--) {
            contador = 0;
            for (int j = numeros.length-1; j >= 0; j--) {
                if (numeros[i]>numeros[j]){
                    contador++;
                }
            }
            ordenados[contador] = numeros[i];
        }
        System.out.println();
        for (int i = 0; i < ordenados.length; i++) {
            System.out.print(ordenados[i] + " ");
        }
    }
}
