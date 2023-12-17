import java.lang.reflect.Array;

public class OperacionesString {

    public static String letra (String x, String y) {
        String resultado = new String();
        return  resultado.concat(String.valueOf(x.charAt(0))).concat(String.valueOf(y.charAt(0)));
    }
    public static String concatenacion (String x, String y) {
        String resultado = x.concat(y).toUpperCase();
        return resultado;
    }
    public static int palabras (String x) {
        String [] trozos = x.split(" ");
        return trozos.length;
    }
    public static void cambio {

    }
}
