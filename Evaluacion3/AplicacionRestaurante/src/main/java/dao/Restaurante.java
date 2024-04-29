package dao;

import domain.Pedido;
import domain.Plato;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Restaurante {

    private HashSet<Plato> carta;
    private Clientes clientes;
    private Pedidos pedidos;


    public Restaurante() {
        clientes = new Clientes();
        pedidos = new Pedidos();
        carta = crearCarta();
    }

    public boolean añadirPlato (String nombre, int cantidad, int idPedido) {
        int idPlato = carta.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(new Plato(0)).getId();
        if (idPlato!=0 && pedidos.last()!=null){ //aqui deberia pedir el id del pedido y guardarmelo en una variable despues de tener el correcto
            pedidos.añadirPlato(idPlato,cantidad);
            return true;
        }
        else
            return false;
    }

    public int nuevoPedido () {
        return pedidos.nuevoPedido();
    }
    private HashSet<Plato> crearCarta () {
        if (carta!=null) {
            carta = new HashSet<>();
            carta.add(new Plato());
        }
        return carta;
    }
    private int darIDPedido (String nombreUsuario) {
        int idUsuario = clientes.getClientes().stream().filter(c -> c).;
        return
    }
}