public abstract class Medico {
    private String nombre;
    private int edad;
    private String sexo;
    protected double hTrabajadas;


    public Medico (String nombre, int edad, String sexo, double hTrabajadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.hTrabajadas = hTrabajadas;
    }
    public Medico () {
        nombre = "Tu medico de confianza";
        edad = 35;
        sexo = "Inidentificado";
        hTrabajadas = 40;
    }


    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSalario (double salarioHora);
    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", hTrabajadas=" + hTrabajadas +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double gethTrabajadas() {
        return hTrabajadas;
    }

    public void sethTrabajadas(double hTrabajadas) {
        this.hTrabajadas = hTrabajadas;
    }
}
