import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
       Tablero tablero = new Tablero();
       tablero.pintarTablero();
        Scanner teclado = new Scanner(System.in);
       String respuesta;
       Juego juego = new Juego();
       do {
           System.out.println("Introduzca una jugada (tipo a2a4, pieza que quiero mover y el destino)");
           respuesta = teclado.nextLine();
           Movimiento movimiento =juego.jugada(respuesta,tablero);
           Posicion destino = movimiento.getPosFinal();
           Pieza pieza = tablero.devuelvePieza(movimiento.getPosInicial().getFila(),movimiento.getPosInicial().getColumna());
               if ((movimiento!=null)&&(pieza.validoMovimiento(movimiento,tablero))) {
                   tablero.ponPieza(pieza,destino);
                   tablero.pintarTablero();
               }
       }while (juego.getContador()<50);
    }
}
