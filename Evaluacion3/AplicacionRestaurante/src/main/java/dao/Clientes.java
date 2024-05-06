package dao;

import domain.Cliente;

import java.util.HashSet;

public class Clientes {
    private HashSet<Cliente> clientes;

    public Clientes() {
    }

    public Clientes(HashSet clientes) {
        this.clientes = clientes;
    }
    public HashSet<Cliente> getClientes() {
        return clientes;
    }
    public Cliente getCliente(int idCliente) {
        return clientes.stream().filter(c -> c.getId()==idCliente).findFirst().orElse(null);
    }
    public Cliente getCliente (String nombreUsuario) {
        return clientes.stream().filter(c -> c.getNombre().equals(nombreUsuario)).findFirst().orElse(null);
    }

}
