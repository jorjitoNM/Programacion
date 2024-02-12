public class Tablero {
    /**
     * Es un array que representa un tablero de ajdrez donde se van a mover las piezas
     */
    private Pieza[][] tablero;


    /**
     * Metodo que incializa el tablero con todas las piezas en sus posiciones adecuadas
     */
    public Tablero () {
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre(false);
        tablero[0][1] = new Caballo(false);
        tablero[0][2] = new Alfil(false);
        tablero[0][3] = new Dama(false);
        tablero[0][4] = new Rey(false);
        tablero[0][5] = new Alfil(false);
        tablero[0][6] = new Caballo(false);
        tablero[0][7] = new Torre(false);
        tablero[1][0] = new Peon(false);
        tablero[1][1] = new Peon(false);
        tablero[1][2] = new Peon(false);
        tablero[1][3] = new Peon(false);
        tablero[1][4] = new Peon(false);
        tablero[1][5] = new Peon(false);
        tablero[1][6] = new Peon(false);
        tablero[1][7] = new Peon(false);

        tablero[7][0] = new Torre(true);
        tablero[7][1] = new Caballo(true);
        tablero[7][2] = new Alfil(true);
        tablero[7][3] = new Dama(true);
        tablero[7][4] = new Rey(true);
        tablero[7][5] = new Alfil(true);
        tablero[7][6] = new Caballo(true);
        tablero[7][7] = new Torre(true);
        tablero[6][0] = new Peon(true);
        tablero[6][1] = new Peon(true);
        tablero[6][2] = new Peon(true);
        tablero[6][3] = new Peon(true);
        tablero[6][4] = new Peon(true);
        tablero[6][5] = new Peon(true);
        tablero[6][6] = new Peon(true);
        tablero[6][7] = new Peon(true);
    }

    /**
     * Metodo que imprime el tablero con todas las fichas que en el se hayan
     */
    public void pintarTablero () {
        int contador = 8;
        System.out.println("   A   B   C  D   E   F   G  H");
        for (int i = 0; i<tablero.length; i++) {
            System.out.print(contador +" ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j]!=null) {
                    System.out.printf(" " + tablero[i][j].toString() + " "); //podria hacerse con un printf para que ocupe 2 huecos??
                }
                else {
                    if (j%2==0)
                        System.out.print(" \u25A1  ");
                    else
                        System.out.print(" \u25A0  ");
                }
            }
            contador--;
            System.out.println();
        }
    }

    /**
     * Metodo que comprueba si hay una pieza en la posicion indicada por fila y columna
     * @param fila Primer valor de la coordenada donde se busca
     * @param columna Segundo valor de la coordenada donde se busca
     * @return Devuelve true cuando hay una pieza en la coordenada
     */
    public boolean hayPieza (int fila, int columna) {
        return tablero[fila][columna]!=null;
    }

    /**
     * Metodo que comprueba si hay una pieza en la posicion indicada obtenida por una posicion
     * @param posicion Coordenada donde se busca
     * @return Devuelve true cuando hay una pieza
     */
    public boolean hayPieza (Posicion posicion) {
        return tablero[posicion.getFila()][posicion.getColumna()]!=null;
    }

    /**
     * Metodo que busca si hay piezas dentro del rango del movimiento proporcionado
     * @param movimiento Desplazamiento que va a realizar la pieza
     * @return Devuelve true cuando encuantra una pieza en el recorrido
     */
    public boolean hayPiezasEntre (Movimiento movimiento) {
        boolean exit = false;
        if (movimiento.isHorizontal()) {
            if (movimiento.getPosInicial().getColumna()>movimiento.getPosFinal().getColumna()) {
                for (int i = movimiento.getPosInicial().getColumna()-1; i > movimiento.getPosFinal().getColumna()&&!exit; i--) {
                    if (hayPieza(movimiento.getPosInicial().getFila(),i)) {
                        exit = true;
                    }
                }
            } else {
                for (int i = movimiento.getPosInicial().getColumna()+1; i < movimiento.getPosFinal().getColumna()&&!exit; i++) {
                    if (hayPieza(movimiento.getPosInicial().getFila(),i)) {
                        exit = true;
                    }
                }
            }
        }
        else if (movimiento.isDiagonal()) {
            if ((movimiento.getPosInicial().getFila()>movimiento.getPosFinal().getFila())&&(movimiento.getPosInicial().getColumna()>movimiento.getPosFinal().getColumna())&&(movimiento.saltoVertical())==(movimiento.saltoHorizontal())) {
                for (int i = movimiento.getPosInicial().getFila()-1, j= movimiento.getPosInicial().getColumna()-1; i > movimiento.getPosFinal().getFila() && !exit; i--,j--) {
                    if (hayPieza(i,j)) {
                        exit = true;
                    }
                }
            } else if ((movimiento.getPosInicial().getFila()<movimiento.getPosFinal().getFila())&&(movimiento.getPosInicial().getColumna()<movimiento.getPosFinal().getColumna())&&(movimiento.saltoVertical())==(movimiento.saltoHorizontal())) {
                for (int i = movimiento.getPosFinal().getFila()+1,j = movimiento.getPosFinal().getColumna()+1; i < movimiento.getPosFinal().getFila() && !exit; i++,j++) {
                    if (hayPieza(i,j)) {
                        exit = true;
                    }
                }
            } else if ((movimiento.getPosInicial().getFila()>movimiento.getPosFinal().getFila())&&(movimiento.getPosInicial().getColumna()<movimiento.getPosFinal().getColumna())) {
                for (int i = movimiento.getPosInicial().getFila()-1,j = movimiento.getPosInicial().getColumna()+1; i < movimiento.getPosFinal().getFila(); i--,j++) {
                    if (hayPieza(i,j)) {
                        exit = true;
                    }
                }
            }
            else {
                for (int i = movimiento.getPosInicial().getFila()+1,j = movimiento.getPosInicial().getColumna()-1; i < movimiento.getPosFinal().getFila(); i++,j--) {
                    if (hayPieza(i,j)) {
                        exit = true;
                    }
                }
            }

        } else if (movimiento.isVertical()) {
            if (movimiento.getPosInicial().getFila()>movimiento.getPosFinal().getFila()) {
                for (int i = movimiento.getPosInicial().getFila()-1; i > movimiento.getPosFinal().getColumna()&&!exit; i--) {
                    if (hayPieza(i,movimiento.getPosInicial().getColumna())) {
                        exit = true;
                    }
                }
            }
            else {
                for (int i = movimiento.getPosInicial().getFila()+1; i < movimiento.getPosFinal().getColumna()&&!exit; i++) {
                    if (hayPieza(i,movimiento.getPosInicial().getColumna())) {
                        exit = true;
                    }
                }
            }
        }
        return exit;
    }
    public void ponPieza(Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }
    public void ponPieza(Pieza figura, Posicion posicion) {
        tablero[posicion.getFila()][posicion.getColumna()] = figura;
    }
    public void quitaPieza(int fila,int columna) {
        tablero[fila][columna] = null;
    }
    public void quitaPieza(Posicion posicion) {
        tablero[posicion.getFila()][posicion.getColumna()] = null;
    }

    /**
     *
     * @param fila Primer valor de la coordenada de busqueda
     * @param columna Segundo valor de la coordenada de busqueda
     * @return Devuelve una pieza segun los parametros de posicion en el array dados
     */
    public Pieza devuelvePieza(int fila,int columna){
        return tablero[fila][columna];
    }

    /**
     *
     * @param posicion Coordenada de busqueda
     * @return Devuelve la pieza que se encuentre en esa posicion (o null si no hay pieza)
     */
    public Pieza devuelvePieza(Posicion posicion) {
        return tablero[posicion.getFila()][posicion.getColumna()];
    }
    public void moverPieza (Pieza figura, Movimiento movimiento) {
        ponPieza(figura,movimiento.getPosFinal());
        quitaPieza(movimiento.getPosInicial());
    }
}
