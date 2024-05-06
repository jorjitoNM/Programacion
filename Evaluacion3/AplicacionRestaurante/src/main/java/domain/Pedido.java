package domain;

import java.time.LocalDate;
import java.util.*;

public class Pedido {
    private LocalDate fecha;
    private HashMap<Integer, Integer> carrito; //idPlato, cantidad
    private int idPedido;
    private ArrayList<Integer> ids = new ArrayList<>();
    private boolean activo;
    private int idUsuario;
    private Promocion promocion;


    public Pedido() {
        fecha = LocalDate.now();
        carrito = new HashMap<>();
        idPedido = darID();
        activo = true;
    }
    public Pedido(Promocion promocion) {
        fecha = LocalDate.now();
        carrito = new HashMap<>();
        idPedido = darID();
        activo = true;
        this.promocion = promocion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?id:darID();
    }
    public void añadirPlato (int idPlato, int cantidad) {
        carrito.put(idPlato, cantidad);
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public boolean isActivo() {
        return activo;
    }
    public void eliminarPlato (int idPlato) {
        carrito.remove(idPlato);
    }

    public String getPlatosString() {
        StringBuilder sb = new StringBuilder();
        return carrito.forEach((k,v) -> sb.append(k.getPlato())); //quiero imprimir el nombre del plato
    }
    public HashMap<Integer, Integer> getPlatos() {
        return carrito;
    }

    public double tiempoEspera () {
        carrito.forEach((k,v) -> k.); //problema, es un id de plato (esto va en restaurante)
        return
    }
    @Override
    public String toString() {
        return "-Pedido " + idPedido +
                " , fecha: " + fecha +
                " , productos: " + carrito +
                ", activo=" + activo +
                " , cliente: " + idUsuario +
                " , promocion añadidas: " + promocion + "\n";
    }
}