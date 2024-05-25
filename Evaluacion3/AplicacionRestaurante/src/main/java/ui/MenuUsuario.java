package ui;

import common.Constantes;
import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import lombok.extern.log4j.Log4j2;
import service.GestionClientes;
import service.IGestionClientes;

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
                case 8:
                    cambiarContraseña(idUsuario);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
            try {
                servicio.guardarFicheros();
            } catch (IOException e) {
                System.out.println(Constantes.IO_EXCEPTION_ERROR);
            }
        } while (!exit);
    }

    private void cambiarContraseña(int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println(Constantes.INTRODUZCA_NUEVA_CONTRASEÑA);
            String contraseña = teclado.nextLine();
            System.out.println(Constantes.COMFIRMAR_CONTRASEÑA);
            String comfirmacion = teclado.nextLine();
            if (!contraseña.equals(comfirmacion))
                System.out.println(Constantes.CONTRASEÑAS_NO_COINCIDEN);
            else {
                try {
                    if (!servicio.cambiarContraseña(idUsuario,contraseña))
                        System.out.println(Constantes.CONTRASEÑA_DEBIL);
                    else
                        System.out.println(Constantes.CONTRASEÑA_CAMBIADA);
                } catch (IOException e) {
                    System.out.println(Constantes.IO_EXCEPTION_ERROR);
                }
                exit = true;
            }
        }while(!exit);
    }

    public int opcionMenUsuario () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            System.out.println(Constantes.MENU_USUARIO + "\n"
                    + Constantes.MU_OP_1_AÑADIR_PLATO + "\n"
                    + Constantes.MU_OP_2_VER_CESTA + "\n"
                    + Constantes.MU_OP_3_ELIMINAR_PLATO + "\n"
                    + Constantes.MU_OP_4_INICIAR_PEDIDO + "\n"
                    + Constantes.MU_OP_5_TIEMPO_ESPERA + "\n"
                    + Constantes.MU_OP_6_VER_PLATOS_POR_TIPO + "\n"
                    + Constantes.MU_OP_7_PEDIR_CUENTA + "\n"
                    + Constantes.MU_OP_8_CAMBIAR_CONTRASEÑA + "\n"
                    + Constantes.MU_OP_9_SALIR);
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                exit = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        } while (!exit);
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
            System.out.println(servicio.mostrarMenu());
            System.out.println(Constantes.NOMBRE_PLATO);
            String nombrePlato = teclado.nextLine();
            if (nombrePlato.equalsIgnoreCase(Constantes.SUFICIENTE))
                idPedido = -1;
            else {
                System.out.println(Constantes.CANTIDAD);
                int cantidad = 0;
                try {
                    cantidad = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(Constantes.SOLO_NUMEROS);
                }
                if(servicio.añadirPlato(nombrePlato,cantidad,idPedido,idUsuario))
                    System.out.println(Constantes.PLATO_AÑADIDO_CORRECTAMENTE);
                else
                    System.out.println(Constantes.ERROR_AÑADIR_PLATO);
            }
        }
    }
    private void verCesta (int idUsuario) {
        int idPedido;
        try {
            idPedido = idPedido(idUsuario);
        if (idPedido != -1)
            System.out.println(servicio.mostrarCarrito(idPedido));
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
    }
    private void eliminarPlato (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = 0;
        boolean exit = false;
        try {
            idPedido = idPedido(idUsuario);
            System.out.println(servicio.mostrarCarrito(idPedido));
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
        while(idPedido != -1 || !exit) {
            try {
                if (servicio.carritoVacio(idPedido,idUsuario)) {
                    System.out.println(Constantes.CARRITO_VACIO);
                    exit = true;
                } else {
                System.out.println(Constantes.ELIMINAR_PLATO);
                String nombrePlato = teclado.nextLine();
                if (nombrePlato.equalsIgnoreCase(Constantes.NINGUNO))
                    idPedido = -1;
                else {
                    if (servicio.eliminarPlato(nombrePlato, idPedido))
                        System.out.println(Constantes.PLATO_ELIMINADO_CORRECTAMENTE);
                    else
                        System.out.println(Constantes.ERROR_ELIMINAR_PLATO);
                }
                }
            } catch (PedidoNoEncontrado e) { //ejemplo de doble excepcion

            }
        }
    }
    private int opcionCrearPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = -1;
        System.out.println(Constantes.NO_EXISTE_PEDIDO);
        int respuesta = 0;
               respuesta = Integer.parseInt(teclado.nextLine());
        if (respuesta == 1) {
            idPedido = servicio.nuevoPedido(idUsuario);
            if (idPedido == -1)
                System.out.println(Constantes.ERROR_NUEVO_PEDIDO);
        }
        return idPedido;
    }
    private int opcionCrearPedido2 (int idUsuario) {
        int idPedido;
        idPedido = servicio.nuevoPedido(idUsuario);
        if (idPedido == -1)
            System.out.println(Constantes.ERROR_NUEVO_PEDIDO);
        return idPedido;
    }
    private int idPedido (int idUsuario) throws PedidoNoEncontrado {
        Scanner teclado = new Scanner(System.in);
        int idPedido;
        System.out.println(servicio.verPedidos(idUsuario));
        System.out.println(Constantes.INTRODUZCA_ID_PEDIDO);
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("nuevo pedido"))
            idPedido = opcionCrearPedido2(idUsuario);
        else {
            idPedido = Integer.parseInt(respuesta);
            servicio.validarPedido(idPedido);
        }
        return idPedido;
    }
    private void iniciarPedido (int idUsuario) {
        Scanner teclado = new Scanner(System.in);
        int idPedido = -1;
        try {
            idPedido = idPedido(idUsuario);
            if (!servicio.pedidoIsEmpty(idPedido)) {
                System.out.println(Constantes.QUIERE_AÑADIR_CUPONES);
                if (teclado.nextLine().equalsIgnoreCase("si")) {
                    servicio.mostrarCupones(idUsuario);
                    servicio.iniciarPedido(añadirCupon(idUsuario), idPedido,idUsuario);
                } else
                    servicio.iniciarPedido(idUsuario, idPedido);
                System.out.println(Constantes.PEDIDO_COMENZADO);
            } else
                System.out.println(Constantes.ERROR_INICIAR_PEDIDO_VACIO);
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
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
                System.out.printf("%s%.2f%s\n",Constantes.EL_TIEMPO_ESTIMAD_ES,servicio.tiempoEspera(idPedido),Constantes.MINUTOS);
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
            if (idPedido != -1)
                System.out.println(servicio.pedirCuenta(idPedido,idUsuario));
        } catch (PedidoNoEncontrado e) {
            System.out.println(Constantes.PEDIDO_NO_ENCONTRADO);
        }
    }
}