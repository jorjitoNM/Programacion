public class Reina extends Pieza {
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical();
    }
}
