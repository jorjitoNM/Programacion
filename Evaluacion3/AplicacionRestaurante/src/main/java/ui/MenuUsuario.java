package ui;

import common.Constantes;
import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import lombok.extern.log4j.Log4j2;
import service.GestionClientes;
import service.IGestionClientes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Log4j2
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
                    break;
                case 4:
                    iniciarPedido(idUsuario);
                    break;
                case 5:
                    tiempoEspera(idUsuario);
                    break;
                case 6:
                    verPlatosPorTipo();
                    break;
                case 7:
                    pedirCuenta(idUsuario);
                    break;
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
        try {
            idPedido = idPedido(idUsuario);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        while(idPedido != -1) {
            servicio.mostrarMenu();
            System.out.println(Constantes.NOMBRE_PLATO);
            String nombrePalto = teclado.nextLine();
            if (!nombrePalto.equalsIgnoreCase(Constantes.SUFICIENTE))
                idPedido = -1;
            else {
                System.out.println(Constantes.CANTIDAD);
                int cantidad = teclado.nextInt();
                try {
                    if(servicio.añadirPlato(nombrePalto,cantidad,idPedido))
                        System.out.println(Constantes.PLATO_AÑADIDO_CORRECTAMENTE);
                    else
                        System.out.println(Constantes.ERROR_AÑADIR_PLATO);
                } catch (FileNotFoundException e) {
                    log.fatal(Constantes.LOG_FILE_NOT_FOUND);
                }
            }
        }
    }
    private void verCesta (int idUsuario) {
        int idPedido = 0;
        try {
            idPedido = idPedido(idUsuario);
        if (idPedido != -1)
            servicio.mostrarCarrito(idPedido);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
    }
    private void eliminarPlato (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = 0;
        try {
            idPedido = idPedido(idUsuario);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        while(idPedido != -1) {
            System.out.println(Constantes.ELIMINAR_PLATO);
            String nombrePlato = teclado.nextLine();
            if (!nombrePlato.equalsIgnoreCase(Constantes.NINGUNO))
                idPedido = -1;
            else {
                if(servicio.eliminarPlato(nombrePlato,idPedido))
                    System.out.println(Constantes.PLATO_ELIMINADO_CORRECTAMENTE);
                else
                    System.out.println(Constantes.ERROR_ELIMINAR_PLATO);
            }
        }
    }
    private int opcionCrearPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = -1;
        System.out.println(Constantes.NO_EXISTE_PEDIDO);
        int respuesta = teclado.nextInt();
        if (respuesta == 1) {
            idPedido = servicio.nuevoPedido(idUsuario);
            if (idPedido == -1) {
                System.out.println(Constantes.ERROR_NUEVO_PEDIDO);
            }
        }
        return idPedido;
    }
    private int opcionCrearPedido2 (int idUsuario) {
        int idPedido;
        idPedido = servicio.nuevoPedido(idUsuario);
        if (idPedido == -1) {
            System.out.println(Constantes.ERROR_NUEVO_PEDIDO);
        }
        return idPedido;
    }
    private int idPedido (int idUsuario) throws PedidoNoEncontrado {
        Scanner teclado = new Scanner(System.in);
        int idPedido;
        servicio.verPedidos(idUsuario);
        System.out.println(Constantes.INTRODUZCA_ID_PEDIDO);
        if (teclado.nextLine().equalsIgnoreCase(" nuevo pedido")) {
            idPedido = opcionCrearPedido2(idUsuario);
        }
        else {
            idPedido = teclado.nextInt();
            servicio.validarPedido(idPedido);
        }
        return idPedido;
    }
    private void iniciarPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.QUIERE_AÑADIR_CUPONES);
        int idPedido = -1;
        try {
            idPedido = idPedido(idUsuario);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        if (teclado.nextLine().equalsIgnoreCase("si")) {
            servicio.mostrarCupones(idUsuario);
            servicio.iniciarPedido(idUsuario,añadirCupon(idUsuario),idPedido);
        }
        else
            servicio.iniciarPedido(idUsuario,idPedido);
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
        int idPedido = -1;
        try {
            idPedido = idPedido(idUsuario);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        if (idPedido != -1) {
            try {
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
        String tipo;
        do{
            tipo = teclado.nextLine();
            switch (tipo) {
                case "Principal":
                case "principal":
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
        System.out.println(servicio.mostrarMenu(tipo));
    }
    private void pedirCuenta (int idUsuario) {
        int idPedido = -1;
        try {
            idPedido = idPedido(idUsuario);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        if (idPedido != -1)
            System.out.println(servicio.pedirCuenta());
    }

}