public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento () {
        //para pasasr de movimiento????
    }

    /**
     * Constructor que actualiza la posicion incial y la final a las indicadas
     * @param posInicial
     * @param posFinal
     */
    public Movimiento (Posicion posInicial,Posicion posFinal) {
        this.posFinal = posFinal;
        this.posInicial = posInicial;
    }

    /**
     *
     * @return Devuelve la posicion inicial
     */
    public Posicion getPosInicial() {
        return posInicial;
    }

    /**
     * Metodo que actualiza el valor de posicionInicial
     * @param posInicial
     */
    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }
    /**
     *
     * @return Devuelve la posicion final
     */
    public Posicion getPosFinal() {
        return posFinal;
    }
    /**
     * Metodo que actualiza el valor de posicioFinal
     * @param posFinal
     */
    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Metodo que pregunta si un movimiento es vertical
     * @return Devuelve true cuando es vertical
     */
    public boolean isVertical () {
        return (posInicial.getColumna()==posFinal.getColumna());
    }

    /**
     * Metodo que pregunta si un movimiento es horizontal
     * @return Devuelve true cuando es horizontal
     */
    public boolean isHorizontal () {
        return (posInicial.getFila()!=posFinal.getFila());
    }

    /**
     * Metodo que pregunta si el movimiento es diagonal
     * @return Devuelve true cuando es diagonal
     */
    public boolean isDiagonal () {
        return (posInicial.getFila()!=posFinal.getFila()&&posInicial.getColumna()!=posFinal.getColumna());
    }

    /**
     * Metodo que pregunta si hay diferencia entre la posicion inicial y la final (para saber si hay movimiento)
     * @return Devuelve true cuando no hay movimiento
     */
    public boolean isMovimiento () {
        return (posInicial.getFila()==posFinal.getFila()&&posInicial.getColumna()==posFinal.getColumna());
    }

    /**
     * Metodo que pregunta si el movimiento es un salto horizontal
     * @return Devuelve el numero de casillas saltadas o -1 si no es un salto
     */
    public int saltoHorizontal () {
        if (posInicial.getFila()!=posFinal.getFila()) {
            return posFinal.getFila()- posInicial.getFila();
        }
        return -1;
    }

    /**
     * Metodo que pregunta si el movimiento es un salto vertical
     * @return Devuelve el numero de casillas saltadas o -1 si no es un salto
     */
    public int saltoVertical () {
        if (posInicial.getColumna()==posFinal.getColumna()) {
            return posFinal.getColumna()-posInicial.getColumna();
        }
        return -1;
    }

    /**
     * Metodo que pregunta si el movimiento es un salto diagonal
     * @return Devuelve el numero de casillas saltadas o -1 si no es un salto
     */
    public int saltoDiagonal () {
        if ((posInicial.getFila()!=posFinal.getFila()&&posInicial.getColumna()!= posFinal.getColumna())&&(Math.abs(saltoVertical())==Math.abs(saltoHorizontal()))) {
            return (int)(Math.sqrt((posInicial.getFila()-posFinal.getFila())-(posInicial.getColumna()-posFinal.getColumna())));
        }
        return -1;
    }
}
