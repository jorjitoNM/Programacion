package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;

public class DaoClientes implements IDaoClientes{
    private Restaurante restaurante;
    public DaoClientes () {
        restaurante = new Restaurante();
    }
    @Override
    public int nuevoPedido() {
        return restaurante.nuevoPedido();
    }
    @Override
    public void añadirPlato(String nombre, int cantidad, int idPedido) {
        restaurante.añadirPlato(nombre, cantidad, idPedido);
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
    public boolean existePedido() {
        return false;
    }
    @Override
    public String verPedidos (String nombreUsuario) {
        return restaurante.verPedidos(nombreUsuario);
    }

    @Override
    public boolean eliminarPedido(String nombrePlato, int idPedido) {
        return restaurante.eliminarPedido(nombrePlato,idPedido);
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
        return restaurante.verCarrito();
    }

    @Override
    public void validarCupon(String cupon,String nombreUsuario) throws CuponNoValidoException {
        restaurante.validarCupon(cupon,nombreUsuario);
    }
}
