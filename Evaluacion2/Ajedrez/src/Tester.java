import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        Juego juego = new Juego();
        Movimiento movimiento = null;
        Out salida = new Out();
        boolean jaque = false;
        boolean finPartida = false;
        tablero.pintarTablero();
        do {
            if (jaque) {
                if (tablero.jaqueMate(juego)) {
                    System.out.println("Mate!");
                    finPartida = true;
                } else if (tablero.salirJaque(juego)) {
                    jaque = false;
                    juego.setTurno();
                    tablero.pintarTablero();
                }
            } else if (!jaque){
            do {
                System.out.println("Introduzca una jugada (tipo a2a4, pieza que quiero mover y el destino)");
                respuesta = teclado.nextLine();
                movimiento = juego.jugada(respuesta.toUpperCase(),tablero,juego);
            } while (movimiento == null);
            Pieza pieza = tablero.devuelvePieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna());
            if (pieza.validoMovimiento(movimiento,tablero)) {
                    tablero.moverPieza(pieza, movimiento);
                    if (pieza instanceof Peon)
                        if ((movimiento.getPosFinal().getFila()==0 && pieza.getColor())||(movimiento.getPosFinal().getFila()==7 && !pieza.getColor()))
                            salida.coronacion(tablero,pieza,movimiento);
                juego.setTurno();
            } else
                System.out.println(pieza.getClass().getSimpleName() + " no puede realizar ese movimiento");
            tablero.pintarTablero();
            if (tablero.jaque(juego)) {
                System.out.println("Estas en jaque, tienes que proteger tu rey (mueve tu rey a un lugar seguro o protegelo con otra pieza)");
                jaque = true;
            }
        }
        } while (!finPartida);
    }
}