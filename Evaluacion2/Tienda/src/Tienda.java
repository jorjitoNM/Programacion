public class Tienda {


    private Articulo[] articulos = new Articulo[50];
    //implementar pasillos
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
        return i-1;
    }
}
