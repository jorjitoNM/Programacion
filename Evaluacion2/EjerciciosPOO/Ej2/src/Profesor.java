public class Profesor {
    public static void ponerNotas (Alumno alumno) {
        alumno.getAsignatura1().setNota(Math.random()*10+1);
        alumno.getAsignatura2().setNota(Math.random()*10+1);
        alumno.getAsignatura3().setNota(Math.random()*10+1);
    }
    public static double calcularMedia (Alumno alumno) {
        return (alumno.getAsignatura1().getNota()+alumno.getAsignatura2().getNota()+alumno.getAsignatura3().getNota())/3;
    }


}