public class Torre extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return (movimiento.isVertical()||movimiento.isHorizontal());
    }
}
