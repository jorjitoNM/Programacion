public class Dama extends Pieza {

    /**
     * metodo que crea una Dama inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Dama (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2655";
        }
        else {
            nombre = "\u265B";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return (tablero.hayPiezasEntre(movimiento))?false:(movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical());
    }
}
