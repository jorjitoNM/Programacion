import java.util.Scanner;

public class Out {
    Scanner teclado = new Scanner(System.in);

    /**
     * Metodo que pregunta al usuario a que pieza quiere promocionar
     * @param tablero El tablero de juego
     * @param pieza La pieza que ha coronado (tiene que ser un Peon)
     * @param movimiento El movimiento que ha realizado el peon
     */
    public void coronacion (Tablero tablero, Pieza pieza, Movimiento movimiento) {
        String coronacion;
        boolean exit = false;
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
                    tablero.moverPieza(pieza, movimiento);
            } while (!exit);
    }
}
