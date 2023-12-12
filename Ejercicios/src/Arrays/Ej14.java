package Arrays;

public class Ej14 {
    public static void main(String[] args) {
        int numeros [] = new int [10];
        int contador [] = new int [10];
        int valor [] = new int [10];
        boolean exit = false;
        for (int i = 0; i < contador.length; i++) {
            contador[i] = 1;
        }
        for (int i = 0; i < valor.length; i++) {
            valor[i] = -6;
        }
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*11-5);
            System.out.printf("%2d ", numeros[i]);
        }
        for (int i = 0; i < numeros.length; i++) {
            valor[i] = numeros[i];
            exit=false;
            for (int j = i-1; j>=0 && exit==false; j--) {
                if (valor[i]==valor[j]) {
                    exit=true;
                    contador[i]=0;
                }
            }
            if (exit==false) {
                for (int j = i+ 1; j < numeros.length; j++) {
                    if (numeros[j]==valor[i]) {
                        contador[i]++;
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < contador.length ; i++) {
            System.out.printf("%2d ",contador[i]);
        }
        System.out.println();
        for (int i = 0; i < valor.length; i++) {
            if (contador[i]!=0) {
                System.out.printf("Hay %d %ds  ", contador[i], valor[i]);
            }
        }



    }
}
