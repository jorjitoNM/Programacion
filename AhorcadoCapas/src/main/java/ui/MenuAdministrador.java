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
        Scanner lector = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4);
                opcion = lector.nextInt();
                valido = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.ENTRADANONUMERO);
            }
        }while(!valido);
        return opcion;
    }
    public void opcionesMenu () {
        int opcion = mostrarMenu();
        switch (opcion) {
            case 1:
                servicio.ordenarDiccionario(true);
                break;
            case 2:
                System.out.println(servicio.añadirPalabra());
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
        switch (opcion) {
            case 1:
                controlSeguridad();
                servicio.ordenarDiccionario(true);
                System.out.println(servicio.cambiarIncognita());
                break;
            case 2:
                controlSeguridad();
                servicio.ordenarDiccionario(true);
                System.out.println(servicio.cambiarCategoria());
        }
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
