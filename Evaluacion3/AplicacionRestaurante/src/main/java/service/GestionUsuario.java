package service;

import domain.Factura;

public class GestionUsuario implements IGestionUsuario{
    @Override
    public String mostrarMenu() {
        return "";
    }

    @Override
    public Factura pedirCuenta() {
        return null;
    }

    @Override
    public void añadirPlato(String nombre) {

    }

    @Override
    public String mostrarCarrito() {
        return "";
    }

    @Override
    public boolean eliminarPlato() {
        return false;
    }

    @Override
    public boolean añadirCodigo() {
        return false;
    }

    @Override
    public boolean existePedido() {
        return false;
    }
}
