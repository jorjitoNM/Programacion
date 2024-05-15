package dao;

import java.io.IOException;

public class DaoPersonal implements IDaoPersonal{
    private Restaurante restaurante;

    public DaoPersonal() throws IOException {
        this.restaurante = new Restaurante();
    }

    public String verComandas () {
        return restaurante.verComandas();
    }
    public String verCarta () {
        return restaurante.verCartaAdmin();
    }
    public boolean cambiarPrecio (int idPlato, int precio) {
        return restaurante.cambiarPrecio(idPlato,precio);
    }
    public boolean eliminarCarta () {
        return restaurante.eliminarCarta();
    }
}
