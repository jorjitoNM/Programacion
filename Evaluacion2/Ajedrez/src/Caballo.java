public class Caballo extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        return ((Math.abs(movimiento.saltoHorizontal())==2)&&(Math.abs(movimiento.saltoVertical())==1))||((Math.abs(movimiento.saltoVertical())==2)&&(Math.abs(movimiento.saltoHorizontal())==1));
    }
    public Caballo (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2658";
        }
        else {
            nombre = "\u265E";
        }
    }
}
