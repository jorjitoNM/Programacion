package Ajedrez;

public class Dama extends Pieza {

    /**
     * metodo que crea una Dama inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Dama (boolean color) {
        super(color);
        if (!color) {
            nombre = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReinaNegra.png";
        }
        else {
            nombre = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReinaBlanca.png";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return (tablero.hayPiezasEntre(movimiento))?false:(movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical());
    }
}
