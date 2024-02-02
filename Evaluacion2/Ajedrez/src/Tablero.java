public class Tablero {
    private Pieza[][] tablero;


    public Tablero () {
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre(true);
        tablero[0][1] = new Caballo(true);
        tablero[0][2] = new Alfil(true);
        tablero[0][3] = new Rey(true);
        tablero[0][4] = new Dama(true);
        tablero[0][5] = new Alfil(true);
        tablero[0][6] = new Caballo(true);
        tablero[0][7] = new Torre(true);
        tablero[1][0] = new Peon(true);
        tablero[1][1] = new Peon(true);
        tablero[1][2] = new Peon(true);
        tablero[1][3] = new Peon(true);
        tablero[1][4] = new Peon(true);
        tablero[1][5] = new Peon(true);
        tablero[1][6] = new Peon(true);
        tablero[1][7] = new Peon(true);

        tablero[7][0] = new Torre(false);
        tablero[7][1] = new Caballo(false);
        tablero[7][2] = new Alfil(false);
        tablero[7][3] = new Rey(false);
        tablero[7][4] = new Dama(false);
        tablero[7][5] = new Alfil(false);
        tablero[7][6] = new Caballo(false);
        tablero[7][7] = new Torre(false);
        tablero[6][0] = new Peon(false);
        tablero[6][1] = new Peon(false);
        tablero[6][2] = new Peon(false);
        tablero[6][3] = new Peon(false);
        tablero[6][4] = new Peon(false);
        tablero[6][5] = new Peon(false);
        tablero[6][6] = new Peon(false);
        tablero[6][7] = new Peon(false);
    }
    public void pintarTablero () {
        int contador = 8;
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(contador +" ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j]!=null) {
                    System.out.print(tablero[i][j].toString() + " ");
                }
            }
            contador--;
            System.out.println();
        }
    }
    public boolean hayPieza (int fila, int columna) {
        return tablero[fila][columna]!=null;
    }
    public boolean hayPieza (Posicion posicion) {
        return tablero[posicion.getFila()][posicion.getColumna()]!=null;
    }
    public boolean hayPiezasEntre (Movimiento movimiento) {
        boolean exit = false;
        if (movimiento.isHorizontal()) {
            for (int i = movimiento.getPosInicial().getColumna(); i < movimiento.getPosFinal().getColumna()&&!exit; i++) {
                if (tablero[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()+i]==null) {
                    exit = true;
                }
            }
        }
        return false;
    }
    public void ponPieza(Pieza figura, int fila, int columna) {

    }
    public void ponPieza(Pieza figura, Posicion Pos) {

    }
    public void quitaPieza(int fila,int columna) {

    }
    public void QuitaPieza(Posicion pos) {

    }
    public Pieza DevuelvePieza(int fila,int columna){
        return tablero[fila][columna];
    }
    /*public Pieza DevuelvePieza(Posicion pos) {

    }
     */
}
