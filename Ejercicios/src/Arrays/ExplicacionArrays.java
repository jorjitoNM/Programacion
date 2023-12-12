package Arrays;

public class ExplicacionArrays {
    public static void main(String[] args) {
        int caloriasMes [][] = new int [4][5];

        for (int i = 0; i < caloriasMes.length; i++) {
            for (int j = 0; j < caloriasMes[i].length; j++) {
                caloriasMes[i][j] = (int)(Math.random()*2500+1500);
            }
        }
        for (int i = 0; i < caloriasMes.length; i++) {
            System.out.printf("\n Semana %d: ",i);
            for (int j = 0; j < caloriasMes[i].length; j++) {
                System.out.print(caloriasMes[i][j] + " ");
            }
        }

    }
}
