package service;

import domain.Factura;

public interface IGestionUsuario {
    String mostrarMenu();
    Factura pedirCuenta();
    void añadirPlato (String nombre);
    String mostrarCarrito ();
    boolean eliminarPlato ();
    boolean añadirCodigo ();
    boolean existePedido ();
    void nuevoPedido ();
}
