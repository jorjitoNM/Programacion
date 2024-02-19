public class Torre extends Pieza {
    /**
     * Es un booleano que representa si la torre ha realizado un mivimiento durante la partida
     */
    private boolean enroque = false;
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

    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        return (!tablero.hayPiezasEntre(movimiento))?((movimiento.isVertical()||movimiento.isHorizontal())?enroque=true:false):false; //si se mete por true en la primera y la segunda pregunta, devuelve tru y cambia el booleano o solamente cambia el booleano
    }
    /**
     * Metodo que pregunta por el valor del booleano enroque
     * @return Devuelve true si la torre ha realizado un movimiento
     */
    public boolean isEnroque() {
        return enroque;
    }
}
