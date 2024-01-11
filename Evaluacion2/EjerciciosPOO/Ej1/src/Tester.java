import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Punto puntoA = new Punto();
        System.out.println("Introduzca la primera cooredenada");
        double coordenada1 = teclado.nextInt();
        System.out.println("Introduzca la segunda coordenada");
        double coordenada2 = teclado.nextInt();
        Punto puntoB = new Punto(coordenada1,coordenada2);
        System.out.print(puntoA.calcularDistancia(puntoA,puntoB));
        Circulo circulo = new Circulo();
        System.out.println(circulo.calcularArea());
        System.out.println(circulo.calcularPerímetro());
        System.out.println(circulo.calcularDistancia(puntoA));
        Triangulo triangulo = new Triangulo();
        System.out.println(triangulo.calcularArea());
        System.out.println(triangulo.calcularPerimetro());
        System.out.println(triangulo.calcularDistancia(new Punto()));
    }
}
