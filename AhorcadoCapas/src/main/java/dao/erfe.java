package dao;

import common.Categoria;
import common.CategoriaException;
import common.Constantes;
import common.Utilities;
import domain.Palabra;
import net.datafaker.Faker;

import javax.sound.midi.SoundbankResource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class erfe {
    public static void main(String[] args) throws IOException {
        /*boolean[] aciertos = new boolean[10];
        boolean uno = false;
        System.out.println(uno);
        System.out.println();
        for (int i = 0; i < aciertos.length; i++) {
            System.out.println(aciertos[i]);
        }         */
        ArrayList<Palabra> auxiliar = null;
        try (Scanner sc = new Scanner(new File(Constantes.DICCIONARIO))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                System.out.println(trozos.length);
                auxiliar.add(new Palabra(Integer.parseInt(trozos[0]),Integer.parseInt(trozos[1]),trozos[2],trozos[3]));
            };
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        } catch (CategoriaException e) {
            throw new RuntimeException(e);
        }
    }
}
