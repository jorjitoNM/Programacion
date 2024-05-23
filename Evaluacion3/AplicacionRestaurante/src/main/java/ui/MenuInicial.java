package ui;

import common.Constantes;
import common.Utilidades;
import dao.Clientes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicial {
    public void menuInicial () throws IOException {
        boolean exit = false;
        do {
            switch (opcionMenuInicial()) {
                case 1:
                    inicioSesion();
                    break;
                case 2:
                    if (controlSeguridad()) {
                        MenuPersonal menuPersonal = new MenuPersonal();
                        menuPersonal.menuPersonal();
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        } while (!exit);
    }
    public int opcionMenuInicial () {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU_INICIAL + "\n" + Constantes.CLIENTE + "\n" + Constantes.TRABAJADOR + "\n" + Constantes.OPCION_3_SALIR);
                opcion = teclado.nextInt();
                exit = true;
            } catch (InputMismatchException exception) {
                teclado.nextLine();
                System.out.println(Constantes.SOLO_NUMEROS);
            }
        }while (!exit);
        return opcion;
    }
    public boolean controlSeguridad() {
        Scanner teclado = new Scanner(System.in);
        int contador = 0;
        boolean logged = false;
        do {
            System.out.println(Constantes.INTRODUZCA_CONTRASEÑA);
            if (Utilidades.controlSeguridad(teclado.nextLine()))  {
                logged = true;
                contador = 6;
            }
            else {
                System.out.println(Constantes.CONTRASEÑA_INCORRECTA);
                contador++;
            }
        }while(contador <= 5);
        return logged;
    }
    private void inicioSesion () throws IOException {
        Scanner teclado = new Scanner(System.in);
        Clientes clientes = new Clientes();
        boolean exit = false;
        do {
            System.out.println(clientes.mostrarIDsUsuarios());
            System.out.println(Constantes.INTRODUZCA_ID_USUARIO);
            int idUsuario = teclado.nextInt();
            if(clientes.comprobarCliente(idUsuario)) {
                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.menuUsuario(idUsuario);
                exit = true;
            } else
                System.out.println(Constantes.ERROR_NO_REGISTRADO);
        }while(!exit);

    }
}