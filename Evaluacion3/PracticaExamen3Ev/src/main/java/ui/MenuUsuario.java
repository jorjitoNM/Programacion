package ui;

import com.sun.tools.classfile.ConstantPool;
import common.Constantes;
import service.GestionUsuario;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private GestionUsuario gestionUsuario;

    public MenuUsuario() {
        gestionUsuario = new GestionUsuario();
    }

    public MenuUsuario(GestionUsuario gestionUsuario) {
        this.gestionUsuario = gestionUsuario;
    }
    public void menuUsuario () {
        boolean exit = false;
        do {
            switch (opcionMenuUsuario()) {
                case 1:
                    nuevoCampeon();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
            }
        }while (!exit);
    }

    private void nuevoCampeon() { //deberia separar cada atributo en un metodo mas pequeño??, tiene sentido??
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MAGO_O_ASESINO);
        String respuesta = teclado.nextLine();
        boolean mago = false;
        boolean valido = true;
        if (respuesta.equalsIgnoreCase("mago"))
            mago = true;
        else if (respuesta.equalsIgnoreCase("asesino")) {

        }
        else {
            System.out.println(Constantes.ERROR_OPCION_M_A);
            valido = false;
        }
        if (valido) {
            System.out.println(Constantes.INTRODUZCA_NOMBRE);
            String nombre = teclado.nextLine();
            System.out.println(Constantes.INTRODUZCA_ATAQUE);
            int ataque = 0;
            try {
               ataque = validarAtaque(teclado.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH_EXCEPTION);
            }
            System.out.println(Constantes.INTRODUZCA_SKINS);
            int skins = teclado.nextInt();
            System.out.println(Constantes.INTRODUZCA_HABILIDADES);
            String[] habilidades = parsearHabilidades(teclado.nextLine());
        }

    }

    private String[] parsearHabilidades(String s) {
        String[] parsed = s.split(",");
        Arrays.stream(parsed).forEach(h -> );
    }

    private int validarAtaque(int i) throws InputMismatchException {
        if (i > 100 || i < 25)
            throw new InputMismatchException();
        else
            return i;
    }

    private int opcionMenuUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        return teclado.nextInt();
    }
}
