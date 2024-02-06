public class Juego {

    /**
     * Representa que jugador debe jugar (blancas si es par, negras si es impar)
     */
    private int turno;
    /**
     * Representa el crecimiento del valor de turno
     */
    private int contador = 0;

    /**
     * Metodo que calcula el turno (par si juegan blancas e impar si juegan negras).
     * @return Devuelve true cuando el turno no es par (el color true son las negras)
     */
    public boolean darTurno () {
        return turno % 2 != 0;
    }
    /*public Movimiento jugada2 (String jugada, Tablero tablero) { //el String tiene que estar en mayuscula
        Movimiento movimiento = null;
        int filaInicial = jugada.charAt(1)-49;
        int columnaInicial = jugada.charAt(0)-65;
        int filaFinal = jugada.charAt(3)-49;
        int columnaFinal = jugada.charAt(2)-65;
        movimiento.setPosInicial(new Posicion(columnaInicial,filaInicial));
        movimiento.setPosFinal(new Posicion(columnaFinal,filaFinal));
        if (jugada.length()==4) {
            if ((filaInicial<=7&&filaInicial>=0)&&(columnaInicial<=7&&columnaInicial>=0)&&(tablero.devuelvePieza(filaInicial,columnaInicial).getColor()==darTurno()) { //como hago esto??
                    if (filaFinal<=7&&filaFinal>=0) {
                        if (columnaFinal<=7&&columnaFinal>=0) {
                            if (tablero.devuelvePieza(columnaInicial,filaInicial).validoMovimiento(movimiento,tablero)) {
                                contador++;
                            }
                            //4 int filaInicial, filaFinal
                            //movimiento = new Movimiento(new Posicion(filaInicial,));
                            Posicion aux = new Posicion();
                            aux.setColumna(jugada.charAt(0));
                            aux.setFila(jugada.charAt(1));
                            movimiento.setPosInicial(aux);
                            aux.setColumna(jugada.charAt(2));
                            aux.setFila(jugada.charAt(3));
                            movimiento.setPosFinal(aux);
                        }
                        else {

                        }
                }
            } else {
                System.out.println("No hay una pieza en esa casilla o la pieza no es tuya");
            }
        }
        else {

        }
        return movimiento;
    }*/

    /**
     * Metodo que recibe una jugada en forma de coordenadas y comprueba si es válida
     * @param jugada Es un string que indica una coordenada en sus dos primeros caracteres, la pieza a mover, y una segunda coordenada en sus dos ultimos caracteres, la casilla de destino de la pieza
     * @param tablero Es el tablero de juego concreto
     * @return Devuelve una jugada que sera el movimiento que va a realizar la pieza indicada
     */
    public Movimiento jugada (String jugada, Tablero tablero) {
        Movimiento movimiento = null;
        int filaInicial = jugada.charAt(1)-49;
        int columnaInicial = jugada.charAt(0)-65;
        int filaFinal = jugada.charAt(3)-49;
        int columnaFinal = jugada.charAt(2)-65;
        if (jugada.length()!=4)
            System.out.println("Error. La jugada tiene que ser del tipo A2A3 (pieza origen/casilla destino)");
        else if (!((filaInicial<=7&&filaInicial>=0)&&(columnaInicial<=7&&columnaInicial>=0)&&(filaFinal<=7&&filaFinal>=0)&&(columnaFinal<=7&&columnaFinal>=0)))
            System.out.println("Error. Jugada fuera de tablero");
        else if (!tablero.hayPieza(filaInicial,columnaInicial))
            System.out.println("Error. No hay pieza en esta casilla");
        else if (tablero.devuelvePieza(filaInicial,columnaInicial).getColor()!=darTurno())
            System.out.println("Error. Esa pieza no es tuya");
        else if (!((tablero.hayPieza(filaFinal,columnaFinal)&&(tablero.devuelvePieza(filaInicial,columnaInicial).getColor()!=darTurno()))))
            System.out.println("Error. No puedes comerte una pieza tuya");
        else if (!tablero.devuelvePieza(filaInicial,columnaInicial).validoMovimiento(movimiento,tablero)) {
            System.out.println("Error. Movimiento no válido");
        } else {
            movimiento= new Movimiento();
            contador++;
        }
        return movimiento;
    }

    /**
     *
     * @return Devuelve el valor de turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Metodo que actualiza el valor de turno
     * @param turno Es el turno es un contador que representa si es el turno de las blancas (contador en par) o las negras (contador impar)
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
