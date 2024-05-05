package service;

import common.PedidoNoEncontrado;
import dao.DaoClientes;
import dao.IDaoClientes;
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
    public boolean eliminarPlato(String nombrePlato, int idPedido) {
        return daoClientes.eliminarPedido(nombrePlato,idPedido);
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

    @Override
    public void iniciarPedido(String cupon) {

    }

    @Override
    public String mostrarCupones() {
        return null;
    }

    @Override
    public String añadirCupon(String cupon) {
        return null;
    }

    @Override
    public String verPedidos (String nombreUsuario) {
        return daoClientes.verPedidos(nombreUsuario);
    }
    @Override
    public void validarPedido (int idPedido) throws PedidoNoEncontrado {
        daoClientes.validarPedido(idPedido);
    }
}
