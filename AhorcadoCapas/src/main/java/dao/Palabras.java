package dao;


import common.CategoriaException;
import common.Constantes;
import domain.Palabra;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Palabras {
    private final ArrayList<Palabra> palabras;
    private static int autonumerico;

    public Palabras() {
        this.palabras = new ArrayList<>();
        try {
            Faker faker = new Faker();
            for (int i = 0; i < 10;) {
                String palabra = faker.basketball().players();
                if (isRepited(palabra)) {
                    palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, faker.basketball().getClass().getSimpleName()));
                    i++;
                }
            }
            for (int i = 0; i < 10;) {
                String palabra = new Faker().dessert().toString();
                if (isRepited(palabra)) {
                    palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, faker.dessert().getClass().getSimpleName()));
                    i++;
                }
            }
            for (int i = 0; i < 10;) {
                String palabra = new Faker().movie().toString(); //habria que splitearlo??
                if (isRepited(palabra)) {
                    palabras.add(new Palabra(darID(),asignarNivel(palabra),palabra,faker.movie().getClass().getSimpleName()));
                    i++;
                }
            }
            for (int i = 0; i < 10;) {
                String palabra = new Faker().yoda().quote();
                if (isRepited(palabra)) {
                    palabras.add(new Palabra(darID(),asignarNivel(palabra),palabra,faker.yoda().getClass().getSimpleName().concat("quotes")));
                    i++;
                }
            }
        } catch (CategoriaException e) {
            System.out.println(e.getMessage());
        }
    }

    public Palabras(ArrayList<Palabra> Palabras) {
        this.palabras = Palabras;
    }

    public static void setAutonumerico(int i) {
        autonumerico = i;
    }

    public List<Palabra> getListaPalabras() {
        return palabras;
    }

    public static int getAutonumerico() {
        return autonumerico;
    }
    public char getFirstLetter () {
        return palabras.get(0).toString().charAt(0);
    }

    public void setListaPalabras(List<Palabra> Palabras) {
        this.palabras.clear();
        this.palabras.addAll(Palabras);
    }
    private int asignarNivel (String palabra) {
        int contador = 0;
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabra.length(); j++) {
                if (esVocal(palabra.charAt(j)))
                    contador++;
            }
        }
        return contador;
    }
    private void asignarNivel () {
        int contador = 0;
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i).getIncognita();
            for (int j = 0; j < palabra.length(); j++) {
                if (esVocal(palabra.charAt(j)))
                    contador++;
            }
            palabras.get(i).setLevel(contador);
        }
    }
    private boolean esVocal (char letra) {
        boolean esVocal = false;
        switch(letra) {
            case 'A':
            case 'a':
                esVocal = true;
                break;
            case 'E':
            case 'e':
                esVocal = true;
                break;
            case 'I':
            case 'i':
                esVocal = true;
                break;
            case 'O':
            case 'o':
                esVocal = true;
                break;
            case 'U':
            case 'u':
                esVocal = true;
                break;
            default:
        }
        return esVocal;
    }
    public int darID () {
        int id = (int)(Math.random()*1000);
        for (int i = 0; i < palabras.size(); ) {
            if (id == palabras.get(i).getId())
                id = (int)(Math.random()*1000);
            else
                i++;
        }
        return id;
    }
    private boolean isRepited (String palabra) {
        boolean repetido = false;
        for (int i = 0; i < palabras.size(); i++) {
            if (palabra.equals(palabras.get(i).getIncognita()))
                repetido = true;
        }
        return repetido;
    }
    public boolean añadirPalabra () { //revisar logica, no se si se va a hacer un lio al salir
        Scanner teclado = new Scanner(System.in);
        boolean exit = true;
        System.out.println(Constantes.NUEVAPALABRA);
        String palabra = teclado.nextLine();
        System.out.println(Constantes.INTRODUCIRCATEGORIA);
        String categoria = teclado.nextLine();
        do {
            if (isRepited(palabra)) {
                System.out.println(Constantes.PALABRAREPETIDA);
                palabra = teclado.nextLine();
                if (palabra.equals("\n"))
                    exit = false;
            }
        }while(exit || !isRepited(palabra));
        if (exit) {
            try {
                palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, categoria));
                exit = true;
            } catch (CategoriaException exception) {

            }
        }
        return exit;
    }
}