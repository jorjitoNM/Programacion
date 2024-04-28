package dao;

public class DaoPersonal implements IDaoPersonal{
    private Restaurante restaurante;

    public DaoPersonal() {
        this.restaurante = new Restaurante();
    }

    @Override
    public void añadirPlato(String nombre, int cantidad) {
        restaurante.añadirPlato(nombre, cantidad);
    }
}
