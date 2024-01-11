public class Tester {
    public static void main(String[] args) {
        Asignatura asignatura1 = new Asignatura(01);
        Asignatura asignatura2 = new Asignatura(02);
        Asignatura asignatura3 = new Asignatura(03);
        Alumno alumno = new Alumno(01,02,03);
        Profesor.ponerNotas(alumno);
        System.out.println("Asignatura 1: " + alumno.getAsignatura1().getNota());
        System.out.println("Asignatura 2: " + alumno.getAsignatura2().getNota());
        System.out.println("Asignatura 3: " + alumno.getAsignatura3().getNota());
        System.out.println(Profesor.calcularMedia(alumno));
    }
}
