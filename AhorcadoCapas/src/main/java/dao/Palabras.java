package dao;


import common.*;
import domain.Palabra;
import net.datafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palabras {
    private List<Palabra> palabras;
    private static int autonumerico;

    public Palabras() {
        try {
            if (!new File(Constantes.DICCIONARIO).exists())
                try {
                    String palabra;
                    palabras = new ArrayList<>();
                    Faker faker = new Faker();
                    for (int i = 0; i < 10;) {
                        palabra = faker.basketball().players();
                        if (!isRepeated(palabra)) {
                            palabras.add(new Palabra(darID(), Utilities.asignarNivel(palabra), palabra, faker.basketball().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().dessert().variety();
                        if (!isRepeated(palabra)) {
                            palabras.add(new Palabra(darID(), Utilities.asignarNivel(palabra), palabra, faker.dessert().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().movie().quote(); //habria que splitearlo??
                        if (!isRepeated(palabra)) {
                            palabras.add(new Palabra(darID(),Utilities.asignarNivel(palabra),palabra,faker.movie().getClass().getSimpleName()));
                            i++;
                        }
                    }
                    for (int i = 0; i < 10;) {
                        palabra = new Faker().yoda().quote();
                        if (!isRepeated(palabra)) {
                            palabras.add(new Palabra(darID(),Utilities.asignarNivel(palabra),palabra,faker.yoda().getClass().getSimpleName().concat("Quotes")));
                            i++;
                        }
                    }
                    DaoPalabrasFicheros.escribirDiccionario(palabras); //habria que crear un fichero cada vez que vamos a guardarlo
                } catch (CategoriaException e) {
                    System.out.println(e.getMessage());
                }
            else
                palabras = DaoPalabrasFicheros.leerDiccionario(Constantes.DICCIONARIO);
        } catch (IOException e) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
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
    public boolean isRepeated (String palabra) {
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
    public boolean buscarPalabra (String incognita) {
        boolean exit = true;
        for (int i = 0; i < palabras.size() && exit; i++) {
            if (palabras.get(i).getIncognita().equalsIgnoreCase(incognita))
                exit = false;
        }
        return exit;
    }
    public void eliminarPalabra (int id) {
        for (int i = 0; i < palabras.size(); i++) {
            if (id == palabras.get(i).getId())
                palabras.remove(i);
        }
    }
    public void añadirPalabra (String palabra,String categoria) throws RepeatedException, CategoriaException, IOException {
        if (isRepeated(palabra))
            throw new RepeatedException();
        Comprobacion.categoriaOk(categoria);
        palabras.add(new Palabra(darID(), Utilities.asignarNivel(palabra), palabra, categoria));
        DaoPalabrasFicheros.escribirDiccionario(palabras);
    }
    public void cambiarIncognita (int ID, String incognita) throws RepeatedException, IOException { //aqui no haria falta else?
        if (isRepeated(incognita))
            throw new RepeatedException();
        buscarPalabra(ID).setIncognita(incognita);
        DaoPalabrasFicheros.escribirDiccionario(palabras);
    }
    public void cambiarCategoria (int ID, String categoria) throws CategoriaException, IOException {
        Comprobacion.categoriaOk(categoria);
        buscarPalabra(ID).setCategoria(categoria);
        DaoPalabrasFicheros.escribirDiccionario(palabras);
    }
    public String incognitaAleatoria () {
        return palabras.get((int)(Math.random()*palabras.size())).getIncognita();
    }
    public String incognitaAleatoria (int dificultad) { //Quizas puedo ordenar por dificultad y asi puedo buscar mas facilmente
        Palabra palabra;
        boolean exit = false;
        do {
            palabra = palabras.get((int)(Math.random()*palabras.size()));
            if(palabra.getLevel()==dificultad)
                exit = true;
        }while(!exit);
        return palabra.getIncognita();
    }
    public Palabra palabraAleatoria () {
        return palabras.get((int)(Math.random()*palabras.size()));
    }
    public Palabra palabraAleatoria (int dificultad) { //Quizas puedo ordenar por dificultad y asi puedo buscar mas facilmente
        Palabra palabra;
        boolean exit = false;
        do {
            palabra = palabras.get((int)(Math.random()*palabras.size()));
            if(palabra.getLevel()==dificultad)
                exit = true;
        }while(!exit);
        return palabra;
    }
    public Palabra palabraAleatoria (String categoria) {
        Palabra palabra;
        boolean exit = false;
        do {
            palabra = palabras.get((int)(Math.random()*palabras.size()));
            if(palabra.getCategoria().equalsIgnoreCase(categoria))
                exit = true;
        }while(!exit);
        return palabra;
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < palabras.size(); i++) {
            salida.append("-");
            salida.append(palabras.get(i).toString());
            salida.append("\n");
        }
        return salida.toString();
    }
}