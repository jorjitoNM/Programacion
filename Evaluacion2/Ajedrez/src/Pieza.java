public abstract class Pieza {
    private boolean color;
    protected String nombre;

    public Pieza () {
        color = Math.random() * 1 + 1 == 1;
    }

    public Pieza(boolean color) {
        nombre = String.valueOf(this.getClass().getSimpleName().charAt(0));
    }


    public abstract boolean validoMovimiento (Movimiento movimiento, Tablero tablero);
    public boolean getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s",nombre);
    }
}
