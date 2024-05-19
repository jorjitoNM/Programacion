package service;

import dao.DaoPersonal;
import dao.IDaoPersonal;

import java.io.IOException;

public class GestionPersonal implements IGestionPersonal {
    private final IDaoPersonal daoPersonal;
    public GestionPersonal() throws IOException {
        daoPersonal = new DaoPersonal();
    }
    public GestionPersonal(IDaoPersonal iDaoPersonal) {
        this.daoPersonal = iDaoPersonal;
    }
    public String verComandas() {
        return daoPersonal.verComandas();
    }
    public String verCarta () {
        return daoPersonal.verCarta();
    }
    public boolean cambiarPrecio (int idPlato, int precio) {
        return daoPersonal.cambiarPrecio(idPlato,precio);
    }
    public boolean eliminarCarta () {
        return daoPersonal.eliminarCarta();
    }
}
