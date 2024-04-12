package com.example.ejemploahorcado.java.common;

import java.util.Arrays;

public class Comprobacion {

    private static final String password = "1234";
    public static void categoriaOk(String categoria) throws CategoriaException {
        boolean exit = true;
        String formatear = Arrays.toString(Categoria.values());
        formatear = formatear.substring(1,formatear.length()-1);
        String[] categorias =  formatear.split(", ");
        for (int i = 0; i < categorias.length; i++) {
            if (categorias[i].equalsIgnoreCase(categoria))
                exit = false;
        }
        if (exit)
            throw new CategoriaException();
    }
    public static boolean controlSeguridad (String password) {
        if (password.equals(Comprobacion.password)) // no se podria referir directamente?
            return true;
        else
            return false;
    }
}



