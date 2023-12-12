package String;

import java.util.Scanner;

public class ExplicacionmetodoToUpperCase {
    public static void main(String[] args) {
        String saludo = "Como te llamas mi crack???";
        String nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Primero pedimos el nombre de manera educada:");
        System.out.println(saludo);
        nombre = teclado.nextLine();
        System.out.println("Ahora pedimos el nombre gritando");
        System.out.println(saludo.toUpperCase());
    }
}
