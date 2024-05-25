package org.example;


import java.util.Scanner;

public class Tester {
    public static Empresa empresa;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        empresa = new Empresa();
        do {
            try {
                switch (Integer.parseInt(teclado.nextLine())) {
                    case 1:
                        System.out.println(empresa.toString());
                        break;
                    case 2:
                        nuevoCentro();
                        break;
                    case 3:
                        centrosPorAño();
                        break;
                    case 4:
                        actualizarEdadMinima();
                        break;
                    case 5:
                        actualizarDelfinario();
                        break;
                    case 6:
                        eliminarCentrosPorAño();
                        break;
                    case 7:
                        precioMedioPorProvinciaYCentro();
                        break;
                    case 8:
                        centrosPorPrecioBase();
                        break;
                    case 9:
                        exit = true;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduzca solamente numeros");
            }
        }while(!exit);
    }

    private static void centrosPorPrecioBase() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la provincia");
        System.out.println(empresa.centrosPorPrecioBase(teclado.nextLine()));
    }

    private static void precioMedioPorProvinciaYCentro() {
        Scanner teclado = new Scanner(System.in);
        boolean laborable = false;
        int edad = -1;
        System.out.println("¿Es un dia laborable?");
        if (teclado.nextLine().equalsIgnoreCase("si"))
            laborable = true;
        System.out.println("Introduzca su edad");
        try {
            edad = Integer.parseInt(teclado.nextLine());
            System.out.println(empresa.precioMedioPorProvinciaYCentro(laborable,edad));
        } catch (NumberFormatException e) {
            System.out.println("Introduzca numeros solamente");
        }
    }

    private static void eliminarCentrosPorAño() {
        Scanner teclado = new Scanner(System.in);
        int año = -1;
        System.out.println("Introduzca el año hasta el cual desea eliminar los centros de ocio");
        try {
            año = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Introduzca solamente numeros enteros");
        }
        if (empresa.eliminarCentros(año))
            System.out.println("Centros eliminados correctamente");
        else
            System.out.println("No se ha podido eliminar los centros, pruebe de nuevo");
    }

    private static void actualizarDelfinario() {
        Scanner teclado = new Scanner(System.in);
        int id = -1;
        boolean delfinario = true;
        System.out.println(empresa.toString("Zoologico"));
        System.out.println("Introduzca el id del zoologico que desea modificar");
        try {
            id = Integer.parseInt(teclado.nextLine());
            System.out.println("Introduzca 0 si quiere quitar el delfinario y 1 si, por el contrario, quiere ponerlo");
            if (Integer.parseInt(teclado.nextLine()) == 0)
                delfinario = false;
        } catch (NumberFormatException e) {
            System.out.println("Introduzca solamente numeros enteros");
        }
        if (empresa.setDelfinario(id,delfinario))
            System.out.println("Cambio realizado con exito");
        else
            System.out.println("Ha surgido un problema al modificar la informacion de su zoologico");
    }

    private static void actualizarEdadMinima() {
        Scanner teclado = new Scanner(System.in);
        int id = -1;
        int edadMinima = -1;
        System.out.println(empresa.toString("ParqueAtracciones"));
        System.out.println("Introduzca el id del centro que desea modificar");
        try {
            id = Integer.parseInt(teclado.nextLine());
            System.out.println("Introduzca la nueva edad minima de acceso al parque");
            edadMinima = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Introduzca solamente numeros enteros");
        }
        if (empresa.setEdadMinima(id,edadMinima))
            System.out.println("Edad minima cambiada con exito");
        else
            System.out.println("Ha surgido un problema al cambiar la edad minima del centro");
    }

    private static void centrosPorAño() {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        int añoMinimo = -1;
        int añoMaximo = -1;
        String provincia = null;
        do {
            try {
                System.out.println("Introduzca el nombre de la provincia");
                provincia = teclado.nextLine();
                System.out.println("Introduzca el año de contruccion minimo");
                añoMinimo = Integer.parseInt(teclado.nextLine());
                System.out.println("Introduzca el año maximo de contruccion");
                añoMaximo = Integer.parseInt(teclado.nextLine());
                exit = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduzca numeros enteros solamente");
            }
        }while(!exit);
        System.out.println(empresa.getCentrosPorAño(provincia,añoMinimo,añoMaximo));
    }

    private static void nuevoCentro() {
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        boolean parque = false;
        boolean delfinario = false;
        boolean pinguinos = false;
        Centro centro;
        double precio = -1;
        int añoConstruccion = -1;
        int edadMinima = -1;
        do {
            try {
                System.out.println("¿Quiere un zoo o una parque de atracciones?");
                if (teclado.nextLine().equalsIgnoreCase("Parque de atracciones"))
                    parque = true;
                System.out.println("Introduzca el nombre del centro");
                String nombre = teclado.nextLine();
                System.out.println("Introduzca el precio de la entrada del centro");
                precio = Double.parseDouble(teclado.nextLine());
                System.out.println("Introduzca la provincia a la que pertenece el centro");
                String provincia = teclado.nextLine();
                System.out.println("Introduzca el año de construccion del centro");
                añoConstruccion = Integer.parseInt(teclado.nextLine());
                if (parque) {
                    System.out.println("Introduzca la edad minima para ingresas al parque de atracciones");
                    edadMinima = Integer.parseInt(teclado.nextLine());
                } else {
                    System.out.println("¿Tiene delfinario su zoologico?");
                    if (teclado.nextLine().equalsIgnoreCase("si"))
                        delfinario = true;
                    System.out.println("¿Tiene pinguinos su zoologico?");
                    if (teclado.nextLine().equalsIgnoreCase("si"))
                        pinguinos = true;
                }
                exit = true;
                if (parque)
                    empresa.addCentro(new ParqueAtracciones(nombre,precio,provincia,añoConstruccion,edadMinima));
                else
                    empresa.addCentro(new Zoologico(nombre,precio,provincia,añoConstruccion,delfinario,pinguinos));
            } catch (NumberFormatException e) {
                System.out.println("Introduzca solamente numeros");
            }
        } while(!exit);
    }
}
