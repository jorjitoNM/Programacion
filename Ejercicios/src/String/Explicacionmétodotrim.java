package String;

import java.util.Scanner;

public class Explicacionmétodotrim {
    public static void main(String[] args) {
        //Devuelve una cadena nueva en la que se han quitado todas las repeticiones iniciales y finales de un conjunto de caracteres especificados de la cadena actual.
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe los que quieras");
        String palabras = teclado.nextLine();
        System.out.println("Ahora te lo saco sin espacios por delante ni por detrás");
        System.out.println(palabras.trim());
        System.out.println("Para que se vea más visual:");
        String saludo = "Buenos días ";
        System.out.println("Como te llamas???");
        String nombre = teclado.nextLine();
        System.out.println(saludo + nombre);
        System.out.println("//Ahora todo junto");
        System.out.println(saludo.trim() + nombre);
    }
}
