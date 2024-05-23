package common;

public class Utilidades {
    private static final String password = "password";
    public static boolean controlSeguridad(String contraseña) {
        return contraseña.equals(password);
    }
    public static void validarOpcionMenuUsuario (String opcion) throws OpcionNoValidaException {
        if (opcion.equalsIgnoreCase(Constantes.COCINERO) || opcion.equalsIgnoreCase(Constantes.CAMARERO) || opcion.equalsIgnoreCase(Constantes.JEFE))
            throw new OpcionNoValidaException(Constantes.CAMARERO_CLIENTE);
    }
}
