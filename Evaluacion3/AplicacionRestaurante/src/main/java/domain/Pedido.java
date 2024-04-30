package domain;

import java.time.LocalDate;
import java.util.*;

public class Pedido {
    //private List<Plato> carrito;
    private LocalDate fecha;
    private HashMap<Integer, Integer> carrito; //idPlato, cantidad
    private int idPedido;
    private ArrayList<Integer> ids = new ArrayList<>();
    private boolean activo;
    private int idUsuario;
    private Promocion promocion;


    public Pedido() {
        carrito = new HashMap<>();
        idPedido = darID();
        activo = true;
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
}