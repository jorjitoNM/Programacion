/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Arrays;

/**
 *
 * @author examen
 */
public class CategoriaException extends Exception {
    public CategoriaException() {
        super(Constantes.CATEGORIAINVALIDA);
    }

    public CategoriaException(String message) {
        super(message);
    }
}