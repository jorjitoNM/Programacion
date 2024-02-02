public class Dama extends Pieza {
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isHorizontal()||movimiento.isDiagonal()||movimiento.isVertical();
    }
    public Dama (boolean color) {
        super(color);
        if (!color) {
            nombre = "\\u2655";
        }
        else {
            nombre = "\\u265B";
        }
    }
}
