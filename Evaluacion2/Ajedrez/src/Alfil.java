public class Alfil extends Pieza {

    /**
     * Metodo que crea un Alfil inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
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
        return (tablero.hayPiezasEntre(movimiento))?false:movimiento.isDiagonal();
    }
}
