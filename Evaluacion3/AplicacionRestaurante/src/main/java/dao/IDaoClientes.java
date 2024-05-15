package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public interface IDaoClientes {
    int nuevoPedido (int idUsuario);
    boolean añadirPlato (String nombre, int cantidad, int idPedido) throws FileNotFoundException;
    int darIDCliente (String nombreUsuario);
    void iniciarPedido(int idPedido);
    void iniciarPedido(String codigo, int idPedido);
    int darIDPedido (String nombreUsuario);
    String mostrarMenu ();
    String mostrarMenu (String tipo);
    boolean existePedido (int idPedido);
    String verPedidos (int idUsuario);
    boolean eliminarPlato (String nombrePlato, int idPedido);
    void validarPedido (int idPedido) throws PedidoNoEncontrado;
    double tiempoEspera (int idPedido) throws PedidoNoEncontrado;
    String verCarrito (int idPedido) throws PedidoNoEncontrado;
    void validarCupon (String cupon,int idUsuario) throws CuponNoValidoException;
    LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado;
}
