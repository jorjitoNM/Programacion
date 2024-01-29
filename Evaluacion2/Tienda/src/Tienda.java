public class Tienda {


    private Articulo[] articulos = new Articulo[50];


    public String buscarPasillo (int id) {
        int hueco =buscarArticulo(id);
        return (hueco!=-1)?String.format("Su producto se encuentra en el pasillo %d",articulos[hueco].getPasillo()):String.format("Su producto no se encuentra disponible o ha introducido mal el id");
    }
    public boolean idUnico (int id) {
        boolean exit = false;
        for (int i = 0; i < articulos.length && !exit; i++) {
            if (articulos[i].getId()==articulos[i+1].getId()) {
                exit = true;
            }
        }
        return exit;
    }
    private int buscarArticulo (int id) {
        int i = 0;
        boolean exit = false;
        for (; i < articulos.length && !exit; i++) {
            if (id==articulos[i].getId()) {
                exit = true;
            }
        }
        return (exit)?i-1:-1;
    }
    public void nuevoArticulo (Articulo articulo) {
        boolean exit = false;
        for (int i = 0; i < articulos.length && !exit; i++) {
            if (articulos[i]!=null) {
                articulos[i] = articulo;
                exit = true;
            }
        }
    }
    public void eliminarArticulo (int id) {
        boolean exit = false;
        for (int i = 0; i < articulos.length && !exit; i++) {
            if (articulos[i].getId()==id) {
                articulos[i] = null;
                exit = true;
            }
        }
    }
}
