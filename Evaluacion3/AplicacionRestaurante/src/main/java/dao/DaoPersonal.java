package dao;

public class DaoPersonal implements IDaoPersonal{
    private Restaurante restaurante;

    public DaoPersonal() {
        this.restaurante = new Restaurante();
    }

    public String verComandas () {
        return restaurante.verComandas();
    }
}
