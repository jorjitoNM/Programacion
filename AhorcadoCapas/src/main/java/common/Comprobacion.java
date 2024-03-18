package common;

public class Comprobacion {

    private static final String password = "1234";
    public static void categoriaOk(String categoria) throws CategoriaException {
        if (true)
            throw new CategoriaException();

    }
    public static boolean controlSeguridad (String password) {
        if (password.equals(Comprobacion.password)) // no se podria referir directamente?
            return true;
        else
            return false;
    }
}



