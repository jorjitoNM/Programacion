package ui;

import common.CategoriaException;
import common.Comprobacion;
import common.Constantes;
import common.RepeatedException;
import service.GestionPalabras;
import service.IGestionPalabras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdministrador {
    private final IGestionPalabras servicio;

    public MenuAdministrador() {
        servicio = new GestionPalabras();
    }

    public int mostrarMenu(){
        Scanner teclado = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4);
                opcion = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.ENTRADANONUMERO);
            }
        }while(!valido);
        return opcion;
    }
    public void opcionesMenu () {
        Scanner teclado = new Scanner(System.in);
        int opcion = mostrarMenu();
        switch (opcion) {
            case 1:
                System.out.println(servicio.ordenarDiccionario(true));
                break;
            case 2:
                añadirPalabra();
                break;
            case 3:
                menuCampos();
                break;
            case 4:
                System.out.println(Constantes.IDPALABRA);
                opcion = teclado.nextInt();
                System.out.println(servicio.eliminarPalabra(opcion));
                break;
            case 5:
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
    public boolean controlSeguridad () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.PEDIRCONTRASEÑA);
        int contador = 0;
        String password;
        do {
            password = teclado.nextLine();
            contador++;
        }while(!Comprobacion.controlSeguridad(password) && contador<=3);
        return (Comprobacion.controlSeguridad(password) && contador<=3)?true:false;
    }
    public void menuCampos () {
        int opcion = mostrarMenuCampos();
        switch (opcion) {
            case 1:
                cambiarIncognita();
                break;
            case 2:
                cambiarCategoria();
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
   /* private String palabraRepetida (String incognita) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = true;
        do {
            if (!isRepeated(incognita)) {
                System.out.println(Constantes.PALABRAREPETIDA);
                incognita = teclado.nextLine();
                if (incognita.equals("\n")) {
                    incognita = null;
                    exit = false;
                }
            }
        }while(exit || !isRepeated(incognita));
        return incognita;
    }*/

    private int mostrarMenuCampos() {
        Scanner teclado = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENUCAMPOS+"\n"+Constantes.INCOGNITA+"\n"+Constantes.CATEGORIA);
                opcion = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.ENTRADANONUMERO);
            }
        }while(!valido);
        return opcion;
    }
    public void añadirPalabra () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println(Constantes.NUEVAPALABRA);
            String palabra = teclado.nextLine();
            System.out.println(Constantes.INTRODUCIRCATEGORIA);
            System.out.println(Constantes.CATEGORIAS);
            String categoria = teclado.nextLine();
            try {
                servicio.añadirPalabra(palabra, categoria);
                exit = true;
                System.out.println(Constantes.NUEVAPALABRAAÑADIDA);
            } catch (RepeatedException exception) {
                System.out.println(Constantes.PALABRAREPETIDA);
            }
        } while(!exit);
    }
    public void cambiarIncognita () {
        Scanner teclado = new Scanner(System.in);
        boolean exit;
        int ID;
        do {
            exit = true;
            servicio.ordenarDiccionario(true);
            System.out.println(Constantes.IDPALABRA);
            ID = teclado.nextInt();
            System.out.println(Constantes.CAMBIARINCOGNITA);
            String incognita = teclado.nextLine();
            try {
                servicio.cambiarIncognita(ID, incognita);
                System.out.println(Constantes.INCOGNITACAMBIADA);
            } catch (RepeatedException e) {
                System.out.println(Constantes.ERRORDESCONOCIDO);
                exit = false;
            }
        }while(!exit);
    }
    public void cambiarCategoria () {
        Scanner teclado = new Scanner(System.in);
        int ID;
        boolean exit;
        do {
            exit = true;
            servicio.ordenarDiccionario(true);
            System.out.println(Constantes.IDPALABRA);
            ID = teclado.nextInt();
            System.out.println(Constantes.INTRODUCIRCATEGORIA);
            System.out.println(Constantes.CATEGORIAS);
            String categoria = teclado.nextLine();
            try {
                servicio.cambiarCategoria(ID,categoria);
                System.out.println(Constantes.INCOGNITACAMBIADA);
            } catch (CategoriaException e) {
                System.out.println(Constantes.ERRORDESCONOCIDO);
                exit = false;
            }
        }while(!exit);
    }
}
