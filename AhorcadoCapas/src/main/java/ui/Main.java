package ui;


import common.Categoria;
import common.CategoriaException;
import common.Comprobacion;
import net.datafaker.Faker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);
        //En el main sólo hay que llamar a los métodos de la UI que darán paso al luego o administrar diccionario.
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                MenuAdministrador administrador = new MenuAdministrador();
                administrador.mostrarMenu();
            case 2:

        }
        //Este código no va aquí, pero es para que veáis cómo funciona ciertos aspectos de la aplicación a tener en cuenta
        administrador.mostrarMenu();
        //dos opcinones, jugar o administrar
        try {
            Comprobacion.categoriaOk(Categoria.comedia.name());
            Comprobacion.categoriaOk("hola");
        }catch (CategoriaException e){
            System.out.println(e.getMessage());
        }


        Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10,15).toString();
        System.out.println(fecha);



        //El siguiente código no va aquí pero es para que sepáis cómo funciona el id autonumérico
        /*Palabras asdf = new Palabras();
        System.out.println(Palabras.getAutonumerico());
        Palabra asd = new Palabra(2,"324",Categoria.accion.name());
        System.out.println(Palabras.getAutonumerico());
        Palabra asd2 = new Palabra(2,"324",Categoria.miedo.name());
        System.out.println(Palabras.getAutonumerico());*/

    }
}