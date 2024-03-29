public class Caballo extends Pieza {

    /**
     * Metodo que crea un Caballo inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Caballo (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2658";
        }
        else {
            nombre = "\u265E";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return ((Math.abs(movimiento.saltoHorizontal())==2)&&(Math.abs(movimiento.saltoVertical())==1))||((Math.abs(movimiento.saltoVertical())==2)&&(Math.abs(movimiento.saltoHorizontal())==1));
    }
}
