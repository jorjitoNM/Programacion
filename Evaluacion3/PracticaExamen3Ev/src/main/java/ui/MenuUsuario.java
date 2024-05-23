package ui;

import common.Constantes;
import common.HabilidadNoValidaException;
import service.GestionUsuario;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private GestionUsuario gestionUsuario;

    public MenuUsuario() {
        try {
            gestionUsuario = new GestionUsuario();
        } catch (HabilidadNoValidaException e) {
            throw new RuntimeException(e); //nunca salta
        }
    }

    public MenuUsuario(GestionUsuario gestionUsuario) {
        this.gestionUsuario = gestionUsuario;
    }
    public void menuUsuario () {
        boolean exit = false;
        do {
            switch (opcionMenuUsuario()) {
                case 1:
                    listarCampeones();
                    break;
                case 2:
                    listarCampeonesOrdenados();
                    break;
                case 3:
                    nuevoCampeon();
                    break;
                case 4:
                    mostrarCameponesPorAtaque();
                    break;
                case 5:
                    actualizarBusrt();
                    break;
                case 6:
                    eliminarCampeon();
                    break;
                case 7:
                    guardarCampeonesTXT();
                    break;
                case 8:
                    cargarFicheroTXT();
                    break;
                case 9:
                    guardarFicheroBinario();
                    break;
                case 10:
                    cargarFicheroBinario();
                    break;
                case 11:
                    mostrarCampeonesPorHabilidad();
                    break;
                case 12:
                    exit = true;
                    break;
                default:
                    System.out.println(Constantes.ERROR_OPCION);
            }
        }while (!exit);
    }

    private void mostrarCampeonesPorHabilidad() {
        System.out.println(gestionUsuario.mostrarCampeonesPorHabilidadNoLambda());
    }

    private void cargarFicheroBinario() {
        gestionUsuario.cargarFicheroBinario();
    }

    private void guardarFicheroBinario() {
        try {
            gestionUsuario.guardarFicheroBinario();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void cargarFicheroTXT() {
        gestionUsuario.cargarFicheroTXT();
    }

    private void guardarCampeonesTXT() {
        try {
            gestionUsuario.guardarFicheroTXT();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void eliminarCampeon() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(gestionUsuario.mostrarCampeones());
        System.out.println(Constantes.INTRODUZCA_ID_ELIMINAR_CAMEPEON);
        if (gestionUsuario.eliminarCampeon(teclado.nextInt()))
            System.out.println(Constantes.CAMPEON_ELIMINADO);
        else
            System.out.println(Constantes.ERROR_ELIMINAR_CAMPEON);
    }

    private void actualizarBusrt() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(gestionUsuario.mostrarCampeones(Constantes.ASESINO));
        System.out.println(Constantes.INTRODUZCA_ID_ASESINO);
        int id = Integer.parseInt(teclado.nextLine());
        System.out.println(Constantes.INTRODUZCA_BURST);
        double burst = Double.parseDouble(teclado.nextLine());
        try {
            if (gestionUsuario.actualizarBusrt(id, burst))
                System.out.println(Constantes.EXITO_CAMBIO_CARACTERISTICA);
            else
                System.out.println(Constantes.ERROR_CAMBIO_CARACTERISTICA);
        } catch (NullPointerException e) {
            System.out.println(Constantes.ID_NO_VALIDO);
        }
    }

    private void mostrarCameponesPorAtaque() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.RANGO_ATAQUE);
        String respuesta  = teclado.nextLine();
        String[] split = respuesta.split(" ");
        System.out.println(gestionUsuario.mostrarCampeonesPorAtaque(split[0].trim(),split[1].trim()));
    }

    private void listarCampeones() {
        System.out.println(gestionUsuario.mostrarCampeones());
    }

    private void listarCampeonesOrdenados() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.ASCENDENTE_O_DESCENDENTE);
        if (teclado.nextLine().equals("1"))
            System.out.println(gestionUsuario.mostrarCampeones(true));
        else
            System.out.println(gestionUsuario.mostrarCampeones(false));
    }

    private void nuevoCampeon() {
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
                ataque = validarAtaque(Integer.parseInt(teclado.nextLine()));
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH_EXCEPTION);
            }
            System.out.println(Constantes.INTRODUZCA_SKINS);
            int skins = 0;
            try {
                skins = Integer.parseInt(teclado.nextLine());
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH_EXCEPTION);
            }
            System.out.println(Constantes.INTRODUZCA_HABILIDADES);
            String habilidades = teclado.nextLine();
            System.out.println(Constantes.INTRODUZCA_ALTURA);
            double altura = 0;
            try {
                altura = Double.parseDouble(teclado.nextLine());
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INPUT_MISSMATCH_EXCEPTION);
            }
            if (mago) {
                boolean stunt = false;
                System.out.println(Constantes.TIENE_STUNT);
                if (teclado.nextLine().equalsIgnoreCase("si"))
                    stunt = true;
                try {
                    if (gestionUsuario.nuevoMago(nombre,ataque,skins,habilidades,altura,stunt))
                        System.out.println(Constantes.MAGO_AÑADIDO);
                    else
                        System.out.println(Constantes.ERROR_AÑADIR_CAMPEON);
                } catch (HabilidadNoValidaException e) {
                    System.out.println(Constantes.HABILIDAD_NO_VALIDA);
                }
            }
            else {
                System.out.println(Constantes.INTRODUZCA_BURST);
                try {
                    if (gestionUsuario.nuevoAsesino(nombre,ataque,skins,habilidades,altura,Double.parseDouble(teclado.nextLine())))
                        System.out.println(Constantes.ASESINO_AÑADIDO);
                    else
                        System.out.println(Constantes.ERROR_AÑADIR_CAMPEON);
                } catch (HabilidadNoValidaException e) {
                    System.out.println(Constantes.HABILIDAD_NO_VALIDA);
                }
            }
        }

    }

    /*private String[] parsearHabilidades(String s) {
        String[] parsed = s.split(",");
        try {
            gestionUsuario.comprobaHabilidades(parsed);
        } catch (HabilidadNoValidaException e) {
            throw new RuntimeException(e);
        }
    }*/

    private int validarAtaque(int i) throws InputMismatchException {
        if (i > 100 || i < 25)
            throw new InputMismatchException();
        else
            return i;
    }

    private int opcionMenuUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.MENU_USUARIO + "\n" + Constantes.OPCION_1_LISTAR_CAMPEONES + "\n"
                + Constantes.OPCION_2_LISTAR_CAMPEONES_ORDENADOS + "\n"
                + Constantes.OPCION_3_NUEVO_CAMPEON + "\n"
                + Constantes.OPCION_4_MOSTRAR_CAMPEONES_RANGO_ATAQUE + "\n"
                + Constantes.OPCION_5_ACTUALIZAR_BURST + "\n"
                + Constantes.OPCION_6_ELIMINAR_CAMPEON + "\n"
                + Constantes.OPCION_7_GUARDAR_CAMPEONES_TXT + "\n"
                + Constantes.OPCION_8_CARGAR_CAMPEONES_TXT + "\n"
                + Constantes.OPCION_9_GUARDAR_CAMPEONES_BINARIO + "\n"
                + Constantes.OPCION_10_CARGAR_CAMEPONES_BINARIO + "\n"
                + Constantes.OPCION_11_MOSTRAR_CAMPEONES_POR_HABILIDADES + "\n"
                + Constantes.SALIR);
        return teclado.nextInt();
    }
}
