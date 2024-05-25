package service;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import dao.DaoClientes;
import dao.IDaoClientes;

import java.io.IOException;
import java.time.LocalDateTime;

public class GestionClientes implements IGestionClientes {
    private IDaoClientes daoClientes;

    public GestionClientes() throws IOException {
        daoClientes = new DaoClientes();
    }
    public GestionClientes(DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
    }

    @Override
    public String mostrarMenu() {
        return daoClientes.mostrarMenu();
    }
    @Override
    public String mostrarMenu(String tipo) {
        return daoClientes.mostrarMenu(tipo);
    }

    public String pedirCuenta(int idPedido, int idUsuario) throws PedidoNoEncontrado {
        return daoClientes.pedirCuenta(idPedido,idUsuario);
    }

    @Override
    public boolean añadirPlato(String nombre, int cantidad, int idPedido, int idCliente) {
        return daoClientes.añadirPlato(nombre, cantidad, idPedido, idCliente);
    }

    @Override
    public String mostrarCarrito(int idPedido) throws PedidoNoEncontrado {
        return daoClientes.verCarrito(idPedido);
    }

    @Override
    public boolean eliminarPlato(String nombrePlato, int idPedido) {
        return daoClientes.eliminarPlato(nombrePlato,idPedido);
    }

    @Override
    public boolean añadirCodigo() {
        return false;
    }

    @Override
    public boolean existePedido(int idPedido, int idCliente) throws PedidoNoEncontrado {
        return daoClientes.existePedido(idPedido,idCliente);
    }

    /*@Override
    public boolean nuevoPedido(int idUsuario) {
        return daoClientes.nuevoPedido(idUsuario);
    }*/
    @Override
    public int nuevoPedido(int idUsuario) {
        return daoClientes.nuevoPedido(idUsuario);
    }
    @Override
    public void iniciarPedido (int idPedido,int idCliente) {
        daoClientes.iniciarPedido(idPedido,idCliente);
    }

    @Override
    public void iniciarPedido(String codigo, int idPedido, int idCliente) {
        daoClientes.iniciarPedido(codigo,idPedido,idCliente);
    }

    @Override
    public String mostrarCupones(int idUsuario) {
        return null;
    }

    @Override
    public String añadirCupon(String cupon) {
        return null;
    }

    @Override
    public String verPedidos (int idUsuario) {
        return daoClientes.verPedidos(idUsuario);
    }
    @Override
    public void validarPedido (int idPedido) throws PedidoNoEncontrado {
        daoClientes.validarPedido(idPedido);
    }
    @Override
    public double tiempoEspera (int idPedido) throws PedidoNoEncontrado {
        return daoClientes.tiempoEspera(idPedido);
    }
    @Override
    public void validarCupon (String cupon, int idUsuario) throws CuponNoValidoException {
        daoClientes.validarCupon(cupon,idUsuario);
    }
    @Override
    public LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado {
        return daoClientes.horaEntrega(idPedido);
    }

    @Override
    public boolean pedidoIsEmpty(int idPedido) throws PedidoNoEncontrado {
        return daoClientes.pedidoIsEmpty(idPedido);
    }

    @Override
    public boolean cambiarContraseña(int idUsuario, String contraseña) throws IOException {
        return daoClientes.cambiarContraseña(idUsuario,contraseña);
    }

    @Override
    public boolean carritoVacio(int idPedido, int idCliente) throws PedidoNoEncontrado {
        return daoClientes.carritoVacion(idPedido, idCliente);
    }

    @Override
    public void guardarFicheros() throws IOException {
        daoClientes.guardarFicheros();
    }
}
