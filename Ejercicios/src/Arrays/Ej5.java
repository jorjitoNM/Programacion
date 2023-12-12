package Arrays;

public class Ej5 {
    public static void main(String[] args) {
        int diagonal [][] = new int [5][5];
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal.length; j++) {
                if (i==j) {
                    diagonal[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal.length; j++) {
                System.out.printf("%3d",diagonal[i][j]);
            }
            System.out.println();
        }
    }
}
