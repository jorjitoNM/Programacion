package common;

public class Utilidades {
    private static final String password = "password";
    public static boolean controlSeguridad(String contraseña) {
        return contraseña.equals(password);
    }
}
