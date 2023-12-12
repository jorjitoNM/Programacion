package Arrays;

public class Ej3 {
    public static void main(String[] args) {
        int numeros [] = new int [15];
        for (int i = 0; i <numeros.length ; i++) {
            numeros[i] = (int) (Math.random()*20+1); //cabron, acuerdate de hacer el casting al resultado del Math.random
        }
        for (int i = (numeros.length-1); i >= 0 ; i--) {
            System.out.print(numeros[i] + " ");
        }
    }
}
