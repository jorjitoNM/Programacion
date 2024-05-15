package service;

public interface IGestionPersonal {
    String verComandas();
    String verCarta();
    boolean cambiarPrecio(int idPlato, int precio);
    boolean eliminarCarta();
}
