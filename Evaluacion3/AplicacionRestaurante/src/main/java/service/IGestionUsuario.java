package service;

import domain.Factura;

public interface IGestionUsuario {
    String mostrarMenu();
    Factura pedirCuenta();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    String mostrarCarrito ();
    boolean eliminarPlato ();
    boolean añadirCodigo ();
    boolean existePedido ();
    int nuevoPedido ();
    int darIDPedido (String nombreUsuario);
    void iniciarPedido();
    String mostrarCupones ();
    String añadirCupon(String cupon);
}
