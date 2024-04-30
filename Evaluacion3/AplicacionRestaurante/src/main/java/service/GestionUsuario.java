package service;

import dao.DaoClientes;
import dao.DaoPersonal;
import dao.IDaoClientes;
import dao.IDaoPersonal;
import domain.Factura;

public class GestionUsuario implements IGestionUsuario{
    private IDaoClientes daoClientes;

    public GestionUsuario() {
        daoClientes = new DaoClientes();
    }

    @Override
    public String mostrarMenu() {
        return daoClientes.mostrarMenu();
    }

    @Override
    public Factura pedirCuenta() {
        return null;
    }

    @Override
    public void añadirPlato(String nombre, int cantidad, int idPedido) {
        daoClientes.añadirPlato(nombre, cantidad, idPedido);
    }

    @Override
    public String mostrarCarrito() {
        return "";
    }

    @Override
    public boolean eliminarPlato() {
        return false;
    }

    @Override
    public boolean añadirCodigo() {
        return false;
    }

    @Override
    public boolean existePedido() {
        return false;
    }
    @Override
    public int darIDPedido (String nombreUsuario) {
        return daoClientes.darIDPedido(nombreUsuario);
    }

    @Override
    public int nuevoPedido() {
        return daoClientes.nuevoPedido();
    }
    @Override
    public void iniciarPedido () {
        daoClientes.iniciarPedido();
    }
}
