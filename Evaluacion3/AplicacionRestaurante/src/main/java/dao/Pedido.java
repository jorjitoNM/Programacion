package dao;

import domain.Plato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    private List<Plato> carrito;
    private HashMap<Integer, Integer> productos; //idePedido, cantidad


    public Pedido() {
        carrito = new ArrayList<Plato>();
    }
}
