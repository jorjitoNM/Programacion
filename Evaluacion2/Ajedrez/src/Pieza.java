public abstract class Pieza {
    private boolean color;
    private String nombre;

    public Pieza () {
        color = Math.random() * 1 + 1 == 1;
    }




    public abstract boolean validoMovimiento (Movimiento movimiento);
    public boolean isColor() {
        return color;
    }
}
