public class Alfil extends Pieza {

    /**
     * Metodo que crea un Alfil con el color indicado
     * @param color
     */
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
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return (!tablero.hayPiezasEntre(movimiento))?movimiento.isDiagonal():!movimiento.isDiagonal();
    }
}
