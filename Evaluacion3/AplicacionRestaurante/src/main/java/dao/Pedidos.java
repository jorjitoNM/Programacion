package dao;

import common.PedidoNoEncontrado;
import domain.Pedido;
import domain.Promocion;

import java.util.*;

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
        int idPedido = -1;
        boolean exit = false;
        while (it.hasNext() && !exit) {
            if (it.next().getIdUsuario() == idUsuario) {
                idPedido = it.next().getIdPedido();
                exit = true;
            }
        }
        return idPedido;
    }
    public int iniciarPedido () {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        while (it.hasNext() && !exit) {
            if (it.next().getIdPedido() == idPedido) {
                it.next().setActivo(true);
                exit = true;
            }
        }
    }
    public int iniciarPedido (String codigo) { //arreglar el metodo iniciarPedido
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            if (it.next().getIdPedido() == idPedido) {
                pedido = it.next();
                pedido.setActivo(true);
                pedido.setPromocion(new Promocion(codigo));
                exit = true;
            }
        }
    }
    public String verPedidos (int idUsuario) {
        StringBuilder sb = new StringBuilder();
        pedidos.stream().filter(p -> p.getIdUsuario()==idUsuario).filter(Pedido::isActivo).forEach(sb::append);
        return sb.toString();
    }

    public TreeSet<Pedido> getPedidos() {
        return pedidos;
    }
    public void validarPedido (int idPedido) throws PedidoNoEncontrado {
        if (pedidos.stream().filter(p -> p.getIdPedido() == idPedido).findFirst().orElse(null) == null) {
            throw new PedidoNoEncontrado();
        }
    }
    public Pedido getPedido (int idPedido) throws PedidoNoEncontrado {
        Pedido pedido = pedidos.stream().filter(p -> p.getIdPedido() == idPedido).findFirst().orElse(null);
        if (pedido == null)
            throw new PedidoNoEncontrado();
        return pedido;
    }
}
