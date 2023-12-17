import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        String nombre;
        String apellido;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca su nombre");
        nombre = teclado.nextLine();
        System.out.println("Inrtroduzca su primer apellido");
        apellido = teclado.nextLine();
        System.out.println(OperacionesString.letra(nombre,apellido));
        System.out.println("Introduzca una oracion o una palabra");
        nombre = teclado.nextLine();
        System.out.println("Introduzca otra oracion o palabra");
        apellido = teclado.nextLine();
        System.out.println(OperacionesString.concatenacion(nombre,apellido));
        System.out.println("");
    }
}