package ui;

import common.Constantes;
import service.GestionUsuario;
import service.IGestionUsuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionUsuario servicio;

    public MenuUsuario() {
        servicio = new GestionUsuario();
    }

    public MenuUsuario(IGestionUsuario gestionUsuario) {
        this.servicio = gestionUsuario;
    }

    public void menuUsuario () {
        boolean exit = false;
        do {
            switch (opcionMenUsuario()) {
                case 1:
                    añadirPlato();
                    break;
                case 2:
                    verCesta();
                    break;
                case 3:
                    eliminarPlato();
                case 4:
                    iniciarPedido();
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    public int opcionMenUsuario () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU_USUARIO + "\n" + Constantes.INICIAR_PEDIDO + "\n" + Constantes.VER_CESTA);
                opcion = teclado.nextInt();
                exit = true;
            } catch (InputMismatchException exception) {
                teclado.nextLine();
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        }while (!exit);
        return opcion;
    }
    private void añadirPlato () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = opcionCrearPedido();
        while(!exit) {
            servicio.mostrarMenu();
            System.out.println(Constantes.NOMBRE_PLATO);
            String nombrePalto = teclado.nextLine();
            if (!nombrePalto.equalsIgnoreCase(Constantes.SUFICIENTE))
                exit = true;
            else {
                System.out.println(Constantes.CANTIDAD);
                int cantidad = teclado.nextInt();
                servicio.añadirPlato(nombrePalto,cantidad,idPedido);
            }
        }
    }
    private void verCesta () {
        Scanner teclado = new Scanner(System.in);
        boolean validado = opcionCrearPedido();
        if (validado)
            servicio.mostrarCarrito();
    }
    private void eliminarPlato () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = opcionCrearPedido();
        if (exit) {
            System.out.println(Constantes.ELIMINAR_PLATO);
            String nombrePlato = teclado.nextLine();
            servicio.eliminarPlato();
        }
        else
            System.out.println(Constantes.ERROR_PEDIDO);
    }
    private boolean opcionCrearPedido () {
        Scanner teclado = new Scanner(System.in);
        boolean exist = true;
        int idPedido;
        if (!servicio.existePedido()) {
            System.out.println(Constantes.NO_EXISTE_PEDIDO);
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("ok")) {
                idPedido = servicio.nuevoPedido();
            }
            else
                exist = false;
        }
        return exist;
    }
    private int idPedido () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_NOMBRE);
        return servicio.darIDPedido(teclado.nextLine());
    }
    private void iniciarPedido () {

    }
}
