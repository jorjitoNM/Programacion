package org.example;

public class Rey extends Pieza {

    /**
     * Metodo que crea un Rey con el color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Rey (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2654";
        }
        else {
            nombre = "\u265A";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return Math.abs(movimiento.saltoVertical())==1||Math.abs(movimiento.saltoHorizontal())==1||(movimiento.isDiagonal()&&(movimiento.saltoHorizontal()==1));
    }
}
