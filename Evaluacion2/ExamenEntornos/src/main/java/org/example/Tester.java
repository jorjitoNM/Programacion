package org.example;

public class Tester {
    public static void main(String[] args) {
        boolean festivo = false;
        int edad = 20;
        Empresa empresa = new Empresa(10);
        System.out.println(empresa.calcularPrecioMedio(festivo,edad));
    }
}
