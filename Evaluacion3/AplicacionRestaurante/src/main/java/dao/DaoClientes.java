package dao;

public class DaoClientes implements IDaoClientes{
    private Restaurante restaurante;
    public DaoClientes () {
        restaurante = new Restaurante();
    }
    @Override
    public int nuevoPedido() {
        return restaurante.nuevoPedido();
    }
    @Override
    public void añadirPlato(String nombre, int cantidad, int idPedido) {
        restaurante.añadirPlato(nombre, cantidad, idPedido);
    }
    @Override
    public int darIDPedido (String nombreUsario) {
        restaurante.darIDPedido(nombreUsario);
    }
    @Override
    public void iniciarPedido() {
        restaurante.iniciarPedido();
    }
    @Override
    public void iniciarPedido(String codigo) {
        restaurante.iniciarPedido(codigo);
    }
    @Override
    public String mostrarMenu () {
        return restaurante.getCarta();
    }
    @Override
    public boolean existePedido() {
        return false;
    }
}
