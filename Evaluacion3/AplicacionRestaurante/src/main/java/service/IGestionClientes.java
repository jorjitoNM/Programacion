package service;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Factura;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public interface IGestionClientes {
    String mostrarMenu();
    String mostrarMenu(String tipo);
    Factura pedirCuenta();
    boolean añadirPlato (String nombre, int cantidad, int idPedido) throws FileNotFoundException;
    String mostrarCarrito (int idPedido) throws PedidoNoEncontrado;
    boolean eliminarPlato (String nombrePlato, int idPedido);
    boolean añadirCodigo ();
    boolean existePedido (int idPedido);
    boolean nuevoPedido (int idUsuario);
    int darIDPedido (String nombreUsuario);
    void iniciarPedido(int idUsuario,int idPedido);
    void iniciarPedido(int idUsuario,String codigo, int idPedido);
    String mostrarCupones ();
    String añadirCupon(String cupon);
    String verPedidos(int idUsuario) ;
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    double tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,int idUsuario) throws CuponNoValidoException;
    LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado;
}
