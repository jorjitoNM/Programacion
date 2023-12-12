package Arrays;

public class Ej12 {
    public static void main(String[] args) {
        int marco [][] = new int [5][15];
        for (int i = 0; i < marco.length; i++) {
            if (i==0||i==4) {
                for (int j = 0; j < marco[i].length; j++) {
                    marco[i][j] = 1;
                }
            }
            else {
                for (int j = 0; j < marco[i].length; j++) {
                    if (j==0||j==14) {
                        marco[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < marco.length; i++) {
            for (int j = 0; j < marco[i].length; j++) {
                System.out.print(marco[i][j] + " ");
            }
            System.out.println();
        }
    }
}
