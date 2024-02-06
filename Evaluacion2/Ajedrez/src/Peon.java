public class Peon extends Pieza {

    /**
     * Metodo que cera un Peon inicializando su nombre a su caracter Unicode del color adecuado
     * @param color  El color sirve para distinguir entre las piezas negras y blancas
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
     * @param movimiento Es el recorrido que va a realizar el peon
     * @param tablero Es el tablero de juego que se esta usando
     * @return devuelve true cuando el movimiento para comer es valido
     */
    public boolean validoComer (Movimiento movimiento,Tablero tablero) {
        return Math.abs(movimiento.saltoDiagonal())==1;
    }

}
