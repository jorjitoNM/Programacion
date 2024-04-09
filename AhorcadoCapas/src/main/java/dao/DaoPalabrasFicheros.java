package dao;

import domain.Juego;
import domain.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoPalabrasFicheros {
    public static final String DICCIONARIO = "Diccionario";
    public static final String PARTIDA = "Partida";
   /* public static void crearFicheros() throws IOException {
        File fichero1 = new File(DICCIONARIO);
        File fichero2 = new File(FICHEROB);
        if (!fichero1.exists())
                fichero1.createNewFile();
        if (!fichero2.exists())
            fichero2.createNewFile();
    }*/
   public static void crearDiccionario() throws IOException {
       File fichero = new File(DICCIONARIO);
       if (!fichero.exists())
           fichero.createNewFile();
   }
    public static void crearFicheroPartida () throws IOException {
        File fichero = new File(PARTIDA);
        if (!fichero.exists())
            fichero.createNewFile();
    }
    public static List<Palabra> leerFichero() throws IOException {
        return leerFichero(DaoPalabrasFicheros.DICCIONARIO);
    }
    public static List<Palabra> leerFichero(String fichero) throws IOException {
        //crearFicheros();
        ArrayList<Palabra> auxiliar = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                //crear Palabra y añadirlo a auxiliar.
            };
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return auxiliar;
    }

    /**
     * Ejemplo de lectura de fichero binario. Pensad cómo utilizarlo para guardar y recuperar partida, guardando el objeto juego
     * en vez del ArrayList
     * @return
     */

    public static Juego retomarPartida () {
        Juego auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(PARTIDA))) {
            auxiliar = (Juego) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return auxiliar;
    }
    public static void guardarPartida (Juego partida) throws IOException {
        ObjectOutputStream is = new ObjectOutputStream(new FileOutputStream(PARTIDA));
        is.writeObject(partida);
    }

    public static boolean escribirFicheroBinario (List<Palabra> Palabras) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PARTIDA))) {
            os.writeObject(Palabras);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
    public static boolean escribirDiccionario (List<Palabra> diccionario) throws IOException,FileNotFoundException {
        crearDiccionario();
        PrintWriter pw = new PrintWriter(DICCIONARIO);
        for (int i = 0; i < diccionario.size(); i++) {
            pw.println(diccionario.get(i).toString());
        }
        pw.close();
        return true;
    }
    public static boolean escribirDiccionarioTest (String entrada) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(DICCIONARIO);
        pw.println(entrada);
        pw.close();
        return true;
    }
  }
