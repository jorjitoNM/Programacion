package Arrays;

public class Ej6 {
    public static void main(String[] args) {
        int datos [][] = new int [10][5];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                datos[i][j] = i;
            }
        }
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                System.out.printf("%3d",datos[i][j]);
            }
            System.out.println();
        }
    }
}
