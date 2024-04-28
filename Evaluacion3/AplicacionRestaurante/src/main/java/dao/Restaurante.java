package dao;

import common.Comparators;
import domain.Plato;

import java.util.HashSet;
import java.util.TreeSet;

public class Restaurante {
    private TreeSet<Pedido> pedidos;
    private HashSet<Plato> carta;

    public Restaurante() {
        pedidos = new TreeSet<>(new Comparators.porFecha());
        carta = crearCarta();
    }

    public boolean añadirPlato (String nombre, int cantidad) {
        int idPlato = carta.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(new Plato(0)).getId();
        if (idPlato!=0 && pedidos.last()!=null){ //aqui deberia pedir el id del pedido y guardarmelo en una variable despues de tener el correcto
            pedidos.last().añadirPlato(idPlato,cantidad);
            return true;
        }
        else
            return false;
    }

    private HashSet<Plato> crearCarta () {
        if (carta!=null) {
            carta = new HashSet<>();
            carta.add(new Plato());
        }
        return carta;
    }
}