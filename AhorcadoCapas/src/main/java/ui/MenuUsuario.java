package ui;

import common.Constantes;
import service.GestionPalabras;
import service.IGestionPalabras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionPalabras servicio;
    public MenuUsuario() {
        servicio = new GestionPalabras();
    }

    public int mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU+"\n"+Constantes.NUEVAPARTIDA+"\n"+Constantes.RETOMARPARTIDA);
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
                servicio.nuevaPartida();
                break;
            case 2:

                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
}
