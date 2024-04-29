package dao;

import domain.Pedido;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Pedidos {
    private TreeSet<Pedido> pedidos;
    public Pedidos() {
        pedidos = new TreeSet<>(new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
    }
    public int nuevoPedido () {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido.getIdPedido();
    }
    public void añadirPlato (int idPlato, int cantidad, int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            if (it.next().getIdPedido() == idPedido) {
                pedido = it.next();
                pedido.añadirPlato(idPlato, cantidad);
                exit = true;
            }
        }
    }
    public int darIDPedido (int idUsuario) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            if (it.next().getIdPedido() == idPedido) {
                pedido = it.next();
                return pedido.getIdPedido();
                pedido.añadirPlato(idPlato, cantidad);
                exit = true;
            }
        }
    }
}
