public class Peon extends Pieza {
    public Peon(boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2659";
        }
        else {
            nombre = "\u265F";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return Math.abs(movimiento.saltoVertical())==1;
    }
    public boolean validoComer (Movimiento movimiento,Tablero tablero) {
        return Math.abs(movimiento.saltoDiagonal())==1;
    }

}
