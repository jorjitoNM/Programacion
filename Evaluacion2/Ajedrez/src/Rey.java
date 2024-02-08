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
        return movimiento.saltoVertical()==1||movimiento.saltoHorizontal()==1||movimiento.saltoDiagonal()==1;
    }
}