package ui;

import common.Constantes;
import common.OpcionNoValidaException;
import common.Utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPersonal {
    public void menuPersonal () {
        boolean exit = false;
        do {
            switch (opcionMenuPersonal()) {
                case 1:
                    menuCamarero();
                    break;
                case 2:
                    menuCocinero();
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    public int opcionMenuPersonal () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.ELEGIR_ROL + "\n" + Constantes.CLIENTE + "\n-" + Constantes.CAMARERO + "\n-" + Constantes.COCINERO);
                Utilidades.validarOpcionMenuUsuario(teclado.nextLine());
                exit = true;
            } catch (OpcionNoValidaException exception) {
                System.out.println(exception.getMessage());
            }
        }while (!exit);
        return opcion;
    }

    public void menuCocinero () {
        boolean exit = false;
        do {
            switch (opcionMenuCocinero()) {
                case 1:
                    break;
                case 2:

                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    private int opcionMenuCocinero () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU_EMPLEADO + "\n" + Constantes.VER_PLATOS + "\n" + Constantes.COMFIRMAR_PLATO);
                opcion = teclado.nextInt();
                exit = true;
            } catch (InputMismatchException exception) {
                teclado.nextLine();
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        }while (!exit);
        return opcion;
    }
    private void menuCamarero () {
        boolean exit = false;
        do {
            switch (opcionMenuCamarero()) {
                case 1:
                    break;
                case 2:

                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    private int opcionMenuCamarero () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU_EMPLEADO + "\n" + Constantes.AYUDAR_CLIENTE + "\n" + Constantes.VER_PEDIDOS_CAMARERO);
                opcion = teclado.nextInt();
                exit = true;
            } catch (InputMismatchException exception) {
                teclado.nextLine();
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        }while (!exit);
        return opcion;
    }
}