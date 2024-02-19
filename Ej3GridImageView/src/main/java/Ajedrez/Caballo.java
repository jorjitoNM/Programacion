package Ajedrez;

public class Caballo extends Pieza {

    /**
     * Metodo que crea un Caballo inicializando su nombre a su caracter Unicode del color adecuado
     * @param color El color sirve para distinguir entre las piezas negras y blancas
     */
    public Caballo (boolean color) {
        super(color);
        if (!color) {
            nombre = "File:src/main/resources/com/example/ej3gridimageview/imagenes/CaballoNegro.png";
        }
        else {
            nombre = "File:src/main/resources/com/example/ej3gridimageview/imagenes/CaballoBlanco.png";
        }
    }
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return ((Math.abs(movimiento.saltoHorizontal())==2)&&(Math.abs(movimiento.saltoVertical())==1))||((Math.abs(movimiento.saltoVertical())==2)&&(Math.abs(movimiento.saltoHorizontal())==1));
    }
}
