public class Alumno {
    private Asignatura asignatura1;
    private Asignatura asignatura2;
    private Asignatura asignatura3;

    public Alumno (Asignatura asignatura1,Asignatura asignatura2,Asignatura asignatura3) {
        this.asignatura1 = asignatura1;
        this.asignatura2 = asignatura2;
        this.asignatura3 = asignatura3;
    }
    public Alumno (int id1, int id2, int id3) {
        asignatura1 = new Asignatura(id1);
        asignatura2 = new Asignatura(id2);
        asignatura3 = new Asignatura(id3);
    }

    public Asignatura getAsignatura1() {
        return asignatura1;
    }

    public Asignatura getAsignatura2() {
        return asignatura2;
    }

    public Asignatura getAsignatura3() {
        return asignatura3;
    }

    public void setAsignatura1(Asignatura asignatura1) {
        this.asignatura1 = asignatura1;
    }

    public void setAsignatura2(Asignatura asignatura2) {
        this.asignatura2 = asignatura2;
    }

    public void setAsignatura3(Asignatura asignatura3) {
        this.asignatura3 = asignatura3;
    }
    public String toString () {
        return String.format("Asignatura 1: %s\nAsignatura 2: %s\nAsignatura 3: %s\nMedia final: %s",asignatura1,asignatura2,asignatura3,Profesor.calcularMedia(this));
    }
}
