package domain;

import java.time.LocalDateTime;
import java.util.*;

public class Pedido {
    private LocalDateTime fecha;
    private HashMap<Integer, Integer> carrito; //idPlato, cantidad
    private int idPedido;
    private static final ArrayList<Integer> ids = new ArrayList<>();
    private boolean activo;
    private int idUsuario;
    private Promocion promocion;


    public Pedido(int idUsuario) {
        fecha = LocalDateTime.now();
        carrito = new HashMap<>();
        idPedido = darID();
        ids.add(idPedido);
        activo = true;
        this.idUsuario = idUsuario;
    }
    public Pedido(Promocion promocion, int idUsuario) {
        fecha = LocalDateTime.now();
        carrito = new HashMap<>();
        idPedido = darID();
        ids.add(idPedido);
        activo = true;
        this.promocion = promocion;
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }
    public LocalDateTime horaEntrega (double tiempoEspera) {
        return fecha.plusSeconds((long)tiempoEspera);
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
    public HashMap<Integer, Integer> getPlatos() {
        return carrito;
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