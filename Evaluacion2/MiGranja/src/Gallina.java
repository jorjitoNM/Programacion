import java.util.Arrays;

public class Gallina {
    private String nombre;
    private int edad;
    private float peso;
    private int [] huevosSemana;
    private static final String [] nombres ={"Paco","Maksim", "Quien", "Goku", "MartiMcFly"};

    public static String getNombreAleatorio(){
    return nombres[(int)(Math.random()*nombres.length)];
    }

    public Gallina(){
        nombre = nombres[(int)(Math.random()*nombres.length)];
        edad= (int)(Math.random()*9);
        peso= (float)(Math.random()*3+1);
        huevosSemana = new int[7];
        for (int i = 0; i < huevosSemana.length; i++) {
            huevosSemana[i]= (int) (Math.random()*3);
        }
    }
    public Gallina(String nombre, int edad, float peso){
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        huevosSemana = new int[7];
    }

    public void huevosDia(int dia, int huevos){
        huevosSemana[dia-1] = huevos;

    }


    public String toString(){
        return String.format("Me llamo %s, este es mi peso %.2f, tengo %d años y pongo a la semana \n %s", nombre,peso,edad, Arrays.toString(huevosSemana));
    }

    public void setEdad(int edad) {
        this.edad= edad;
    }
    public int getEdad() {
        return edad;
    }
    public void setPeso(float peso) {
        this.peso= peso;
    }
    public float getPeso() {
        return peso;
    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
