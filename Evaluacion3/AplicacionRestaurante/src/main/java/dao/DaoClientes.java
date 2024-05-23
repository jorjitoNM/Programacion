package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Factura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class DaoClientes implements IDaoClientes{
    private Restaurante restaurante;
    public DaoClientes () throws IOException {
        restaurante = new Restaurante();
    }
    public DaoClientes (Restaurante restaurante) throws IOException {
        this.restaurante = restaurante;
    }
    /*@Override
    public boolean nuevoPedido(int idUsuario) {
        return restaurante.nuevoPedido(idUsuario);
    }*/
    @Override
    public int nuevoPedido(int idUsuario) {
        return restaurante.nuevoPedido(idUsuario);
    }
    @Override
    public boolean añadirPlato(String nombre, int cantidad, int idPedido) throws FileNotFoundException {
        return restaurante.añadirPlato(nombre, cantidad, idPedido);
    }

    @Override
    public int darIDCliente(String nombreUsuario) {
        return 0;
    }

    @Override
    public int darIDPedido (String nombreUsario) {
        return restaurante.darIDPedido(nombreUsario);
    }
    @Override
    public void iniciarPedido(int idPedido) {
        restaurante.iniciarPedido(idPedido);
    }

    @Override
    public void iniciarPedido(String codigo, int idPedido) {
        restaurante.iniciarPedido(codigo,idPedido);
    }

    @Override
    public String mostrarMenu () {
        return restaurante.getCarta();
    }
    @Override
    public String mostrarMenu (String tipo) {
        return restaurante.getCarta(tipo);
    }
    @Override
    public boolean existePedido(int idPedido) {
        return restaurante.existePedido(idPedido);
    }
    @Override
    public String verPedidos (int idUsuario) {
        return restaurante.verPedidos(idUsuario);
    }

    @Override
    public boolean eliminarPlato(String nombrePlato, int idPedido) {
        return restaurante.eliminarPlato(nombrePlato,idPedido);
    }
    @Override
    public void validarPedido (int idPedido) throws PedidoNoEncontrado {
        restaurante.validarPedido(idPedido);
    }
    @Override
    public double tiempoEspera (int idPedido) throws PedidoNoEncontrado {
        return restaurante.tiempoEspera(idPedido);
    }
    @Override
    public String verCarrito (int idPedido) throws PedidoNoEncontrado {
        return restaurante.verCarrito(idPedido);
    }

    @Override
    public void validarCupon(String cupon,int idusuario) throws CuponNoValidoException {
        restaurante.validarCupon(cupon,idusuario);
    }
    @Override
    public LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado {
        return restaurante.horaEntrega(idPedido);
    }

    @Override
    public boolean pedidoIsEmpty(int idPedido) throws PedidoNoEncontrado {
        return restaurante.pedidoIsEmpty(idPedido);
    }

    @Override
    public String pedirCuenta(int idPedido,int idUsuario) throws PedidoNoEncontrado {
        return restaurante.crearFactura(idPedido,idUsuario);
    }
}
