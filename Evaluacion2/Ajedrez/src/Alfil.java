public class Alfil extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.isDiagonal();
    }
}
