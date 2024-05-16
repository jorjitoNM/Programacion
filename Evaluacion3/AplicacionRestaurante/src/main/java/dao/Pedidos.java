package dao;

import common.PedidoNoEncontrado;
import domain.Pedido;
import domain.Promocion;

import java.time.LocalDate;
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
    public boolean nuevoPedido (int idUsuario) {
        Pedido pedido = new Pedido(idUsuario);
        return pedidos.add(pedido);
    }
    public void añadirPlato (int idPlato, int cantidad, int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
                pedido.añadirPlato(idPlato, cantidad);
                exit = true;
            }
        }
    }
    public int darIDPedido (int idUsuario) {
        Iterator<Pedido> it = pedidos.iterator();
        int idPedido = -1;
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdUsuario() == idUsuario) {
                idPedido = pedido.getIdPedido();
                exit = true;
            }
        }
        return idPedido;
    }
    public void iniciarPedido (int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
                pedido.setActivo(true);
                exit = true;
            }
        }
    }
    public void iniciarPedido (String codigo, int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
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
    /*public double calcularPrecio (int idPedido) { //aqui hay que arreglar, porque el metodo calcularPrecio solo lo puedo hacer en Restaurante
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        double precio = 0;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
                precio = pedido.calcularPrecio();
                exit = true;
            }
        }
    }*/
}
