public class Titular {
    private String nombre;
    private String apellido;
    private int edad;
    public Titular () {
        nombre = nombres[(int) (Math.random()* nombres.length)];
        apellido = apellidos[(int) (Math.random()*apellidos.length)];
        edad = (int) (Math.random()*70+18);
    }

    private String[] nombres = {"Juan,Juana,Pedro,Piedrita,Paco,Paquita"};
    private String[] apellidos = {"Del rio, Del bosque, Ramirez, Gomez, Sanchez"};
}
