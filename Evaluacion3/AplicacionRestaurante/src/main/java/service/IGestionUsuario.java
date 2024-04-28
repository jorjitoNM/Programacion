package service;

import domain.Factura;

public interface IGestionUsuario {
    String mostrarMenu();
    Factura pedirCuenta();
    void añadirPlato (String nombre, int cantidad);
    String mostrarCarrito ();
    boolean eliminarPlato ();
    boolean añadirCodigo ();
    boolean existePedido ();
    void nuevoPedido ();
}
