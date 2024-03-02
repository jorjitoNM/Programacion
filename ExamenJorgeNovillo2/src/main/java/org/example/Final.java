package org.example;

public class Final extends Casilla{
    @Override
    public int avanzar(int dado) {
        return 0;
    }
    public Final (Juego partida) {
        super(partida);
    }
    @Override
    public String lanzarMensaje() { //jacer metodo para felicitar al usuario
        return "Enrhorabuena, has ganado";
    }

    @Override
    public String toString() {
        return " F ";
    }
}
