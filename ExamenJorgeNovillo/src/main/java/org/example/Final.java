package org.example;

public class Final extends Casilla{
    @Override
    public int avanzar(int dado) {
        return 0;
    }

    @Override
    public String lanzarMensaje() { //jacer metodo para felicitar al usuario
        return "Enrhorabuena, has ganado";
    }

    @Override
    public boolean cambiarTurno() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s",getClass().getSimpleName().charAt(0));
    }
}
