package ui;

import common.Constantes;
import common.ErrorEntradaException;
import service.GestionPalabras;
import service.IGestionPalabras;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionPalabras servicio;
    public MenuUsuario() {
        servicio = new GestionPalabras();
    }

    public int mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                System.out.println(Constantes.MENU+"\n"+Constantes.NUEVAPARTIDA+"\n"+Constantes.RETOMARPARTIDA);
                opcion = lector.nextInt();
                valido = true;
            } catch (InputMismatchException exception) {
                System.out.println(Constantes.ENTRADANONUMERO);
            }
        }while(!valido);
        return opcion;
    }
    public void opcionesMenu () {
        Scanner teclado = new Scanner(System.in);
        int opcion = mostrarMenu();
        int ID = -1;
        switch (opcion) {
            case 1:
                nuevaPartida(-1);
                break;
            case 2:
                System.out.println(Constantes.IDPALABRA);
                ID = teclado.nextInt();
                nuevaPartida(ID);
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
    public void nuevaPartida (int ID) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int dificultad;
        String respuesta;
        do {
            System.out.println(Constantes.MENURONDA + "\n" + Constantes.RONDANORMAL + "\n" + Constantes.RONDACATEGORIA + "\n" + Constantes.RONDADIFICULTAD + "\n" + Constantes.RONDAPERSONALIZADA);
            opcion = teclado.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        servicio.nuevaRonda(ID);
                        break;
                    case 2:
                        respuesta = teclado.nextLine();
                        servicio.nuevaRondaCategoria(ID,respuesta);
                        break;
                    case 3:
                        dificultad = teclado.nextInt();
                        servicio.nuevaRondaDificultad(ID,dificultad);
                        break;
                    case 4:
                        respuesta = teclado.nextLine();
                        servicio.nuevaRondaIncognita(ID,respuesta);
                        break;
                    case 5:
                        try {
                            servicio.guardarPartida();
                        } catch (FileNotFoundException exception) {

                        } catch (IOException e) {

                        }
                        break;
                    default:
                        System.out.println(Constantes.ERROROPCION);
                }
            } catch (ErrorEntradaException exception)  {
                System.out.println(Constantes.ERROROPCION + Constantes.NUEVOINTENTO);
            } catch (IOException exception) {

            }
        } while(opcion >= 1 && opcion <= 5);
    }
    public static String getIntento () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.NUEVOINTENTO);
        return teclado.nextLine();
    }
    /*public void nuevaRonda () throws ErrorEntradaException {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.NUEVARONDA);
        if (teclado.nextLine().equalsIgnoreCase("si")) { //esta mal aqui??
            System.out.println(Constantes.RONDA + ronda);
            nuevaRonda();
            ronda++;
        }
    }*/
}
