package dao;

import common.Configuracion;
import common.Constantes;
import domain.Asesino;
import domain.Campeon;
import domain.Mago;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class DaoFicheros {
    public static boolean existeFicheroTXT () {
        File fichero = new File(new Configuracion().loadPathProperties(Constantes.FICHERO_TXT));
        return fichero.exists();
    }
    public static boolean crearFicheroTXT () throws IOException {
        File fichero = new File(new Configuracion().loadPathProperties(Constantes.FICHERO_TXT));
        if (!fichero.exists())
            return fichero.createNewFile();
        else
            return true;
    }
    public static void guardarFicheroTXT (String campeones) throws FileNotFoundException {
        PrintWriter fichero = new PrintWriter(new Configuracion().loadPathProperties(Constantes.FICHERO_TXT));
        fichero.println(campeones);
        fichero.close();
    }
    public static HashSet<Campeon> leerFicheroTXT () {
        Scanner teclado = new Scanner(new Configuracion().loadPathProperties(Constantes.FICHERO_TXT));
        HashSet<Campeon> campeones = new HashSet<>();
        while (teclado.hasNextLine()) {
            String campeon = teclado.nextLine();
            String[] split = campeon.split(Constantes.SEPARADOR_ATRIBUTOS_CAMPEON);
             if (split[split.length-1].equalsIgnoreCase(Constantes.MAGO))
                campeones.add(new Mago(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5]),Boolean.getBoolean(split[6])));
             else
                 campeones.add(new Asesino(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5]),Double.parseDouble(split[6])));
        }
        return campeones;
    }
    public static boolean existeFicheroBinario () {
        File fichero = new File(new Configuracion().loadPathProperties(Constantes.FICHERO_BINARIO));
        return fichero.exists();
    }
    public static boolean crearFicheroBinario () throws IOException {
        File fichero = new File(new Configuracion().loadPathProperties(Constantes.FICHERO_BINARIO));
        if (!fichero.exists())
            return fichero.createNewFile();
        else
            return true;
    }
    public static void guardarFicheroBinario (HashSet<Campeon> campeones) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new Configuracion().loadPathProperties(Constantes.FICHERO_BINARIO)));
            oos.writeObject(campeones);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static HashSet<Campeon> leerFicheroBinario () {
        HashSet<Campeon> auxiliar = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new Configuracion().loadPathProperties(Constantes.FICHERO_BINARIO)));
            try {
                auxiliar = (HashSet<Campeon>) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return auxiliar;
    }
}
