package dao;

import common.PedidoNoEncontrado;

public interface IDaoClientes {
    int nuevoPedido ();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    int darIDCliente (String nombreUsuario);
    void iniciarPedido();
    void iniciarPedido(String codigo);
    int darIDPedido (String nombreUsuario);
    String mostrarMenu ();
    boolean existePedido ();
    String verPedidos (String nombreUsuario);
    boolean eliminarPedido (String nombrePlato, int idPedido);
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
}
