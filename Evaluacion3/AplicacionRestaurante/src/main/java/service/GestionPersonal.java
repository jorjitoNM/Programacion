package service;

import dao.DaoPersonal;
import dao.IDaoPersonal;

public class GestionPersonal implements IGestionPersonal {
    private final IDaoPersonal iDaoPersonal;
    public GestionPersonal() {
        iDaoPersonal = new DaoPersonal();
    }
    public GestionPersonal(IDaoPersonal iDaoPersonal) {
        this.iDaoPersonal = iDaoPersonal;
    }
    public String verComandas() {
        return iDaoPersonal.verComandas();
    }
}
