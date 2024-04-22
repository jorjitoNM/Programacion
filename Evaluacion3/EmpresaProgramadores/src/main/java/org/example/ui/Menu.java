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
        System.out.println(Constantes.ELIMINAR_EMPLEADOS);
        System.out.println(Constantes.ELIMINAR_EMPLEADO);
        System.out.println(Constantes.MOSTRAR_EMPLEADOS);
        System.out.println(Constantes.MOSTRAR_EMPLEADOS_POR_SALARIO);
        return teclado.nextInt();
    }
    public void menu () {
        switch (opcionMenu()) {
            case 1:
                nuevoTrabajador();
                break;
            case 2:
                eliminarTrabajadores();
                break;
            case 3:
                eliminarTrabajador();
                break;
            case 4:
                mostrarTrabajadores();
                break;
            case 5:
                mostrarPorSalario();
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
            System.out.println(Constantes.ERROR_ELIMINAR);

    }
    private void eliminarTrabajador () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.NOMBRE_ELIMINAR);
        String nombre = teclado.nextLine();
        System.out.println(Constantes.APELLIDO_ELMINAR);
        if (servicio.eliminarTrabajador(nombre,teclado.nextLine()))
            System.out.println(Constantes.TRABAJADOR_ELIMINADOS);
        else
            System.out.println(Constantes.ERROR_ELIMINAR);
    }
    private void mostrarTrabajadores () {
        System.out.println(servicio.mostrarTrabajadores());
    }
    private void mostrarPorSalario () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_SALARIO);
        String rango = teclado.nextLine();
        boolean exit = false;
        int numeroA = 0;
        int numeroB = 0;
        do {
            try {
                numeroA = Integer.parseInt(rango.split(" ")[0]);
                numeroB = Integer.parseInt(rango.split(" ")[1]);
                exit = true;
            } catch (NumberFormatException exception) {
                System.out.println(Constantes.INTRODUZCA_NUMERO);
            }
        }while (!exit);
        System.out.println(servicio.mostrarPorSalario(numeroA, numeroB));
    }
}
