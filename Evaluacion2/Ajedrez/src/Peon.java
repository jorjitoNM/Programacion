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
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return false;
    }

    /**
     * Metodo que comprueba si el movimiento es valido teniendo en cuenta si va a comer o a avanzar
     * @param movimiento Es el recorrido que va a realizar el peon
     * @param tablero Es el tablero de juego que se esta usando
     * @return Devuelve true cuando el movimiento es valido
     */
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero,Juego partida) {
        if (getColor(partida)) { //es negro
            if (tablero.hayPieza(movimiento.getPosFinal())) {
                return movimiento.saltoDiagonal()==1;
            }
            else  if (movimiento.getPosInicial().getFila()==1)
                return movimiento.saltoVertical()==1||movimiento.saltoVertical()==2;
            else
                return movimiento.saltoVertical()==1;
        }
        else { //es blanco
            if (tablero.hayPieza(movimiento.getPosFinal()))
                return movimiento.saltoDiagonal()==-1;
            else if (movimiento.getPosInicial().getFila()==6)
                return movimiento.saltoVertical()==-1||movimiento.saltoVertical()==-2;
            else
                return movimiento.saltoVertical()==-1;
        }
    }
}
