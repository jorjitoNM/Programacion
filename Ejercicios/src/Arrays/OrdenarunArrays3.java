package Arrays;

public class OrdenarunArrays3 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int numeromayor=0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*21-10);
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0,j = numeros.length-1; i < numeros.length; i++,j--) {
            numeromayor=-10;
            if (numeros[i]>=numeromayor) {
                numeros[j] = numeros[i];
            }
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
