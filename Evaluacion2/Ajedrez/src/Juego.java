public class Juego {

    /**
     * Representa que jugador debe jugar (blancas si es par, negras si es impar)
     */
    private int turno = 0;

    public Juego() {
    }
    /**
     * Metodo que calcula el turno (par si juegan blancas e impar si juegan negras).
     * @return Devuelve true cuando el turno no es par (el color true son las negras)
     */
    public boolean darTurno () {
        return turno % 2 == 0;
    }

    /**
     * Metodo que recibe una jugada en forma de coordenadas y comprueba si es válida
     * @param jugada Es un string que indica una coordenada en sus dos primeros caracteres, la pieza a mover, y una segunda coordenada en sus dos ultimos caracteres, la casilla de destino de la pieza
     * @param tablero Es el tablero de juego concreto
     * @return Devuelve una jugada que sera el movimiento que va a realizar la pieza indicada
     */
    public Movimiento jugada (String jugada, Tablero tablero,Juego partida) {
        Movimiento movimiento = null;
        if (jugada.length()!=4)
            System.out.println("Error. La jugada tiene que ser del tipo A2A3 (pieza origen/casilla destino)");
        else {
            int filaInicial = 7-(jugada.charAt(1)-49);
            int columnaInicial = jugada.charAt(0)-65;
            int filaFinal = 7-(jugada.charAt(3)-49);
            int columnaFinal = jugada.charAt(2)-65;
            if (!((filaInicial<=7&&filaInicial>=0)&&(columnaInicial<=7&&columnaInicial>=0)&&(filaFinal<=7&&filaFinal>=0)&&(columnaFinal<=7&&columnaFinal>=0)))
            System.out.println("Error. Jugada fuera de tablero");
        else if (!tablero.hayPieza(filaInicial,columnaInicial))
            System.out.println("Error. No hay pieza en esta casilla");
        else if (tablero.devuelvePieza(filaInicial,columnaInicial).getColor()!=darTurno())
            System.out.println("Error. Esa pieza no es tuya");
        else if ((tablero.hayPieza(filaFinal,columnaFinal)&&(tablero.devuelvePieza(filaFinal,columnaFinal).getColor()==darTurno())))
            System.out.println("Error. No puedes comerte una pieza tuya");
        else
            movimiento= new Movimiento(new Posicion(filaInicial,columnaInicial),new Posicion(filaFinal,columnaFinal));
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
     */
    public void setTurno() {
        turno++;
    }
}
