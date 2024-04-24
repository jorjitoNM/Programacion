package dao;

import domain.Plato;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Plato> carrito;

    public Pedido() {
        carrito = new ArrayList<Plato>();
    }
}
