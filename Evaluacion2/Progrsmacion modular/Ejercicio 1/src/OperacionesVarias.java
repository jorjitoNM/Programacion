public class OperacionesVarias {
    public static boolean isPrime(int x) {
        boolean primo = true;
        if (x!=2) {
            if (x % 2 == 0) {
                primo = false;
            }
            else {
                for (int i = 3; i < x/2; i++) {
                    if (x%i==0) {
                        primo = false;
                    }
                }
            }
        }
        return primo;
    }
    public static String piramide (int x) {
         StringBuilder forma = new StringBuilder();
        int y = x;
        for (int i = x; i < 3*x/2; i+=2,y++) {
            for (int k = 0; k < (3*x/2-(y)); k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("@");
            }
            System.out.println();
            forma =
        }
        String resultado = forma.toString();
        return resultado;
    }

}
