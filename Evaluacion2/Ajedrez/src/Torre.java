public class Torre extends Pieza {

    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return (movimiento.isVertical()||movimiento.isHorizontal());
    }

    /**
     * Metodo que crea una Torre del color adecuado
     * @param color
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
