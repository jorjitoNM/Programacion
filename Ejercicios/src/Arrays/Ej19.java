package Arrays;

public class Ej19 {
    public static void main(String[] args) {
        char[][] palabras = new char[2][20];
        int[] contadorpalabras = new int[6];
        int contador = 0;

        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras[i].length; j++) {
                palabras[i][j] = (char)(Math.random()*26+65);
              //  System.out.print(palabras[i][j]);
            }
          //  System.out.println();
        }

        for (int i = 0; i < 5; i++) {
                 palabras[(int)(Math.random()*palabras.length)][(int)(Math.random()*palabras[0].length)]=32;
        }
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras[i].length; j++) {
                System.out.print(palabras[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < palabras.length; i++) {
            contador = 0;
            for (int j = 0; j < palabras[i].length; j++) {
                if ((palabras[i][j]!=32)) {
                    contador++;
                }
                else {
                    if (contador<6) {
                        contadorpalabras[contador-1]++;
                        contador = 0;
                    }
                    else {
                        contadorpalabras[5]++;
                        contador = 0;
                    }
                }
                if ((j == palabras[i].length-1)&&(contador!=0)) {
                    if (contador<6) {
                        contadorpalabras[contador-1]++;
                        contador = 0;
                    }
                    else {
                        contadorpalabras[5]++;
                        contador = 0;
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < contadorpalabras.length; i++) {
            System.out.print(contadorpalabras[i]+" ");
        }
    }
}
