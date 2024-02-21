package Ajedrez;

public class Rey extends Pieza {
    /**
     * Es un booleano que representa si el rey ha realizado un mivimiento durante la partida
     */
    private boolean enroque = false;
    /**
     * Metodo que crea un Rey con el color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Rey (boolean color) {
        super(color);
        if (!color) {
            ruta = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReyNegro.png";
            nombre = "\u265A";
        }
        else {
            ruta = "File:src/main/resources/com/example/ej3gridimageview/imagenes/ReyBlanco.png";
            nombre = "\u2654";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento,Tablero tablero) {
        if (Math.abs(movimiento.saltoHorizontal())==2 && !isEnroque()) {
            if(tablero.enroque(this,movimiento))
                return true;
            else
                return false;
        }
        else
            return ((Math.abs(movimiento.saltoVertical())==1 && movimiento.isVertical())||(Math.abs(movimiento.saltoHorizontal())==1 && movimiento.isHorizontal())||(movimiento.isDiagonal()&&(movimiento.saltoHorizontal()==1)))?enroque=true:false;
    }

    /**
     * Metodo que pregunta por el valor del booleano enroque
     * @return Devuelve true si el rey ha realizado un movimiento
     */
    public boolean isEnroque() {
        return enroque;
    }
}
