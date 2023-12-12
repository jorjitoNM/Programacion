package Bucles;

import java.io.IOException;

public class Ej31 {
    public static void main(String[] args) throws IOException {
        char letra;
        boolean exit=false;
        for (;exit=false;) {
            letra = (char)System.in.read();
            if (letra>5) {
                exit=true;
            }
        }
    }
}
