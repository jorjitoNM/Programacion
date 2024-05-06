package service;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Factura;

public interface IGestionUsuario {
    String mostrarMenu();
    Factura pedirCuenta();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    String mostrarCarrito (int idPedido) throws PedidoNoEncontrado;
    boolean eliminarPlato (String nombrePlato, int idPedido);
    boolean añadirCodigo ();
    boolean existePedido ();
    int nuevoPedido ();
    int darIDPedido (String nombreUsuario);
    void iniciarPedido();
    void iniciarPedido(String codigo);
    String mostrarCupones ();
    String añadirCupon(String cupon);
    String verPedidos(String nombreUsuario) ;
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    String tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,String nombreUsuario) throws CuponNoValidoException;
}
