package org.example.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.common.Constantes;
import org.example.domain.Alpina;
import org.example.domain.Fondo;
import org.example.domain.Pista;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class DaoFicheros {
    public static void crearFicheroJSON () throws IOException {
        File file = new File(Constantes.PATH_JSON);
        if (!file.exists())
            file.createNewFile();
    }
    public static boolean guardarFicheroJSON (HashSet<Pista> pistas) throws IOException {
        crearFicheroJSON();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String json = gson.toJson(pistas);
        PrintWriter pw = null;
        pw = new PrintWriter(Constantes.PATH_JSON);
        pw.println(json);
        pw.close();
        return true;
    }
    public static void crearFicheroTXT () throws IOException {
        File file = new File(Constantes.PATH_TXT);
        if (!file.exists())
            file.createNewFile();
    }
    public static boolean existeTXT () {
        File file = new File(Constantes.PATH_TXT);
        return file.exists();
    }
    public static boolean escribirFicheroTXT (String pistas) throws IOException {
        crearFicheroTXT();
        PrintWriter pw = new PrintWriter(Constantes.PATH_TXT);
        pw.println(pistas);
        pw.close();
        return true;
    }
    public static HashSet<Pista> leerFicheroTXT () throws IOException {
        HashSet<Pista> pistas;
        if (existeTXT()) {
            Scanner teclado = new Scanner(Constantes.PATH_TXT);
            pistas = new HashSet<>();
            while(teclado.hasNext()) {
                String[] parsed = teclado.nextLine().split(Constantes.SEPARADOR_ATRIBUTOS);
                if (parsed[0].equalsIgnoreCase("fondo"))
                    pistas.add(new Fondo(Integer.parseInt(parsed[1]),parsed[2],parsed[3],Double.parseDouble(parsed[4]),parsearPoblaciones(parsed[5])));
                else
                    pistas.add(new Alpina(Integer.parseInt(parsed[1]),parsed[2],parsed[3],Double.parseDouble(parsed[4]),parsed[5]));
            }
        }
        else
            throw new IOException();
        return pistas;
    }

    private static String[] parsearPoblaciones(String s) {
        String[] formatted = s.split(Constantes.SEPARADOR_POBLACIONES);
        for (int i = 0; i < formatted.length; i++) {
            formatted[i] = formatted[i].substring(0,formatted.length-2);
        }
        return formatted;
    }


    public static void crearFicheroBinario () throws IOException {
        File file = new File(Constantes.PATH_BINARIO);
        if (!file.exists())
            file.createNewFile();
    }
    public static void guardarFicheroBinario (HashSet<Pista> pistas) throws IOException {
        crearFicheroBinario();
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_BINARIO));
        oos.writeObject(pistas);
        oos.close();
    }
    public static HashSet<Pista> leerFicheroBinario () throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_BINARIO));
        HashSet<Pista> pistas;
        try {
            pistas = (HashSet<Pista>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        };
        return pistas;
    }
}
