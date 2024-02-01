public class Peon extends Pieza {
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return movimiento.saltoVertical()==1;
    }
    public boolean validoComer (Movimiento movimiento) {
        return movimiento.saltoDiagonal()==1;
    }

}
