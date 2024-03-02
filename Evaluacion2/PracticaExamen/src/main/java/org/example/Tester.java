package org.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido a Piedra,Papel,Tijera");
        System.out.println(baraja.toString());
        Verde verde = new Verde("tijera");

    }
}
