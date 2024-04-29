package ui;

import common.Constantes;
import common.Utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicial {
    public void menuInicial () {
        boolean exit = false;
        do {
            switch (opcionMenuInicial()) {
                case 1:
                    break;
                case 2:
                    if (controlSeguridad()) {
                        MenuPersonal menuersonal = new MenuPersonal();
                        menuersonal.menuPersonal();
                    }
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
                System.out.println(Constantes.MENU_INICIAL + "\n" + Constantes.CLIENTE + "\n" + Constantes.TRABAJADOR);
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
        System.out.println(Constantes.INTRODUZCA_CONTRASEÑA);
        do {
            if (Utilidades.controlSeguridad(teclado.nextLine()))  {
                logged = true;
                contador = 6;
            }
            else
                contador++;
        }while(contador <= 5);
        return logged;
    }
}