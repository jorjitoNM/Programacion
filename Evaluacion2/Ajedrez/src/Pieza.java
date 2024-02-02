public abstract class Pieza {
    private boolean color;
    protected String nombre;

    public Pieza () {
        color = Math.random() * 1 + 1 == 1;
    }

    public Pieza(boolean color) {
        nombre = String.valueOf(this.getClass().getSimpleName().charAt(0));
    }


    public abstract boolean validoMovimiento (Movimiento movimiento);
    public boolean isColor() {
        return color;
    }

    @Override
    public String toString() {
        String color;
        if (this.color) {
            color = "N";
        }
        else {
            color = "B";
        }
        return String.format("%s",nombre);
    }
}
