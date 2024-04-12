package dao;

import common.CategoriaException;
import common.Constantes;
import domain.Juego;
import domain.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoPalabrasFicheros  {
   public static void crearDiccionario() throws IOException {
       File fichero = new File(Constantes.DICCIONARIO);
       if (!fichero.exists())
           fichero.createNewFile();
   }
    public static void crearFicheroPartida () throws IOException {
        File fichero = new File(Constantes.PARTIDA);
        if (!fichero.exists())
            fichero.createNewFile();
    }
    public static boolean escribirDiccionario (List<Palabra> diccionario) throws IOException,FileNotFoundException {
        PrintWriter pw = new PrintWriter(Constantes.DICCIONARIO);
        for (int i = 0; i < diccionario.size(); i++) {
            pw.println(diccionario.get(i).toStringFichero());
        }
        pw.close();
        return true;
    }
    public static List<Palabra> leerFichero(String diccionario) throws IOException {
        return leerFichero(Constantes.DICCIONARIO);
    }
    public static List<Palabra> leerDiccionario(String fichero) throws IOException {
        ArrayList<Palabra> auxiliar = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                auxiliar.add(new Palabra(Integer.parseInt(trozos[0]),Integer.parseInt(trozos[1]),trozos[2],trozos[3]));
            };
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        } catch (CategoriaException e) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
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
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(Constantes.PARTIDA))) {
            auxiliar = (Juego) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return auxiliar;
    }
    public static void guardarPartida (Juego partida) throws IOException {
        ObjectOutputStream is = new ObjectOutputStream(new FileOutputStream(Constantes.PARTIDA));
        is.writeObject(partida);
    }

    public static boolean escribirFicheroBinario (List<Palabra> Palabras) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(Constantes.PARTIDA))) {
            os.writeObject(Palabras);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
    public static boolean escribirDiccionarioTest (String entrada) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(Constantes.DICCIONARIO);
        pw.println(entrada);
        pw.close();
        return true;
    }
  }
