public class Asignatura {
    private int id;
    private double Nota;

    public Asignatura (int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public double getNota() {
        return Nota;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setNota(double nota) {
        Nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", Nota=" + Nota +
                '}';
    }
}
