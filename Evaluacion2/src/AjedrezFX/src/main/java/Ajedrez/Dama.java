package Ajedrez;

public class Dama extends Pieza {

    /**
     * metodo que crea una Dama inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Dama (boolean color) {
        super(color);
        if (!color) {
            ruta = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReinaNegra.png";
            nombre = "\u265B";
        }
        else {
            ruta = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReinaBlanca.png";
            nombre = "\u2655";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return (tablero.hayPiezasEntre(movimiento))?false:(movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical());
    }
}
