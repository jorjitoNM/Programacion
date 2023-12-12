package Arrays;

public class Ej7 {
    public static void main(String[] args) {
        int numeros [] = new int [30];
        int pares = 0;
        int impares = 0;
        int nulos = 0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*21-10);
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==0) {
                nulos++;
            }
            else {
                if (numeros[i]%2==0) {
                        pares++;
                    }
                    else {
                        impares++;
                    }
            }

            }
        System.out.printf("%nNulos: %d, pares: %d, impares: %d",nulos,pares,impares);
        }

    }
