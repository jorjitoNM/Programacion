public class Peon extends Pieza {

    /**
     * Metodo que cera un Peon con el color adecuado
     * @param color
     */
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

    /**
     * Metodo que comprueba si el movimiento es valido teniendo en cuenta que va a comer
     * @param movimiento
     * @param tablero
     * @return
     */
    public boolean validoComer (Movimiento movimiento,Tablero tablero) {
        return Math.abs(movimiento.saltoDiagonal())==1;
    }

}
