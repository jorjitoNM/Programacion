package ui;

import common.Constantes;
import common.PedidoNoEncontrado;
import service.GestionUsuario;
import service.IGestionUsuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionUsuario servicio;

    public MenuUsuario() {
        servicio = new GestionUsuario();
    }

    public void menuUsuario (String nombreUsuario) {
        boolean exit = false;
        do {
            switch (opcionMenUsuario()) {
                case 1:
                    añadirPlato(nombreUsuario);
                    break;
                case 2:
                    verCesta();
                    break;
                case 3:
                    eliminarPlato(nombreUsuario);
                case 4:
                    iniciarPedido();
                case 5:
                    tiempoEspera();
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
    private void añadirPlato (String nombreUsuario) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = opcionCrearPedido();
        while(!exit) {
            servicio.verPedidos(nombreUsuario);
            servicio.mostrarMenu();
            System.out.println(Constantes.NOMBRE_PLATO);
            String nombrePalto = teclado.nextLine();
            if (!nombrePalto.equalsIgnoreCase(Constantes.SUFICIENTE))
                exit = true;
            else {
                System.out.println(Constantes.CANTIDAD);
                int cantidad = teclado.nextInt();
                try {
                    servicio.añadirPlato(nombrePalto,cantidad,idPedido());
                } catch (PedidoNoEncontrado e) {
                    System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
                }
            }
        }
    }
    private void verCesta () {
        boolean validado = opcionCrearPedido();
        if (validado)
            servicio.mostrarCarrito();
    }
    private void eliminarPlato (String nombreUsuario) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = opcionCrearPedido();
        while(!exit) {
            servicio.verPedidos(nombreUsuario);
            System.out.println(Constantes.ELIMINAR_PLATO);
            String nombrePlato = teclado.nextLine();
            if (!nombrePlato.equalsIgnoreCase(Constantes.NINGUNO))
                exit = true;
            else {
                try {
                    servicio.eliminarPlato(nombrePlato,idPedido());
                } catch (PedidoNoEncontrado exception) {
                    System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
                }
            }
        }
    }
    private boolean opcionCrearPedido () {
        Scanner teclado = new Scanner(System.in);
        boolean exist = true;
        if (!servicio.existePedido()) {
            System.out.println(Constantes.NO_EXISTE_PEDIDO);
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("ok")) {
                servicio.nuevoPedido();
            }
            else
                exist = false;
        }
        return exist;
    }
    private int idPedido () throws PedidoNoEncontrado {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_ID_PEDIDO);
        int idPedido = teclado.nextInt();
        servicio.validarPedido(idPedido);
        return idPedido;
    }
    private void iniciarPedido () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.QUIERE_AÑADIR_CUPONES);
        if (teclado.nextLine().equalsIgnoreCase("si")) {
            servicio.mostrarCupones();
            servicio.iniciarPedido(añadirCupon());
        }
        else
            servicio.iniciarPedido();
        System.out.println(Constantes.PEDIDO_COMENZADO);
    }
    private String añadirCupon () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_CUPON);
        return teclado.nextLine();
    }
    private void tiempoEspera () {

    }
}