package ui;

import common.Comprobacion;
import common.Constantes;
import service.GestionPalabras;
import service.IGestionPalabras;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
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
                System.out.println(Constantes.NUEVAPALABRA);
                String palabra = teclado.nextLine();
                System.out.println(Constantes.INTRODUCIRCATEGORIA);
                String categoria = teclado.nextLine();
                System.out.println(servicio.añadirPalabra(palabra,categoria));
                break;
            case 3:
                menuCampos();
                break;
            case 4:
                System.out.println(servicio.eliminarPalabra());
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
        }while(Comprobacion.controlSeguridad(password) || contador<=3);
        return (Comprobacion.controlSeguridad(password) || contador<=3)?true:false;
    }
    public void menuCampos () {
        int opcion = mostrarMenuCampos();
        Scanner teclado = new Scanner(System.in);
        int ID;
        switch (opcion) {
            case 1:
                servicio.ordenarDiccionario(true);
                System.out.println(Constantes.IDPALABRA);
                ID = teclado.nextInt();
                System.out.println(Constantes.CAMBIARINCOGNITA);
                String incognita = teclado.nextLine();
                System.out.println(servicio.cambiarIncognita(ID,incognita));
                break;
            case 2:
                servicio.ordenarDiccionario(true);
                System.out.println(Constantes.IDPALABRA);
                ID = teclado.nextInt();
                System.out.println(Constantes.INTRODUCIRCATEGORIA);
                String categoria = teclado.nextLine();
                System.out.println(servicio.cambiarCategoria(ID,categoria));
        }
    }
    private String palabraRepetida (String incognita) {
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
    }

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
}
