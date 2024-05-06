package service;

import dao.DaoPersonal;
import dao.IDaoPersonal;

public class GestionPersonal implements IGestionPersonal {
    private final IDaoPersonal daoPersonal;
    public GestionPersonal() {
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
}
