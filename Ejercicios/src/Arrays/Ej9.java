package Arrays;

public class Ej9 {
    public static void main(String[] args) {
        int numeros [] = new int [10];
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            numeros [i] = (int) (Math.random()*-20+10);
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0; i < numeros.length; i++) {
            if (i%2==0) {
                suma+=numeros[i];
            }
        }
        System.out.printf("%n%d",suma);
    }
}
