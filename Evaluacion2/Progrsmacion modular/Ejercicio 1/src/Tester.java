import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero = 0;

        System.out.println("Introduzca un número y te digo si es primo o no");
        numero = teclado.nextInt();
        if (OperacionesVarias.isPrime(numero)) {
            System.out.println(numero + " es primo");
        }
        else {
            System.out.println(numero + " no es primo");
        }
        System.out.println("Introduzca donde quieres que empieze la pirámide");
        numero = teclado.nextInt();

        int x = 12;
        int z = x;
        for (int i = x; i < 3*x/2; i+=2,z++) {
            for (int k = 0; k < (3*x/2-(z)); k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}