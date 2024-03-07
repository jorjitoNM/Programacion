package org.example;

import net.datafaker.Faker;
import net.datafaker.service.FakerContext;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        boolean exit = true;
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            try {
                System.out.println("Introduzca un número");
                numero = teclado.nextInt();
                System.out.println("Has introducido el numero " + numero);
                exit = false;
            } catch (InputMismatchException exception) {
                System.out.println("Tienes que introducir un número");
                exit = true;
                teclado.nextLine();
            }
        }while(exit);
        System.out.println("Completado con exito");
        ArrayList<String> pokemons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pokemons.add(new Faker().cannabis().categories());
        }
        System.out.println(pokemons.size());
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println(pokemons.get(i));
        }
    }
}
