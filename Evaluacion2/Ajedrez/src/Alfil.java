public class Alfil extends Pieza {

    public Alfil (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2657";
        }
        else {
            nombre = "\u265D";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isDiagonal();
    }
}
