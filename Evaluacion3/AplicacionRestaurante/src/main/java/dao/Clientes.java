package dao;

import domain.Cliente;

import java.util.HashSet;

public class Clientes {
    private HashSet clientes;

    public Clientes() {
    }

    public Clientes(HashSet clientes) {
        this.clientes = clientes;
    }
    public HashSet<Cliente> getClientes() {
        return clientes;
    }
}
