public class Dama extends Pieza {

    /**
     * metodo que crea una Dama con el color adecuado
     * @param color
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
        return (!tablero.hayPiezasEntre(movimiento))&&(movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical());
    }
}
