public class Torre extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return (movimiento.isVertical()||movimiento.isHorizontal());
    }
    public Torre (boolean color) {
        super(color);
        if (!color) {
            nombre = "\\u2656";
        }
        else {
            nombre = "\\u265C";
        }
    }
}
