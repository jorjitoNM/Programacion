package dao;


import common.CategoriaException;
import common.Constantes;
import domain.Palabra;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palabras {
    private List<Palabra> palabras;
    private static int autonumerico;

    public Palabras() {
        try {
            if (DaoPalabrasFicheros.leerFichero(DaoPalabrasFicheros.DICIONARIO).isEmpty())
                try {
                    String palabra;
                    palabras = new ArrayList<>();
                    Faker faker = new Faker();
                    for (int i = 0; i < 10;) {
                        palabra = faker.basketball().players();
                        if (isRepited(palabra)) {
                            palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, faker.basketball().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().dessert().toString();
                        if (isRepited(palabra)) {
                            palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, faker.dessert().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().movie().toString(); //habria que splitearlo??
                        if (isRepited(palabra)) {
                            palabras.add(new Palabra(darID(),asignarNivel(palabra),palabra,faker.movie().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().yoda().quote();
                        if (isRepited(palabra)) {
                            palabras.add(new Palabra(darID(),asignarNivel(palabra),palabra,faker.yoda().getClass().getSimpleName().concat("quotes")));
                            i++;
                        }
                    }
                } catch (CategoriaException e) {
                    System.out.println(e.getMessage());
                }
            else
                palabras = DaoPalabrasFicheros.leerFichero(DaoPalabrasFicheros.DICIONARIO);
        } catch (IOException e) {
            // tratar la excepcion
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
    public boolean isRepited (String palabra) {
        boolean repetido = false;
        for (int i = 0; i < palabras.size(); i++) {
            if (palabra.equals(palabras.get(i).getIncognita()))
                repetido = true;
        }
        return repetido;
    }
    public Palabra buscarPalabra (int id) {
        boolean exit = false;
        Palabra aux = null;
        for (int i = 0; i < palabras.size() && !exit; i++) {
            if (palabras.get(i).getId() == id) {
                exit = true;
                aux = palabras.get(i);
            }
        }
        return aux;
    }
    /*public int buscarPalabra (int id) {
        int i = 0;
        boolean exit = false;
        for (; i < palabras.size() && !exit; i++) {
            if (palabras.get(i).getId() == id) {
                exit = true;
            }
        }
        return i-1;
    }*/
    public void eliminarPalabra (int id) {
        palabras.set(id,null);
    }
    public boolean añadirPalabra () { //revisar logica, no se si se va a hacer un lio al salir
        Scanner teclado = new Scanner(System.in);
        boolean exit = true;
        System.out.println(Constantes.NUEVAPALABRA);
        String palabra = teclado.nextLine();
        System.out.println(Constantes.INTRODUCIRCATEGORIA);
        String categoria = teclado.nextLine();
        palabra = palabraRepetida(palabra);
        if (palabra!=null) {
            try {
                palabras.add(new Palabra(darID(), asignarNivel(palabra), palabra, categoria));
            } catch (CategoriaException exception) {}
        }
        return exit;
    }
    public boolean cambiarIncognita () { //mismo trozo de codigo que nueva palabra, quizas se puede simplificar
        Scanner teclado = new Scanner(System.in);
        boolean exit = true;
        System.out.println(Constantes.IDPALABRA);
        int ID = teclado.nextInt();
        System.out.println(Constantes.CAMBIARINCOGNITA);
        String incognita = teclado.nextLine();
        incognita = palabraRepetida(incognita);
        if (incognita!=null) {
            buscarPalabra(ID).setIncognita(incognita);
        }
        return exit;
    }
    public boolean cambiarCategoria () { //mismo trozo de codigo que nueva palabra, quizas se puede simplificar (booleano para incognita o atributo)
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        System.out.println(Constantes.IDPALABRA);
        int ID = teclado.nextInt();
        System.out.println(Constantes.INTRODUCIRCATEGORIA);
        String categoria = teclado.nextLine();
        categoria = palabraRepetida(categoria);
        if (categoria!=null) {
            try { //no quiero tratar la excepcion porque la elige el usuario
                buscarPalabra(ID).setCategoria(categoria);
            } catch (CategoriaException e) {

            }
            exit = true;
        }
        return exit;
    }
    private String palabraRepetida (String incognita) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = true;
        do {
            if (!isRepited(incognita)) {
                System.out.println(Constantes.PALABRAREPETIDA);
                incognita = teclado.nextLine();
                if (incognita.equals("\n")) {
                    incognita = null;
                    exit = false;
                }
            }
        }while(exit || !isRepited(incognita));
        return incognita;
    }
}