package dao;

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
    public void iniciarPedido() {
        restaurante.iniciarPedido();
    }
    @Override
    public void iniciarPedido(String codigo) {
        restaurante.iniciarPedido(codigo);
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
}
