package org.example;

public class Final extends Casilla{
    @Override
    public int avanzar(int dado) {
        return 0;
    }

    @Override
    public void lanzarMensaje() { //jacer metodo para felicitar al usuario
        System.out.println("Enrhorabuena, has llegado al final");
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }
    @Override
    public void accion(Juego partida) {
        lanzarMensaje();
        cambiarTurno();
    }
}
