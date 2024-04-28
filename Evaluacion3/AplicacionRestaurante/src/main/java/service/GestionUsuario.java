package service;

import dao.DaoPersonal;
import dao.IDaoPersonal;
import domain.Factura;

public class GestionUsuario implements IGestionUsuario{
    private IDaoPersonal daoPersonal;

    public GestionUsuario() {
       daoPersonal = new DaoPersonal();
    }

    @Override
    public String mostrarMenu() {
        return "";
    }

    @Override
    public Factura pedirCuenta() {
        return null;
    }

    @Override
    public void añadirPlato(String nombre, int cantidad) {
        daoPersonal.añadirPlato(nombre, cantidad);
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

    @Override
    public void nuevoPedido() {

    }
}
