public class Rey extends Pieza {
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isVertical()||movimiento.isDiagonal()||movimiento.isHorizontal();
    }
    public Rey (boolean color) {
        super(color);
    }
}
