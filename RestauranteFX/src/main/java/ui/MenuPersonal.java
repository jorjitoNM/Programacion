package ui;

import common.Constantes;
import common.OpcionNoValidaException;
import common.Utilidades;
import service.GestionPersonal;
import service.IGestionPersonal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPersonal {
    private IGestionPersonal servicio;

    public MenuPersonal() throws IOException {
        servicio = new GestionPersonal();
    }

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
                case 3:
                    menuJefe();
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
    private int opcionMenuJefe () {
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
    private void menuJefe () {
        boolean exit = false;
        do {
            switch (opcionMenuJefe()) {
                case 1:
                    nuevoEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    cambiarPrecio();
                case 4:
                    eliminarCarta();
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    public void menuCocinero () {
        boolean exit = false;
        do {
            switch (opcionMenuCocinero()) {
                case 1:
                    verComandas();
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
    private void verComandas () {
        System.out.println(servicio.verComandas());
    }
    private void nuevoEmpleado () {
        System.out.println();
    }
    private void eliminarEmpleado () {

    }
    private void cambiarPrecio () {
        Scanner teclado = new Scanner(System.in);
        servicio.verCarta();
        System.out.println(Constantes.INTRODUZCA_ID_PLATO);
        int idPlato = teclado.nextInt();
        System.out.println(Constantes.NUEVO_PECIO);
        if (servicio.cambiarPrecio(idPlato, teclado.nextInt()))
            System.out.println(Constantes.PRECIO_CAMBIADO);
        else
            System.out.println(Constantes.ERROR_CAMBIAR_PRECIO);
    }
    private void eliminarCarta() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.COMFIRMACION_ELIMINAR_PEDIDO);
        if (teclado.nextLine().equalsIgnoreCase("si"))
            if (servicio.eliminarCarta())
                System.out.println(Constantes.CARTA_ELIMINADA);
            else
                System.out.println(Constantes.ERROR_ELIMINAR_CARTA);
    }
}
