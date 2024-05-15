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

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class DaoFicheros {
    //Carta (.json)
    public static boolean existCarta () {
        File carta = new File(new Configuracion().loadPathProperties("pathJson"));
        return carta.exists();
    }
    public static void crearCartaJson () throws IOException {
        File carta = new File(new Configuracion().loadPathProperties("pathJson")); //aqui va la ruta que estara en el properties
        if (!carta.exists())
            carta.createNewFile();
    }
    public static boolean cartaIsEmpty () {
        File carta = new File(new Configuracion().loadPathProperties("pathJson"));
        return carta.length() == 0;
    }
    public static void guardarCarta (HashSet<Plato> carta) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String json = gson.toJson(carta);
        PrintWriter pw = new PrintWriter(new Configuracion().loadPathProperties("pathJson"));
        pw.println(json);
        pw.close();
    }
    public static HashSet<Plato> leerCarta () throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type userListType = new TypeToken<HashSet<Plato>>() {}.getType(); //como es una coleccion tengo que usar el TypeToken
        FileReader fr = new FileReader(new Configuracion().loadPathProperties("pathJson"));
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
    public static void guardarClientes (HashSet<Cliente> clientes) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new Configuracion().loadPathProperties("pathTXT"));
        clientes.forEach(c -> pw.println(c.toStringFichero()));
        pw.close();
    }
    public static HashSet<Cliente> leerClientes () throws FileNotFoundException {
        Scanner teclado = new Scanner(new File(new Configuracion().loadPathProperties("pathTXT")));
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
