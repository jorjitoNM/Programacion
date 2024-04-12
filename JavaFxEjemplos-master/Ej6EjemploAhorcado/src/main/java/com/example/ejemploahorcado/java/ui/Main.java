package com.example.ejemploahorcado.java.ui;


import com.example.ejemploahorcado.java.common.*;
import com.example.ejemploahorcado.java.service.GestionPalabras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestionPalabras servicio = new GestionPalabras();
        int opcion;
        boolean exit = false;
        do {
            System.out.println(Constantes.MENU);
            System.out.println(Constantes.ADMINISTRAR);
            System.out.println(Constantes.JUGAR);
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    MenuAdministrador administrador = new MenuAdministrador(servicio);
                    if (administrador.controlSeguridad())
                        administrador.opcionesMenu();
                    break;
                case 2:
                    MenuUsuario usuario = new MenuUsuario(servicio);
                    usuario.opcionesMenu();
                    break;
                case 3:
                    if (Utilities.comfirmarSalida())
                        exit = true;
                default:
                    System.out.println(Constantes.ERROROPCION);
            }
        }while(!exit);
    }
}