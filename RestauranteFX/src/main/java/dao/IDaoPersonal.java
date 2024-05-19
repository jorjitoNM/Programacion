package dao;

public interface IDaoPersonal {
    String verComandas();
    String verCarta();
    boolean cambiarPrecio (int idPlato, int precio);
    boolean eliminarCarta ();
}
