package service;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import dao.DaoClientes;
import dao.IDaoClientes;
import domain.Factura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class GestionClientes implements IGestionClientes {
    private IDaoClientes daoClientes;

    public GestionClientes() throws IOException {
        daoClientes = new DaoClientes();
    }
    public GestionClientes(DaoClientes daoClientes) throws IOException {
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

    @Override
    public Factura pedirCuenta() {
        return null;
    }

    @Override
    public boolean añadirPlato(String nombre, int cantidad, int idPedido) throws FileNotFoundException {
        return daoClientes.añadirPlato(nombre, cantidad, idPedido);
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
    public boolean existePedido(int idPedido) {
        return daoClientes.existePedido(idPedido);
    }
    @Override
    public int darIDPedido (String nombreUsuario) {
        return daoClientes.darIDPedido(nombreUsuario);
    } //no tiene usos

    @Override
    public int nuevoPedido(int idUsuario) {
        return daoClientes.nuevoPedido(idUsuario);
    }
    @Override
    public void iniciarPedido (int idUsuario,int idPedido) {
        daoClientes.iniciarPedido(idPedido);
    }

    @Override
    public void iniciarPedido(int idUsuario,String codigo, int idPedido) {
        daoClientes.iniciarPedido(codigo,idPedido);
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
}
