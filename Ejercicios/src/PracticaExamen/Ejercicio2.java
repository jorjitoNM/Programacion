package PracticaExamen;

import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        char respuesta;
        boolean digito = false;
        boolean minuscula = false;
        boolean mayuscula = false;

        do {
            System.out.println("Introduzca un carácter");
            respuesta = (char) (System.in.read());
            System.in.read();
            if (respuesta >= 48 && respuesta <= '9') {
                System.out.println("Es un dígito");
                digito = true;
            }
            else {
                if (respuesta >=  'A' && respuesta <= 'Z') {
                    System.out.println("Es una letra mayúscula que pertenece al alfabeto y su código ASCII es " + (int)respuesta);
                    mayuscula = true;
                }
                else {
                    if (respuesta >= 'a' && respuesta <= 'z') {
                        System.out.println("Es una letra minúscula que pertenece al alfabeto y su código ASCII es " + (int)respuesta);
                        minuscula = true;
                    }
                    else {
                        System.out.println("Carácter no válido, intentelo otra vez");
                    }
                }
            }
        } while (!(digito == true && mayuscula == true && minuscula == true));
    }
}
