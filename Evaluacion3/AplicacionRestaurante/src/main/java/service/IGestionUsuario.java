package service;

import common.PedidoNoEncontrado;
import domain.Factura;

public interface IGestionUsuario {
    String mostrarMenu();
    Factura pedirCuenta();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    String mostrarCarrito ();
    boolean eliminarPlato (String nombrePlato, int idPedido);
    boolean añadirCodigo ();
    boolean existePedido ();
    int nuevoPedido ();
    int darIDPedido (String nombreUsuario);
    void iniciarPedido();
    void iniciarPedido(String cupon);
    String mostrarCupones ();
    String añadirCupon(String cupon);
    String verPedidos(String nombreUsuario) ;
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
}
