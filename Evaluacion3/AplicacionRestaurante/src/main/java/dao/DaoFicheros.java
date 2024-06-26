package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import common.Configuracion;
import common.Constantes;
import domain.Cliente;
import domain.Factura;
import domain.Plato;
import domain.Promocion;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

@Log4j2
public class DaoFicheros {
    //Carta (.json)
    public static boolean existCarta () {
        File carta = new File(new Configuracion().loadPathProperties("pathJson"));
        return carta.exists();
    }
    public static void crearCartaJson () throws IOException {
        File carta = new File(new Configuracion().loadPathProperties("pathJson"));
        if (!carta.exists())
            carta.createNewFile();
    }
    public static boolean cartaIsEmpty () {
        File carta = new File(new Configuracion().loadPathProperties("pathJson"));
        return carta.length() == 0;
    }
    public static void guardarCarta (HashSet<Plato> carta) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String json = gson.toJson(carta);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new Configuracion().loadPathProperties("pathJson"));
            pw.println(json);
            pw.close();
        } catch (FileNotFoundException e) {
            log.fatal(Constantes.LOG_FILE_NOT_FOUND);
        }
    }
    public static HashSet<Plato> leerCarta () {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type userListType = new TypeToken<HashSet<Plato>>() {}.getType();
        FileReader fr = null;
        try {
            fr = new FileReader(new Configuracion().loadPathProperties("pathJson"));
        } catch (FileNotFoundException e) {
            log.fatal(Constantes.LOG_FILE_NOT_FOUND);
        }
        return gson.fromJson(fr, userListType);
    }
    public static boolean eliminarCarta () {
        File file = new File(new Configuracion().loadPathProperties("pathJson"));
        return file.delete();
    }


    //Clientes (.txt)
    public static boolean existClientes () {
        File clientes = new File(new Configuracion().loadPathProperties("pathTXT"));
        return clientes.exists();
    }
    public static void crearFicheroClientes () throws IOException {
        File clientes = new File(new Configuracion().loadPathProperties("pathTXT")); //aqui va la ruta que estara en el properties
        if (!clientes.exists())
            clientes.createNewFile();
    }
    public static boolean clientesIsEmpty () {
        File clientes = new File(new Configuracion().loadPathProperties("pathTXT"));
        return clientes.length() == 0;
    }
    public static void guardarClientes (HashSet<Cliente> clientes) throws IOException {
        PrintWriter pw = null;
        crearFicheroClientes();
        try {
            pw = new PrintWriter(new Configuracion().loadPathProperties("pathTXT"));
            PrintWriter finalPw = pw;
            clientes.forEach(c -> finalPw.println(c.toStringFichero()));
            pw.close();
        } catch (FileNotFoundException e) {
            log.fatal(Constantes.LOG_FILE_NOT_FOUND);
        }
    }
    public static HashSet<Cliente> leerClientes () {
        Scanner teclado = null;
        try {
            teclado = new Scanner(new File(new Configuracion().loadPathProperties("pathTXT")));
        } catch (FileNotFoundException e) {
            log.fatal(Constantes.LOG_FILE_NOT_FOUND);
        }
        HashSet<Cliente> clientes = new HashSet<>();
        String[] cliente;
        while (teclado.hasNext()) {
            cliente = teclado.nextLine().split(Constantes.SEPARADOR_FICHEROSTXT);
            clientes.add(new Cliente(paresearFacturas(cliente[0]),paresearPromociones(cliente[1]),cliente[2],Integer.parseInt(cliente[3]),LocalDate.parse(cliente[4]),cliente[5],cliente[6])); //como creo este treeSet
        }
        return clientes;
    }
    public static TreeSet<Factura> paresearFacturas (String facturas) {
        TreeSet<Factura> facturasSet = new TreeSet<>();
        facturas = facturas.substring(1, facturas.length() - 1);
        if (!facturas.isEmpty()) {
            String[] facturasSplit = facturas.split(Constantes.SEPARADOR_COLECCIONES);
            for (int i = 0; i < facturasSplit.length; i++) {
                String[] cadaFacturaSplit = facturasSplit[i].split(Constantes.SEPARADOR_ELEMENTOS_FACTURA);
                Factura factura = new Factura(Integer.parseInt(cadaFacturaSplit[0]),Integer.parseInt(cadaFacturaSplit[1]),LocalDate.parse(cadaFacturaSplit[2]),cadaFacturaSplit[3]);
                facturasSet.add(factura);
            }
        }
        return facturasSet;
    }
    public static List<Promocion> paresearPromociones (String promociones) {
        List<Promocion> promocionesList = new ArrayList<>();
        promociones = promociones.substring(1, promociones.length() - 1);
        String[] facturasSplit = promociones.split(Constantes.SEPARADOR_COLECCIONES);
        for (int i = 0; i < facturasSplit.length; i++) {
            Promocion promocion = new Promocion(facturasSplit[i]);
            promocionesList.add(promocion);
        }
        return promocionesList;
    }

}
