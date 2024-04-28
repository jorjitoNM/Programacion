package dao;

import domain.Plato;

import java.util.*;

public class Pedido {
    private List<Plato> carrito;
    private Date fecha;
    private HashMap<Integer, Integer> productos; //idPedido, cantidad
    private int idPedido;
    private ArrayList<Integer> ids;


    public Pedido() {
        carrito = new ArrayList<Plato>();
        idPedido = darID();
    }

    public Date getFecha() {
        return fecha;
    }
    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?id:darID();
    }
    public void añadirPlato (int idPlato, int cantidad) {
        productos.put(idPlato, cantidad);
    }
}