public class Movimiento {
    /**
     * Es la coordenada Inicial del movimiento (fila,columna)
     */
    private Posicion posInicial;
    /**
     * Es la coordenada final del movimiento (fila,columna)
     */
    private Posicion posFinal;

    /**
     * Metodo que no hace nada
     */
    public Movimiento () {
    }
    /**
     * Constructor que actualiza la posicion incial y la final a las indicadas
     * @param posInicial Es la coordenada inicial del movimiento (fila,columna)
     * @param posFinal Es la coordenada final del movimiento (fila,columna)
     */
    public Movimiento (Posicion posInicial,Posicion posFinal) {
        this.posFinal = posFinal;
        this.posInicial = posInicial;
    }

    /**
     *
     * @return Devuelve la posicion inicial del movimiento
     */
    public Posicion getPosInicial() {
        return posInicial;
    }

    /**
     * Metodo que actualiza el valor de posicionInicial
     * @param posInicial Es la coordenada inicial del movimiento (fila,columna)
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
     * @param posFinal Es la coordenada final del movimiento (fila,columna)
     */
    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Metodo que pregunta si un movimiento es vertical (la fila cambia y la columna se mantiene)
     * @return Devuelve true cuando es vertical
     */
    public boolean isVertical () {
        return (posInicial.getColumna()==posFinal.getColumna());
    }

    /**
     * Metodo que pregunta si un movimiento es horizontal (la columna cambia y la fila se mantiene)
     * @return Devuelve true cuando es horizontal
     */
    public boolean isHorizontal () {
        return (posInicial.getFila()==posFinal.getFila());
    }

    /**
     * Metodo que pregunta si el movimiento es diagonal
     * @return Devuelve true cuando es diagonal
     */
    public boolean isDiagonal () {
        //(Math.pow(Math.abs(posFinal.getFila()-posInicial.getFila()),2)+Math.pow(Math.abs(posFinal.getColumna()-posInicial.getColumna()),2))==Math.pow(,2)
        return (Math.abs(saltoHorizontal())==Math.abs(saltoVertical()))?true:false;
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
     * @return Devuelve el numero de casillas saltadas o -3 si no es un salto
     */
    public int saltoHorizontal () {
        return posFinal.getColumna()-posInicial.getColumna();
    }
    /*
    public int saltoHorizontal () {
        if (isHorizontal()) {
            return posFinal.getColumna()-posInicial.getColumna();
        }
        return 0;
    }
     */
    /**
     * Metodo que pregunta si el movimiento es un salto vertical
     * @return Devuelve el numero de casillas saltadas o -3 si no es un salto
     */
    public int saltoVertical () {
        return posFinal.getFila()-posInicial.getFila();
    }
    /*
    public int saltoVertical () {
        if (isVertical()) {
            return posFinal.getFila()-posInicial.getFila();
        }
        return 0;
    }
     */
    /**
     * Metodo que pregunta si el movimiento es un salto diagonal
     * @return Devuelve el numero de casillas saltadas o -3 si no es un salto
     */
    /*
    public int saltoDiagonal () {
        if (isDiagonal())
            return (int)(Math.sqrt(Math.pow(saltoHorizontal(),2)+Math.pow(saltoVertical(),2)));
        return 0;
    }
     */
}
