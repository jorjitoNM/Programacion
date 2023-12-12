package Arrays;

public class EJ8 {
    public static void main(String[] args) {
        int numeros [] = new int [20];
        int numeromayor = 0;
        int orden = 0;
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = (int) (Math.random()*-20+10);
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0; i < numeros.length ; i++) {
            if (numeros[i]>numeromayor) {
                numeromayor = numeros[i];
                i = orden;
            }
        }
        System.out.printf("%n%d en el hueco %d " ,numeromayor, (orden+1));
    }
}
