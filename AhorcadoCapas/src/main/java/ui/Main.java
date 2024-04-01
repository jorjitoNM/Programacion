package ui;


import common.Categoria;
import common.CategoriaException;
import common.Comprobacion;
import common.Constantes;
import net.datafaker.Faker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MENU);
        System.out.println(Constantes.ADMINISTRAR);
        System.out.println(Constantes.JUGAR);
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                MenuAdministrador administrador = new MenuAdministrador();
                if (administrador.controlSeguridad())
                    administrador.opcionesMenu();
                break;
            case 2:
                MenuUsuario usuario = new MenuUsuario();
                usuario.opcionesMenu();
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
        //dos opcinones, jugar o administrar
        /*try {
            Comprobacion.categoriaOk(Categoria.comedia.name());
            Comprobacion.categoriaOk("hola");
        }catch (CategoriaException e){
            System.out.println(e.getMessage());
        }*/


        /*Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10,15).toString();
        System.out.println(fecha);*/



        //El siguiente código no va aquí pero es para que sepáis cómo funciona el id autonumérico
        /*Palabras asdf = new Palabras();
        System.out.println(Palabras.getAutonumerico());
        Palabra asd = new Palabra(2,"324",Categoria.accion.name());
        System.out.println(Palabras.getAutonumerico());
        Palabra asd2 = new Palabra(2,"324",Categoria.miedo.name());
        System.out.println(Palabras.getAutonumerico());*/

    }
}