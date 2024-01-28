import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        double peso = 0;
        String respuesta;
        String nombre;
        int edad = 0;
        String raza;
        String color;
        int[] lLeche = new int[7];


            System.out.println("Qué animal quieres crear?");
            respuesta = teclado.nextLine();
            if (respuesta.equals("Gallina") || respuesta.equals("gallina")) {
                System.out.println("Como quieres que se llame la gallina?");
                nombre = teclado.nextLine();
                do {
                    System.out.println("Introduzca el peso de su gallina");
                    peso = teclado.nextDouble();
                }while(Gallina.controlPeso(peso));
                do {
                    System.out.println("Introduzca la edad de su gallina");
                    edad = teclado.nextInt();
                }while(Gallina.controlEdad(edad));
                Gallina animal = new Gallina(nombre,edad,peso);
            } else if (respuesta.equals("Vaca") || respuesta.equals("vaca")) {
                System.out.println("Como quieres que se llame la gallina?");
                nombre = teclado.nextLine();
                do {
                    System.out.println("Introduzca el peso de su vaca");
                    peso = teclado.nextDouble();
                }while(Vaca.controlPeso(peso));
                do {
                    System.out.println("Introduzca la edad de su vaca");
                    edad = teclado.nextInt();
                }while(Vaca.controlEdad(edad));
                System.out.println("Introduzca la raza de la vaca");
                raza = teclado.nextLine();
                System.out.println("Introduzca el color de la vaca");
                color = teclado.nextLine();
                System.out.println("Introduzca los litros de leche que ha producido la vaca durante la semana");
                for (int i = 0; i < 8; i++) {
                    lLeche[i] = teclado.nextInt();
                    System.in.read();
                }
                Vaca animal = new Vaca(nombre,edad,peso,raza,color,lLeche);
            } else if (respuesta.equals("Cerdo")||respuesta.equals("cerdo")) {
                System.out.println("Como quieres que se llame el cerdo");
                nombre = teclado.nextLine();
                do {
                    System.out.println("Introduzca el peso de su cerdo");
                    peso = teclado.nextDouble();
                }while(Cerdo.controlPeso(peso));
                do {
                    System.out.println("Introduzca la edad de su cerdo");
                    edad = teclado.nextInt();
                }while(Cerdo.controlEdad(edad));

            }
            Establo granja = new Establo();
            System.out.println(granja.mediaProduccion());
    }
}