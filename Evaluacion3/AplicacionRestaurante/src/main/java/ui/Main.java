package ui;

import common.Constantes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
        try {
            menu.menuInicial();
        } catch (IOException e) {
            System.out.println(Constantes.IO_EXCEPTION_ERROR);
        }
    }
}