import java.util.Arrays;

public class Gallina extends Animal {
    private int [] huevosSemana;
    private static final double pesoMinimo = 3;
    private static final double pesoMaximo = 7;

    public Gallina(){
        super();
        huevosSemana = new int[7];
        for (int i = 0; i < huevosSemana.length; i++) {
            huevosSemana[i]= (int) (Math.random()*3);
        }
        peso = Math.random()*(pesoMaximo-pesoMinimo)+pesoMinimo;
    }

    public Gallina (String nombre, int edad, double peso) {
        super (nombre,edad,peso);
    }


    public void huevosDia(int dia, int huevos){
        huevosSemana[dia-1] = huevos;
    }
    public int sumaHuevos () {
        int suma = 0;
        for (int i = 0; i < huevosSemana.length; i++) {
            suma+= huevosSemana[i];
        }
        return suma;
    }

    public String toString(){
        return  super.toString()+String.format(" y pongo a la semana \n %s",sumaHuevos());
    }

    public static boolean controlPeso(double peso) {
        return (peso >= pesoMaximo);
    }
    public static boolean controlEdad (int edad) {
        return (edad >= 10);
    }
    public String calcularProduccion () {
        double media = 0;
        for (int i = 0; i < huevosSemana.length; i++) {
            media+=huevosSemana[i];
        }
        return String.format("Esta gallina ha producido %.2f huevos",media/ huevosSemana.length);
    }
}
