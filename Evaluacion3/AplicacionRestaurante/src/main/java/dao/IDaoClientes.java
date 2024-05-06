package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;

public interface IDaoClientes {
    int nuevoPedido ();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    int darIDCliente (String nombreUsuario);
    void iniciarPedido(int idPedido);
    void iniciarPedido(String codigo, int idPedido);
    int darIDPedido (String nombreUsuario);
    String mostrarMenu ();
    boolean existePedido ();
    String verPedidos (String nombreUsuario);
    boolean eliminarPedido (String nombrePlato, int idPedido);
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    double tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    String verCarrito (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,String nombreUsuario) throws CuponNoValidoException;
}
