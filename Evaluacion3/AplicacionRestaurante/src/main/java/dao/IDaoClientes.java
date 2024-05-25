package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Factura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public interface IDaoClientes {
    //boolean nuevoPedido (int idUsuario);
    int nuevoPedido (int idUsuario);
    boolean añadirPlato (String nombre, int cantidad, int idPedido, int idCliente);
    int darIDCliente (String nombreUsuario);
    void iniciarPedido(int idPedido, int idCliente);
    void iniciarPedido(String codigo, int idPedido, int idCliente);
    String mostrarMenu ();
    String mostrarMenu (String tipo);
    boolean existePedido (int idPedido, int idCliente) throws PedidoNoEncontrado;
    String verPedidos (int idUsuario);
    boolean eliminarPlato (String nombrePlato, int idPedido);
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    double tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    String verCarrito (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,int idUsuario) throws CuponNoValidoException;
    LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado;
    boolean pedidoIsEmpty(int idPedido) throws PedidoNoEncontrado;
    String pedirCuenta(int idPedido,int idUsuario) throws PedidoNoEncontrado;
    boolean cambiarContraseña(int idUsuario, String contraseña) throws IOException;
    boolean carritoVacion(int idPedido, int idCliente) throws PedidoNoEncontrado;
    void guardarFicheros() throws IOException;
}
