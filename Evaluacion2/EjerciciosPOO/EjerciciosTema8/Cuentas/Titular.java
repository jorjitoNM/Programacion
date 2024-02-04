public class Titular {
    private String nombre;
    private String apellido;
    private int edad;
    public Titular () {
        nombre = nombres[(int) (Math.random()* nombres.length)];
        apellido = apellidos[(int) (Math.random()*apellidos.length)];
        edad = (int) (Math.random()*70+18);
    }
    public Titular (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    private String[] nombres = {"Juan,Juana,Pedro,Piedrita,Paco,Paquita"};
    private String[] apellidos = {"Del rio, Del bosque, Ramirez, Gomez, Sanchez"};

    public String toString () {
        return String.format("Cuenda de %s %s, de %d años",nombre,apellido,edad);
    }
}
