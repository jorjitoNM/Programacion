package com.example.ejemploahorcado.java.ui;

import com.example.ejemploahorcado.java.common.*;
import com.example.ejemploahorcado.java.service.GestionPalabras;
import com.example.ejemploahorcado.java.service.IGestionPalabras;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final IGestionPalabras servicio;
    public MenuUsuario(GestionPalabras servicio) {
        this.servicio = servicio;
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
        switch (opcion) {
            case 1:
                nuevaPartida();
                break;
            case 2:
                retomarPartida();
                break;
            default:
                System.out.println(Constantes.ERROROPCION);
        }
    }
    public void nuevaPartida () {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int dificultad;
        String respuesta;
        boolean exit = false;
        do {
            System.out.println(Constantes.MENURONDA + "\n" + Constantes.RONDANORMAL + "\n" + Constantes.RONDACATEGORIA + "\n" + Constantes.RONDADIFICULTAD + "\n" + Constantes.RONDAPERSONALIZADA);
            opcion = teclado.nextInt(); //no puedo eliminar el enter
            exit = false;
            try {
                switch (opcion) {
                    case 1:
                        servicio.nuevaRonda();
                        break;
                    case 2:
                        rondaCategoria();
                        break;
                    case 3:
                        dificultad = teclado.nextInt();
                        servicio.nuevaRondaDificultad(dificultad);
                        break;
                    case 4:
                        System.out.println(Constantes.CAMBIARINCOGNITA);
                        respuesta = teclado.nextLine();
                        servicio.nuevaRondaIncognita(respuesta);
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
            } catch (IOException exception) {
                System.out.println(Constantes.IOEXCEPTION);
            }
        } while(opcion >= 1 && opcion <= 5);
    }
    public void retomarPartida () {
        Scanner teclado = new Scanner(System.in);
        System.out.println(Constantes.IDPALABRA);
        int ID = teclado.nextInt();
        try {
            servicio.retomarPartida(ID);
        } catch (IOException e) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
        }
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
    private void rondaCategoria () {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        boolean exit = false;
        do {
            System.out.println(Constantes.INTRODUCIRCATEGORIA);
            respuesta = teclado.nextLine();
            try {
                Comprobacion.categoriaOk(respuesta);
                servicio.nuevaRondaCategoria(respuesta);
                exit = true;
            } catch (CategoriaException exception) {
                System.out.println(Constantes.CATEGORIAINVALIDA);
            } catch (IOException exception) {
                throw new RuntimeException(Constantes.IOEXCEPTION);
            }
        }while(!exit);
    }
}
