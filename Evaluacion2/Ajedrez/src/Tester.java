import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.pintarTablero();
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        Juego juego = new Juego();
        Movimiento movimiento = null;
        do {
            do {
                System.out.println("Introduzca una jugada (tipo a2a4, pieza que quiero mover y el destino)");
                respuesta = teclado.nextLine();
                movimiento = juego.jugada(respuesta.toUpperCase(), tablero);
            } while (movimiento == null);
            Pieza pieza = tablero.devuelvePieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna());
            if (pieza.validoMovimiento(movimiento, tablero)) {
                tablero.moverPieza(pieza, movimiento);
            }else
                System.out.println(pieza.getClass().getSimpleName() + " no puede realizar ese movimiento");
            tablero.pintarTablero();

        } while (juego.getContador() < 50);
    }
}
