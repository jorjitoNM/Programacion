package Arrays;

public class OrdenarunArrays {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int numeromayor = -10;
        int[] ordenados = new int[10];
        boolean exit = false;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*21-10);
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0; i < ordenados.length; i++) {
            ordenados[i] = -11;
        }
        for (int i = numeros.length-1; i >= 0; i--) {
            numeromayor = -10;
            for (int j = i; j >= 0; j--) {
                for (int k = 0; k < ordenados.length; k++) {
                    exit = false;
                    if (ordenados[k]==numeros[j]) {
                        exit = true;
                    }
                }
                if (numeros[j]>numeromayor && exit==false){
                    numeromayor = numeros[j];
                }
            }
            ordenados[i] = numeromayor;
        }
        System.out.println();
        for (int i = 0; i < ordenados.length; i++) {
            System.out.print(ordenados[i] + " ");
        }
    }
}
