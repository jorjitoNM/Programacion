package org.example.ui;

import org.example.common.Constantes;
import org.example.service.Servicio;

import java.util.Scanner;

public class Menu {
    private Servicio servicio;

    public Menu() {
        servicio = new Servicio();
    }
    private int opcionMenu () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MENU_USUARIO);
        System.out.println(Constantes.NUEVO_EMPLEADO);
        return teclado.nextInt();
    }
    private void menu () {
        switch (opcionMenu()) {
            case 1:
                nuevoTrabajador();
                break;
            case 2:
                eliminarTrabajadores();
            default:
                System.out.println(Constantes.OPCION_INCORRECTA);
        }
    }

    private void nuevoTrabajador() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.TIPO_TRABAJADOR);
        boolean exit = false;
        String respuesta;
        do {
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("programador") || respuesta.equalsIgnoreCase("jefe de proyecto"))
                exit = true;
        }while (!exit);
        System.out.println(Constantes.NOMBRE);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.APELLIDO);
        String apellido = teclado.nextLine();
        System.out.println(Constantes.AÑO_INCORPORACION);
        int año = teclado.nextInt();
        System.out.println(Constantes.DEPARTAMENTO);
        String departamento = teclado.nextLine();
        System.out.println(Constantes.SUELDO_DIA);
        int sueldoDia = teclado.nextInt();
        if (respuesta.equalsIgnoreCase("programador")) {
            System.out.println(Constantes.LENGUAJES);
            String lenguajes = teclado.nextLine();
            servicio.nuevoProgramador(nombre,apellido,año,departamento,sueldoDia,lenguajes);
        }
        else {
            System.out.println(Constantes.INCENTIVO);
            int personas = teclado.nextInt();
            servicio.nuevoJefe(nombre,apellido,año,departamento,sueldoDia,personas);
        }

    }
    private void eliminarTrabajadores () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.AÑO_ELIMINACION);
        if (servicio.eliminarTrabajadores(teclado.nextInt()))
            System.out.println(Constantes.TRABAJADORES_ELIMINADOS);
        else
            System.out.println();

    }
}
