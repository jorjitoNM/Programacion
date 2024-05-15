package ui;

import common.Constantes;
import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import service.GestionClientes;
import service.IGestionClientes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionClientes servicio;

    public MenuUsuario() throws IOException {
        servicio = new GestionClientes();
    }

    public void menuUsuario (int idUsuario) {
        boolean exit = false;
        do {
            switch (opcionMenUsuario()) {
                case 1:
                    añadirPlato(idUsuario);
                    break;
                case 2:
                    verCesta(idUsuario);
                    break;
                case 3:
                    eliminarPlato(idUsuario);
                case 4:
                    iniciarPedido(idUsuario);
                case 5:
                    tiempoEspera(idUsuario);
                case 6:
                    verPlatosPorTipo();
                case 7:
                    pedirCuenta(idUsuario);
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
                System.out.println(Constantes.MENU_USUARIO + "\n" + Constantes.AÑADIR_PLATO + "\n" + Constantes.VER_CESTA + "\n" + Constantes.OPCION_ELIMINAR_PLATO + "\n" + Constantes.INICIAR_PEDIDO + "\n" + Constantes.TIEMPO_ESPERA + "\n" + Constantes.VER_PLATOS_POR_TIPO + "\n" + Constantes.PEDIR_CUENTA);
                opcion = teclado.nextInt();
                exit = true;
            } catch (InputMismatchException exception) {
                teclado.nextLine();
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        }while (!exit);
        return opcion;
    }
    private void añadirPlato (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = -1;
        boolean exit = false;
        servicio.verPedidos(idUsuario);
        do {
            try {
                idPedido = idPedido();
                exit = true;
            } catch (PedidoNoEncontrado e) {
                if (opcionCrearPedido(idUsuario))
                    exit = true;
            }
        }while(!exit);
        while(exit) {
            servicio.verPedidos(idUsuario);
            servicio.mostrarMenu();
            System.out.println(Constantes.NOMBRE_PLATO);
            String nombrePalto = teclado.nextLine();
            if (!nombrePalto.equalsIgnoreCase(Constantes.SUFICIENTE))
                exit = false;
            else {
                System.out.println(Constantes.CANTIDAD);
                int cantidad = teclado.nextInt();
                try {
                    if(servicio.añadirPlato(nombrePalto,cantidad,idPedido()))
                        System.out.println(Constantes.PLATO_AÑADIDO_CORRECTAMENTE);
                    else
                        System.out.println(Constantes.ERROR_AÑADIR_PLATO);
                } catch (PedidoNoEncontrado e) {
                    System.out.println(Constantes.ERROR_PEDIDO);
                } catch (FileNotFoundException e) {

                }
            }
        }
    }
    private void verCesta (int idUsuario) {
        boolean validado = opcionCrearPedido(idUsuario);
        if (validado) {
            try {
                servicio.mostrarCarrito(idPedido());
            } catch (PedidoNoEncontrado e) {
                System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
            }
        }
    }
    private void eliminarPlato (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = -1;
        boolean exit = false;
        servicio.verPedidos(idUsuario);
        do {
            try {
                idPedido = idPedido();
                exit = true;
            } catch (PedidoNoEncontrado e) {
                if (opcionCrearPedido(idUsuario))
                    exit = true;
            }
        }while(!exit);
        while(exit) {
            System.out.println(Constantes.ELIMINAR_PLATO);
            String nombrePlato = teclado.nextLine();
            if (!nombrePlato.equalsIgnoreCase(Constantes.NINGUNO))
                exit = false;
            else {
                if(servicio.eliminarPlato(nombrePlato,idPedido))
                    System.out.println(Constantes.PLATO_ELIMINADO_CORRECTAMENTE);
                else
                    System.out.println(Constantes.ERROR_ELIMINAR_PLATO);
            }
        }
    }
    private boolean opcionCrearPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        boolean exist = true;
        System.out.println(Constantes.NO_EXISTE_PEDIDO);
        int respuesta = teclado.nextInt();
        if (respuesta == 1)
            servicio.nuevoPedido(idUsuario);
        else
            exist = false;
        return exist;
    }
    private int idPedido () throws PedidoNoEncontrado {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_ID_PEDIDO);
        int idPedido = teclado.nextInt();
        servicio.validarPedido(idPedido);
        return idPedido;
    }
    private void iniciarPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.QUIERE_AÑADIR_CUPONES);
        servicio.verPedidos(idUsuario);
        if (teclado.nextLine().equalsIgnoreCase("si")) {
            servicio.mostrarCupones();
            try {
                servicio.iniciarPedido(idUsuario,añadirCupon(idUsuario),idPedido());
            } catch (PedidoNoEncontrado e) {
                System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
            }
        }
        else {
            try {
                servicio.iniciarPedido(idUsuario,idPedido());
            } catch (PedidoNoEncontrado e) {
                System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
            }
        }
        System.out.println(Constantes.PEDIDO_COMENZADO);
    }
    private String añadirCupon (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        System.out.println(Constantes.INTRODUZCA_CUPON);
        String codigo = teclado.nextLine();
        do {
            try {
                servicio.validarCupon(codigo,idUsuario);
                exit = true;
            } catch (CuponNoValidoException e) {
                System.out.println(Constantes.CUPON_NO_VALIDO);
            }
        }while(!exit);
        return codigo;
    }
    private void tiempoEspera (int idUsuario) {
        int idPedido = 0;
        if (opcionCrearPedido(idUsuario)) {
            try {
                idPedido = idPedido();
                System.out.println(Constantes.EL_TIEMPO_ESTIMAD_ES + servicio.tiempoEspera(idPedido) + Constantes.MINUTOS);
                System.out.println(Constantes.PEDIDO_LLEGARA + servicio.horaEntrega(idPedido).toLocalTime().toString());
            } catch (PedidoNoEncontrado e) {
                System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
            }
        }
    }
    private void verPlatosPorTipo () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        System.out.println(Constantes.TIPO_PLATO);
        String tipo = teclado.nextLine();
        do{
            switch (tipo) {
                case "Principal":
                case "principal":
                    servicio.mostrarMenu(tipo);
                    exit = true;
                    break;
                case "Acompañante":
                case "acompañante":
                    exit = true;
                    break;
                case "Guarnicion":
                case "guarnicion":
                    exit = true;
                    break;
                case "Postre":
                case "postre":
                    exit = true;
                    break;
                case "Salir":
                case "salir":
                    exit = true;
                    break;
                default:
                    System.out.println(Constantes.TIPO_NO_VALIDO);
            }
        }while(!exit);
    }
    private void pedirCuenta (int idUsuario) {
        if (opcionCrearPedido(idUsuario)) {

        }
        System.out.println(servicio.pedirCuenta());
    }

}