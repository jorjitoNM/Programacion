public class Rey extends Pieza {
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isVertical()||movimiento.isDiagonal()||movimiento.isHorizontal();
    }
    public Rey (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2654";
        }
        else {
            nombre = "\u265A";
        }
    }
}
