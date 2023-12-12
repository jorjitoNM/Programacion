package Arrays;

public class Ej2 {
    public static void main(String[] args) {
        int origen [] = {10,25,26,40,37,45,90,76,78,81,58,32};
        int contador = 0;
        for (int i = 0; i < origen.length ; i++) {
            if (origen[i]>25 && origen[i]%2==0) {
                contador++;
            }
        }
        int destino [] = new int [contador];
        for (int i = 0, j = 0; i < origen.length; i++) {
            if (origen[i]>25 && origen[i]%2==0) {
                destino[j] = origen[i];
                j++;
            }
        }
        for (int i=0;i< origen.length;i++) {
            System.out.print(origen[i] + " ");
        }
        System.out.println();
        for (int i=0;i< destino.length;i++) {
            System.out.print(destino[i] + " ");
        }
    }
}
