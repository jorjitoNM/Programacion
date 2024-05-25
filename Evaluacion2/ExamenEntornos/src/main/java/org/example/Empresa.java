package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Empresa {
    private ArrayList<Centro> centros;
    public static final String[] provincias = {"Madrid","Barcelona","Valencia","Malaga"};


    public Empresa () {
        centros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (Math.random()>0.5)
                 centros.add(new ParqueAtracciones());
            else
                centros.add(new Zoologico());
        }
    }
    public boolean addCentro (Centro centro) {
        return centros.add(centro);
    }
    public static String devuelveProvincia () {
        return provincias[(int)(Math.random()* provincias.length)];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        centros.forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }
    public String toString(String tipo) {
        StringBuilder sb = new StringBuilder();
        centros.stream().filter(c -> c.getClass().getSimpleName().equalsIgnoreCase(tipo)).forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }

    public String getCentrosPorAño(String provincia, int añoMinimo, int añoMaximo) {
        StringBuilder sb = new StringBuilder();
        centros.stream().filter(c -> c.getProvincia().equalsIgnoreCase(provincia)).filter(c -> c.getAnyoConstruccion() > añoMinimo && c.getAnyoConstruccion() < añoMaximo).forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }

    public boolean setEdadMinima(int id, int edadMinima) {
        ParqueAtracciones parque = (ParqueAtracciones) centros.stream().filter(c -> c.getId()==id).findFirst().orElse(null);
        if (parque != null) {
            parque.setEdadMinima(edadMinima);
            return parque.getEdadMinima() == edadMinima;
        } else return false;
    }

    public boolean setDelfinario(int id, boolean delfinario) {
        Zoologico zoo = (Zoologico) centros.stream().filter(c -> c.getId()==id).findFirst().orElse(null);
        if (zoo != null) {
            zoo.setDelfinario(delfinario);
            return zoo.isDelfinario() == delfinario;
        } else return false;
    }

    public boolean eliminarCentros(int año) {
        return centros.removeIf(c -> c.getAnyoConstruccion() < año);
    }

    public String precioMedioPorProvinciaYCentro(boolean laborable, int edad) {
        StringBuilder sb = new StringBuilder();
        Map<String, List<Centro>> map = centros.stream().collect(groupingBy(Centro::getProvincia));
        Set<String> provincias = map.keySet();
        for (String p:provincias) {
            sb.append(p).append(":\n");
            sb.append("Precio medio Parques de Atracciones: ").append(map.get(p).stream().filter(c -> c.getClass().getSimpleName().equalsIgnoreCase("ParqueAtracciones")).mapToDouble(c -> c.calcularPrecio(laborable,edad)).average()).append("€").append("\n"); //Se podria hacer con referencia a metodos, teniendo en cuenta que el metodo necesita parametros de entrada??
            sb.append("Precio medio Zoologicos: ").append(map.get(p).stream().filter(c -> c.getClass().getSimpleName().equalsIgnoreCase("Zoologico")).mapToDouble(c -> c.calcularPrecio(laborable,edad)).average()).append("€").append("\n");
        }
        return sb.toString();
    }

    public String centrosPorPrecioBase(String s) {
        StringBuilder sb = new StringBuilder();
        centros.stream().filter( c -> c.getProvincia().equalsIgnoreCase(s)).sorted((k,v) -> (int) k.getPrecioEntrada()).forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }
}
