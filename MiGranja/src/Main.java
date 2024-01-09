import java.util.Scanner;
/*
1. Implementar otra clase de un animal. Ejemplo: Cerdo, Oveja, Vaca, Caballo, etc..
2. Array de Gallinas
 */
public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        /*
        Gallina random = new Gallina();
        System.out.println("Introduce nombre, edad y peso");
        String nombre = lector.nextLine();
        int edad = lector.nextInt();
        float peso = lector.nextFloat();
        Gallina especial= new Gallina(nombre, edad, peso);
        System.out.println(random.toString());
        System.out.println(especial.toString());
        System.out.println("Después de un año....");
        random.setEdad(random.getEdad()+1);
        random.setPeso(random.getPeso()+0.5f);
        especial.setEdad(especial.getEdad()+1);
        especial.setPeso(especial.getPeso()+0.75f);
        System.out.println(random.getPeso());
        System.out.println(especial.getPeso());
        especial.huevosDia(2,3);
        System.out.println(especial);
        */

        String nombre;
        String raza;
        String color;
        int lLeche;
        double peso;

        Vaca vacarandom = new Vaca();

        System.out.println("Introduce el nombre de tu vaca");
        nombre = teclado.nextLine();
        Vaca vacaname = new Vaca(nombre);

        System.out.println("Introduce el nombre de tu vaca");
        nombre = teclado.nextLine();
        System.out.println("Introduce su raza");
        raza = teclado.nextLine();
        System.out.println("Introduce su peso (Kg)");
        peso = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("Introduce el color de la vaca");
        color = teclado.nextLine();
        System.out.println("Introduce los litros de leche que produce (L/día)");
        lLeche = teclado.nextInt();
        Vaca vacapersonalizada = new Vaca(nombre,raza,peso,color,lLeche);
        System.out.println(vacapersonalizada.toString());

        Establo vacas = new Establo();
        System.out.println("Vamos a ver que vacas tenemos en el establo:");
        System.out.println(vacas.toString());


    }
}