package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Empresa {
    private Centro[] centros;
    public static final String[] provincias = {"Madrid","Barcelona","Valencia","Malaga"};


    public Empresa () {
        centros = new Centro[10];
        for (int i = 0; i < centros.length; i++) {
            if (Math.random()>0.5)
                centros[i] = new ParqueAtracciones();
            else
                centros[i] = new Zoologico();
        }
    }
    public Empresa (int numeroCentros) {
        centros = new Centro[numeroCentros];
        for (int i = 0; i < centros.length; i++) {
            if (Math.random()>0.5)
                centros[i] = new ParqueAtracciones();
            else
                centros[i] = new Zoologico();
        }
    }

    public String calcularPrecioMedio(boolean festivo, int edad) {
        //Empresa empresa = new Empresa((int)(Math.random()*4+4));
        Empresa empresa = new Empresa(10);
        double contadorMadrid = 0;
        int centrosMadrid = 0;
        double contadorBarcelona = 0;
        int centrosBarcelona = 0;
        double contadorValencia = 0;
        int centrosValencia = 0;
        double contadorMalaga = 0;
        int centrosMalaga = 0;
        double contador2Madrid = 0;
        int centros2Madrid = 0;
        double contador2Barcelona = 0;
        int centros2Barcelona = 0;
        double contador2Valencia = 0;
        int centros2Valencia = 0;
        double contador2Malaga = 0;
        int centros2Malaga = 0;
        for (int i = 0; i < empresa.getCentros().length; i++) {
            if (centros[i] instanceof ParqueAtracciones) {
                if (centros[i].getProvincia().equalsIgnoreCase("Madrid")) {
                    contadorMadrid += centros[i].calcularPrecio(festivo, edad);
                    centrosMadrid++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Barcelona")) {
                    contadorBarcelona += centros[i].calcularPrecio(festivo, edad);
                    centrosBarcelona++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Valencia")) {
                    contadorValencia += centros[i].calcularPrecio(festivo, edad);
                    centrosValencia++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Malaga")) {
                    contadorMalaga += centros[i].calcularPrecio(festivo, edad);
                    centrosMalaga++;
                }
            }
            else {
                if (centros[i].getProvincia().equalsIgnoreCase("Madrid")) {
                    contador2Madrid += centros[i].calcularPrecio(festivo, edad);
                    centros2Madrid++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Barcelona")) {
                    contador2Barcelona += centros[i].calcularPrecio(festivo, edad);
                    centros2Barcelona++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Valencia")) {
                    contador2Valencia += centros[i].calcularPrecio(festivo, edad);
                    centros2Valencia++;
                } else if (centros[i].getProvincia().equalsIgnoreCase("Malaga")) {
                    contador2Malaga += centros[i].calcularPrecio(festivo, edad);
                    centros2Malaga++;
                }
            }
        }
        StringBuilder provincias = new StringBuilder();
        provincias.append("Parques de atracciones:\n");
        if (centrosMadrid>0) {
            provincias.append(String.format("El precio medio en Madrid es de %.2f€\n",contadorMadrid/centrosMadrid));
        } if (centrosBarcelona>0) {
            provincias.append(  String.format("El precio medio en Barcelona es de %.2f€\n",contadorBarcelona / centrosBarcelona));
        } if (centrosValencia>0) {
            provincias.append(String.format("El precio medio en Valencia es de %.2f€\n",contadorValencia/centrosValencia));
        } if (centrosMalaga>0) {
            provincias.append(String.format("El precio medio en Malaga es de %.2f€\n",contadorMalaga/centrosMalaga));
        }
        provincias.append("Zoologicos:\n");
            if (centros2Madrid>0) {
                provincias.append(String.format("El precio medio en Madrid es de %.2f€\n",contadorMadrid/centros2Madrid));
            } if (centros2Barcelona>0) {
                provincias.append(  String.format("El precio medio en Barcelona es de %.2f€\n",contadorBarcelona / centros2Barcelona));
            } if (centros2Valencia>0) {
                provincias.append(String.format("El precio medio en Valencia es de %.2f€\n",contadorValencia/centros2Valencia));
            } if (centros2Malaga>0) {
                provincias.append(String.format("El precio medio en Malaga es de %.2f€",contadorMalaga/centros2Malaga));
            }
        return provincias.toString();
    }
    public Centro[] getCentros() {
        return centros;
    }

    public void setCentros(Centro[] centros) {
        this.centros = centros;
    }
    /*public static String[] sacarProvincias() {
        return Arrays.toString(provincias[]);
    }*/
    public static String devuelveProvincia () {
        return provincias[(int)(Math.random()* provincias.length)];
    }
}
