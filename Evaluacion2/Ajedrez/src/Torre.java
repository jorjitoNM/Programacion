public class Torre extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return (movimiento.isVertical()||movimiento.isHorizontal());
    }

    /**
     * Metodo que crea una Torre inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Torre (boolean color) {
        super(color);
        if (!color) {
            nombre = "\u2656";
        }
        else {
            nombre = "\u265C";
        }
    }
}
