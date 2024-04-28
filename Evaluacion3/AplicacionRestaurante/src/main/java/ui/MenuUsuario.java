package ui;

import common.Constantes;
import service.GestionUsuario;
import service.IGestionUsuario;

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
            switch () {
                case 1:
                    añadirPlato();
                    break;
                case 2:
                    verCesta();
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    public void añadirPlato () {
        Scanner teclado = new Scanner(System.in);
        do {
            servicio.mostrarMenu();
            System.out.println();
        }while();
    }
    public void verCesta () {
        Scanner teclado = new Scanner(System.in);
        boolean validado = true;
        if (!servicio.existePedido()) {
            System.out.println(Constantes.NO_EXISTE_PEDIDO);
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("ok")) {
                servicio.nuevoPedido();
            }
            else {
                validado = false;
            }
        }
        if (validado)
            servicio.mostrarCarrito();
    }
}
