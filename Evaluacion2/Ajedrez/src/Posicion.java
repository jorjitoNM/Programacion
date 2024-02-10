public class Posicion {
    private int fila;
    private int columna;


    public Posicion() {
    }
    /**
     * Contructor que asigna los valores de fila y de columna a los proporcionados
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    /**
     *
     * @return Devuelve el valor de fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Metodo que actualiza el valor de fila
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *
     * @return Devuelve el valor de columna
     */
    public int getColumna() {
        return columna;
    }
    /**
     * Metodo que actualiza el valor de columna
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
}
