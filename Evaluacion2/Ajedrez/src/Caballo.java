public class Caballo extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return ((movimiento.saltoHorizontal()==3)&&(movimiento.saltoVertical()==2))||((movimiento.saltoVertical()==3)&&(movimiento.saltoHorizontal()==2));
    }
}
