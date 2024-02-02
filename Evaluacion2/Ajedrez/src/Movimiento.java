public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento () {
        //para pasasr de movimiento????
    }
    public Movimiento (Posicion posInicial,Posicion posFinal) {
        this.posFinal = posFinal;
        this.posInicial = posInicial;
    }


    public Posicion getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    public boolean isVertical () {
        return (posInicial.getColumna()==posFinal.getColumna());
    }
    public boolean isHorizontal () {
        return (posInicial.getFila()!=posFinal.getFila());
    }
    public boolean isDiagonal () {
        return (posInicial.getFila()!=posFinal.getFila()&&posInicial.getColumna()!=posFinal.getColumna());
    }
    public boolean isMovimiento () {
        return (posInicial.getFila()==posFinal.getFila()&&posInicial.getColumna()== posFinal.getColumna());
    }
    public int saltoHorizontal () {
        if (posInicial.getFila()!=posFinal.getFila()) {
            return posFinal.getFila()- posInicial.getFila();
        }
        return -1;
    }
    public int saltoVertical () {
        if (posInicial.getColumna()==posFinal.getColumna()) {
            return posFinal.getColumna()-posInicial.getColumna();
        }
        return -1;
    }
    public  int saltoDiagonal () {
        if ((posInicial.getFila()!=posFinal.getFila()&&posInicial.getColumna()!= posFinal.getColumna())&&(Math.abs(saltoVertical())==Math.abs(saltoHorizontal()))) {
            return (int)(Math.sqrt((posInicial.getFila()-posFinal.getFila())-(posInicial.getColumna()-posFinal.getColumna())));
        }
        return -1;
    }
}
