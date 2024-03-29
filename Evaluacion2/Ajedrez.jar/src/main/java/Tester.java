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
                movimiento = juego.jugada(respuesta.toUpperCase(),tablero,juego);
                if (tablero.jaque(juego)) {
                    System.out.println("Estas en jaque, tienes que proteger tu rey (mueve tu rey a un lugar seguro o protegelo con otra pieza)");
                }
            } while (movimiento == null && !tablero.jaque(juego));
            Pieza pieza = tablero.devuelvePieza(movimiento.getPosInicial().getFila(), movimiento.getPosInicial().getColumna());
            if (pieza.validoMovimiento(movimiento, tablero)) {
                tablero.moverPieza(pieza, movimiento);
                if (pieza instanceof Peon) {
                    String coronacion;
                    boolean exit = false;
                    if (movimiento.getPosFinal().getFila()==0 && pieza.getColor()) {
                        do {
                            System.out.println("Acabas de coronar. Escoge la pieza por la que quieres cambiar el peon (recuerda que no puede ser otro peon o un rey)");
                            coronacion = teclado.nextLine();
                            if (coronacion.equalsIgnoreCase("caballo")) {
                                pieza = new Caballo(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("alfil")) {
                                pieza = new Alfil(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("dama")) {
                                pieza = new Dama(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("torre")) {
                                pieza = new Torre(pieza.getColor());
                                exit = true;
                            } else
                                System.out.println("No puedes covertir tu peon en esa pieza");
                            if (exit)
                                tablero.moverPieza(pieza,movimiento);
                        } while (!exit);
                    }
                    else if (movimiento.getPosFinal().getFila()==7 && !pieza.getColor()){
                        do {
                            System.out.println("Acabas de coronar. Escoge la pieza por la que quieres cambiar el peon (recuerda que no puede ser otro peon o un rey)");
                            coronacion = teclado.nextLine();
                            if (coronacion.equalsIgnoreCase("caballo")) {
                                pieza = new Caballo(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("alfil")) {
                                pieza = new Alfil(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("dama")) {
                                pieza = new Dama(pieza.getColor());
                                exit = true;
                            } else if (coronacion.equalsIgnoreCase("torre")) {
                                pieza = new Torre(pieza.getColor());
                                exit = true;
                            } else
                                System.out.println("No puedes covertir tu peon en esa pieza");
                            if (exit)
                                tablero.moverPieza(pieza,movimiento);
                        } while (!exit);
                    }
                }
                if (pieza instanceof Rey && tablero.devuelvePieza(movimiento.getPosFinal()) instanceof Torre) {
                    tablero.enroque(pieza,movimiento);
                }
                juego.setTurno();
            }else
                System.out.println(pieza.getClass().getSimpleName() + " no puede realizar ese movimiento");
            tablero.pintarTablero();

        } while (juego.getContador() < 50);
    }
}
