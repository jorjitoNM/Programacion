public class Juego {

    private int turno;



    public Movimiento jugada (String jugada, Tablero tablero) {
        Movimiento movimiento = new Movimiento();
        Posicion aux = new Posicion();
        aux.setColumna(jugada.charAt(0));
        aux.setFila(jugada.charAt(1));
        movimiento.setPosInicial(aux);
        aux.setColumna(jugada.charAt(2));
        aux.setFila(jugada.charAt(3));
        movimiento.setPosFinal(aux);
        if (tablero.)
        return
    }
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
