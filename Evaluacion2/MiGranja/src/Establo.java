public class Establo {
    private Vaca [] misvacas;

    public Establo() {
        this.misvacas = new Vaca[10];
        for (int i = 0; i < misvacas.length; i++) {
            misvacas[i] = new Vaca();
        }
    }
    public String toString() {
        String resultado;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < misvacas.length; i++) {
            builder.append(misvacas[i]).append("\n----------------------------------\n");
        }
        resultado = builder.toString();
        return resultado;
    }
}
