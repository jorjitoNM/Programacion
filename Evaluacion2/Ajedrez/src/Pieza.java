public abstract class Pieza {
    private boolean color;
    protected String nombre;

    /**
     * Constructor que crea una pieza de color aleatorio
     */
    public Pieza () {
        color = Math.random() * 1 + 1 == 1;
    }

    /**
     * Constructor que crea una pieza del color indicado, utilizando como nombre la primera letra del nombre de la clase
     * @param color
     */
    public Pieza(boolean color) {
        nombre = String.valueOf(this.getClass().getSimpleName().charAt(0));
    }

    /**
     * Metodo que pregunta si un movimiento es valido de realizar
     * @param movimiento
     * @return Devuelve true si el movimiento es correcto
     */
    public abstract boolean validoMovimiento (Movimiento movimiento,Tablero tablero);

    /**
     *
     * @return Devuelve el color de la pieza
     */
    public boolean getColor() {
        return color;
    }

    /**
     * Metodo que imprime el nombre de la pieza (este ya incluye su color por el simbolo que aparece)
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s",nombre);
    }
}
