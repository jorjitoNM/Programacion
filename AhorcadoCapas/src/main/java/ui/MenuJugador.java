package ui;

import common.Constantes;
import service.IGestionPalabras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuJugador {
    private final IGestionPalabras servicio;

    public MenuJugador(IGestionPalabras servicio) {
        this.servicio = servicio;
    }

    public int opcionesMenu (){
        Scanner teclado = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU+"\n"+Constantes.RETOMARPARTIDA+"\n"+Constantes.NUEVAPARTIDA);
                opcion = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.ENTRADANONUMERO);
            }
        }while(!valido);
        return opcion;
    }
    public void mostrarMenu () {
        int opcion = opcionesMenu();
        switch (opcion) {
            case 1:
                servicio.ordenarDiccionario(true);
                break;
            case 2:
                System.out.println(servicio.añadirPalabra());
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
}
