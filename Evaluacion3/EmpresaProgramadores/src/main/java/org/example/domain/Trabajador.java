package EmpresaProgramadores.src.main.java.org.example.domain;

public abstract class Trabajador {
    private String nombre;
    private String apellido;
    private int añoIncorporacion;
    private String departamento;
    private int sueldo;

    public Trabajador(String nombre, String apellido, int añoIncorporacion, String departamento, int sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoIncorporacion = añoIncorporacion;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    public Trabajador() {
    }
}
