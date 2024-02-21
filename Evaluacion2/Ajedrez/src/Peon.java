import java.util.Scanner;

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
    /**
     * Metodo que comprueba si el movimiento es valido teniendo en cuenta si va a comer o a avanzar
     * @param movimiento Es el recorrido que va a realizar el peon
     * @param tablero Es el tablero de juego que se esta usando
     * @return Devuelve true cuando el movimiento es valido
     */
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        if (!getColor()) { //es negro
            if (tablero.hayPieza(movimiento.getPosFinal())&&movimiento.isDiagonal())
                return movimiento.saltoVertical()==1;
            else  if (movimiento.getPosInicial().getFila()==1&&!movimiento.isDiagonal()&&movimiento.saltoHorizontal()==0)
                return movimiento.saltoVertical()==1||(!tablero.hayPiezasEntre(movimiento)&&movimiento.saltoVertical()==2);
            else if (!movimiento.isDiagonal()&&!tablero.hayPieza(movimiento.getPosFinal())&&movimiento.saltoHorizontal()==0)
                return movimiento.saltoVertical()==1;

        }
        else { //es blanco
            if (tablero.hayPieza(movimiento.getPosFinal())&&movimiento.isDiagonal())
                return movimiento.saltoVertical()==-1;
            else if (movimiento.getPosInicial().getFila()==6&&!movimiento.isDiagonal()&&movimiento.saltoHorizontal()==0)
                return movimiento.saltoVertical()==-1||(!tablero.hayPiezasEntre(movimiento)&&movimiento.saltoVertical()==-2);
            else if (!movimiento.isDiagonal()&&!tablero.hayPieza(movimiento.getPosFinal())&&movimiento.saltoHorizontal()==0)
                return movimiento.saltoVertical()==-1;
        }
        return false;
    }
}
