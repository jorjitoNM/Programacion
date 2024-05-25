package org.example.ui;

import org.example.common.Constantes;
import org.example.common.DificultadException;
import org.example.domain.Alpina;
import org.example.domain.Fondo;
import org.example.domain.Pista;
import org.example.service.GestionUsuario;

import java.io.IOException;
import java.util.*;

public class MenuUsuario {
    private GestionUsuario servicio;

    public MenuUsuario() {
        servicio = new GestionUsuario();
    }
    public void menuUsuario () {
        boolean exit = false;
        do {
            switch (opcionMenuUsuario()) {
                case 1:
                    mostrarPistas();
                    break;
                case 2:
                    mostrarPistasPorProvincia();
                    break;
                case 3:
                    añadirPista();
                    break;
                case 4:
                    extensionProvincia();
                    break;
                case 5:
                    nuevoPueblo();
                    break;
                case 6:
                    eliminarPista();
                    break;
                case 7:
                    escribirTXT();
                    break;
                case 8:
                    guardarBinario();
                    break;
                case 9:
                    leerBinario();
                    break;
                case 10:
                    leerTXT();
                    break;
                case 11:
                    mostrarPistasDeCadaProvincia();
                    break;
                case 12:
                    exit = true;
                    break;
                default:
                    System.out.println(Constantes.OPCION_NO_VALIDA);
            }
        }while(!exit);

    }

    private void escribirTXT() {
        try {
            if (servicio.escribirTXT())
                System.out.println(Constantes.ACCION_COMPLETADA);
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION);
        }
    }

    private void leerTXT() {
        try {
            servicio.leerTXT();
            System.out.println(Constantes.ACCION_COMPLETADA);
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION);
        }
    }

    private void mostrarPistasDeCadaProvincia() {
        System.out.println(servicio.mostrarPistasPorProvincia());
    }

    private void leerBinario() {
        try {
            servicio.leerBinario();
            System.out.println(Constantes.ACCION_COMPLETADA);
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION);
        }
    }

    private void guardarBinario() {
        try {
            servicio.guardarBinario();
            System.out.println(Constantes.ACCION_COMPLETADA);
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION);
        }
    }

    private void guardarJSON() {
        try {
            if (servicio.guardarJSON())
                System.out.println(Constantes.GUARDADO_CON_EXITO);
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION);
        }
    }

    private void eliminarPista() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(servicio.getListaPistas());
        System.out.println(Constantes.INTRODUZCA_ID_PISTA);
        int id = -1;
        boolean valido = true;
        do {
            try {
                id = Integer.parseInt(teclado.nextLine());
                valido = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH);
            }
        }while(valido);
        if (servicio.eliminarPista(id))
            System.out.println(Constantes.PISTA_ELIMINADA);
        else
            System.out.println(Constantes.ERROR_ELIMINAR_PISTA);
    }

    private void nuevoPueblo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(servicio.getListaPistas(Constantes.FONDO));
        System.out.println(Constantes.INTRODUZCA_ID_PISTA);
        int id = -1;
        boolean valido = true;
        do {
            try {
                id = Integer.parseInt(teclado.nextLine());
                valido = false;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH);
            }
        }while(valido);
        System.out.println(Constantes.INTRODUZCA_NUEVO_PUEBLO);
        String nombrePueblo = teclado.nextLine();
        if (servicio.addPuebloListaPueblos(id,nombrePueblo))
            System.out.println(Constantes.POBLACION_AÑADIDA);
        else
            System.out.println(Constantes.ERROR_AÑADIR_POBLACION);

    }

    private void extensionProvincia() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_PROVINCIA);
        String provincia = teclado.nextLine();
        double extension = servicio.extensionProvincia(provincia);
        if (extension == 0)
            System.out.println(Constantes.NO_HAY_PISTAS);
        else
            System.out.println(Constantes.LA_EXTENSIO_TOTAL + provincia + Constantes.ES_DE + extension);
    }

    private void añadirPista() {
        Scanner teclado = new Scanner(System.in);
        boolean fondo = false;
        boolean valido = true;
        boolean exito = false;
        System.out.println(Constantes.FONDO_O_ALPINO);
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("fondo"))
            fondo = true;
        else if (!respuesta.equalsIgnoreCase("alpino")) {
            valido = false;
        }
        if (valido) {
            System.out.println(Constantes.INTRODUZCA_NOMBRE_PISTA);
            String nombre = teclado.nextLine();
            System.out.println(Constantes.INTRODUZCA_PROVINCIA_PISTA);
            String provincia = teclado.nextLine();
            System.out.println(Constantes.INTRODUZCA_LONGITUD_PISTA);
            double km = Double.parseDouble(teclado.nextLine());
            if (fondo) {
                System.out.println(Constantes.INTRODUZCA_LAS_POBLACIONES);
                String poblaciones = teclado.nextLine();
                try {
                    if (servicio.addPista(new Fondo(nombre,provincia,km,poblaciones)))
                        exito = true;
                } catch (DificultadException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println(Constantes.INTRODUZCA_DIFICULTAD_PISTA);
                String dificultad = teclado.nextLine();
                try {
                    if (servicio.addPista(new Alpina(nombre,provincia,km,dificultad)))
                       exito = true;
                } catch (DificultadException e) {
                    System.out.println(Constantes.ERROR_DIFICULTAD_NO_VALIDA);
                }
            }
            if (exito)
                System.out.println(Constantes.PISTA_FONDO_AÑADIDA);
            else
                System.out.println(Constantes.ERROR_NUEVA_PISTA);
        }
        else{
            System.out.println(Constantes.TIPO_PISTA_NO_VALIDO);
        }
    }

    private void mostrarPistasPorProvincia() {
       Map<String, List<Pista>> map = servicio.getPistasProvincia();
       map.forEach((k,v) -> {
           System.out.println(k);
           v.stream().sorted(Comparator.comparing(Pista::getNombre)).forEach(System.out::println);
       });
    }

    private void mostrarPistas() {
        System.out.println(servicio.getListaPistas());
    }

    private int opcionMenuUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MENU_USUARIO + "\n"
                            + Constantes.OPCION_1_MOSTRAR_PISTAS + "\n"
                            + Constantes.OPCION_2_MOSTRAR_PISTAS_POR_PROVINCIA + "\n"
                            + Constantes.OPCION_3_NUEVA_PISTA + "\n"
                            + Constantes.OPCION_4_VER_KM_PROVINCIA + "\n"
                            + Constantes.OPCION_5_NUEVO_PUEBLO + "\n"
                            + Constantes.OPCION_6_ELIMINAR_PISTA + "\n"
                            + Constantes.OPCION_7_GUARDAR_FICHERO_JSON + "\n"
                            + Constantes.OPCION_8_GUARDAR_FICHERO_BINARIO + "\n"
                            + Constantes.OPCION_9_LEER_FICHERO_BINARIO + "\n"
                            + Constantes.OPCION_10_LEER_FICHERO_JSON + "\n"
                            + Constantes.OPCION_11_MOSTRAR_PISTAS_POR_PROVINCIA + "\n"
                            + Constantes.SALIR + "\n"
        );
        int opcion = -1;
        boolean valido = true;
        do {
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                valido = false;
            } catch (NumberFormatException e) {
                System.out.println(Constantes.INPUT_MISSMATCH);
            }
        }while(valido);
        return opcion;
    }
}
