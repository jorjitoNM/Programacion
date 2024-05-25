package service;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Factura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public interface IGestionClientes {
    String mostrarMenu();
    String mostrarMenu(String tipo);
    String pedirCuenta(int idPedido,int idUsuario) throws PedidoNoEncontrado;
    boolean añadirPlato (String nombre, int cantidad, int idPedido, int idCliente);
    String mostrarCarrito (int idPedido) throws PedidoNoEncontrado;
    boolean eliminarPlato (String nombrePlato, int idPedido);
    boolean añadirCodigo ();
    boolean existePedido (int idPedido, int idCliente) throws PedidoNoEncontrado;
    //boolean nuevoPedido (int idUsuario);
    int nuevoPedido (int idUsuario);
    void iniciarPedido(int idPedido, int idCliente);
    void iniciarPedido(String codigo, int idPedido, int idUsuario);
    String mostrarCupones (int idUsuario);
    String añadirCupon(String cupon);
    String verPedidos(int idUsuario) ;
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    double tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,int idUsuario) throws CuponNoValidoException;
    LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado;
    boolean pedidoIsEmpty(int idPedido) throws PedidoNoEncontrado;
    boolean cambiarContraseña(int idUsuario, String contraseña) throws IOException;
    boolean carritoVacio(int idPedido, int idCliente) throws PedidoNoEncontrado;
    void guardarFicheros() throws IOException;
}
