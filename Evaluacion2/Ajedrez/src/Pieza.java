public abstract class Pieza {
    /**
     * Es el color de la pieza, false si es blanca, true si es negra
     */
    private boolean color;
    /**
     * Es el caracter Unicode de la pieza (su dibujo)
     */
    protected String nombre;

    /**
     * Constructor que crea una pieza de color aleatorio
     */
    public Pieza () {
        color = Math.random() * 1 + 1 == 1;
    }

    /**
     * Constructor que crea una pieza del color indicado, utilizando como nombre la primera letra del nombre de la clase
     * @param color Es el color de la pieza que se va a crear (true si es blanca, false si es negra)
     */
    public Pieza(boolean color) {
        this.color= color;
    }

    /**
     * Metodo que pregunta si un movimiento es valido de realizar
     * @param movimiento Es el recorrido que va a realizar la pieza
     * @return Devuelve true si el movimiento es correcto (no incumple ninguna regla)
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
     * Metodo que actualiza el valor del color de la pieza
     * @param color Es el color al que vas a cambiar la pieza
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /**
     * Metodo que crea un clon de una pieza
     * @return Devuelve una pieza del tipo del hijo que implementa el metodo
     */
    public abstract Pieza clonarPieza ();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que imprime el nombre de la pieza (este ya incluye su color por el simbolo que aparece)
     * @return Devuelve un String con el Unicode de la pieza
     */
    @Override
    public String toString() {
        return String.format("%s",nombre);
    }
}
