import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        int edad = 0;
        String sexo = "Indeterminado";
        double hTrabajadas = 0;
        String direccion;
        int cPostal;
        double tarifa = 0;
        double pHora;

        System.out.println("Introduzca el nombre de su médico a domicilio");
        nombre = teclado.nextLine();
        System.out.println("Introduzca la edad de su médico a domicilio");
        edad = teclado.nextInt();
        System.out.println("Introduzca el sexo del médico a domcilio");
        sexo = teclado.nextLine();
        System.out.println("Introduzca las horas trabajadas de su médico");
        hTrabajadas = teclado.nextDouble();
        System.out.println("Introduzca la tarifa que le pagan por cada Km recorrido");
        tarifa = teclado.nextDouble();
        MedicoAsistenciaDomiciliaria medicodomiciliario = new MedicoAsistenciaDomiciliaria(nombre,edad,sexo,hTrabajadas,tarifa);
        System.out.println("Introduzca el nombre de su médico de un centro de salud");
        nombre = teclado.nextLine();
        System.out.println("Introduzca la edad de su médico del centro de salud");
        edad = teclado.nextInt();
        System.out.println("Introduzca el sexo del médico del centro de salud");
        sexo = teclado.nextLine();
        System.out.println("Introduzca las horas trabajadas del centro de salud");
        hTrabajadas = teclado.nextDouble();
        System.out.println("Introduzca el domicilio de su médico de un centro de salud");
        direccion = teclado.nextLine();
        System.out.println("Introduzca el código postal del domicilio del médico de un centro de salud");
        cPostal = teclado.nextInt();
        MedicoCentroSalud medicosaludable = new MedicoCentroSalud(nombre,edad,sexo,hTrabajadas,direccion,cPostal);
        System.out.println("Introduzca a cuanto le paga cada hora a sus médicos");
        pHora = teclado.nextDouble();
        System.out.println("Su médico a domicilio debe cobrar " + medicodomiciliario.calcularSalario(pHora));
        System.out.println("Su médico del centro de salud debe cobrar " + medicosaludable.calcularSalario(pHora));
    }
}
