public class Rey extends Pieza {

    /**
     * Metodo que crea un Rey con el color adecuado
     * @param color
     */
    public Rey (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2654";
        }
        else {
            nombre = "\u265A";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return movimiento.isVertical()||movimiento.isDiagonal()||movimiento.isHorizontal();
    }
}
