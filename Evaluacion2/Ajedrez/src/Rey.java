public class Rey extends Pieza {
    /**
     * Es un booleano que representa si el rey ha realizado un mivimiento durante la partida
     */
    private boolean enroque = false;
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
        if (movimiento.saltoHorizontal()==2) {
            tablero.enroque(this,movimiento);
            return  true;
        }
        else
            return (Math.abs(movimiento.saltoVertical())==1||Math.abs(movimiento.saltoHorizontal())==1||(movimiento.isDiagonal()&&(movimiento.saltoHorizontal()==1)))?enroque=true:false;
        //return Math.abs(movimiento.saltoVertical())==1||Math.abs(movimiento.saltoHorizontal())==1||(movimiento.isDiagonal()&&(movimiento.saltoHorizontal()==1));

    }

    /**
     * Metodo que pregunta por el valor del booleano enroque
     * @return Devuelve true si el rey ha realizado un movimiento
     */
    public boolean isEnroque() {
        return enroque;
    }
}
