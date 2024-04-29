package dao;

public interface IDaoClientes {
    int nuevoPedido ();
    void añadirPlato (String nombre, int cantidad, int idPedido);
    int darIDCliente (String nombreUsuario);
}
