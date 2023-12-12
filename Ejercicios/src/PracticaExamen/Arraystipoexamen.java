package PracticaExamen;

public class Arraystipoexamen {
    public static void main(String[] args) {
        double[][] clientes = new double[10][7];
        double media = 0;
        String[] orden = {"Juan","Juana","Mario","Maria","Luis","Luisa","Antonio","Antonia","Victor","Victoria"};
        String auxs;
        double aux;
        double[] medias = new double[10];
        boolean cambio = true;
        String[] semana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        System.out.println(clientes.length);
        System.out.println(clientes[0].length);
        for (int i = 0; i < clientes.length; i++) {
            System.out.printf("%s: ",orden[i]);
            for (int j = 0; j < clientes[i].length; j++) {
                clientes[i][j] = Math.random()*196+5;
                System.out.printf("%6.2f ", clientes[i][j]);
            }
            System.out.println();
        }
        System.out.println("Los gastos medios en mercadona por cada día han sido:");
        for (int i = 0; i < clientes[i].length; i++) {
            for (int j = 0; j < clientes.length; j++) {
                media+=clientes[j][i];
            }
            System.out.printf("-El %s se gastaron %.2f€ de media en Mercadona\n",semana[i], media/10);
            media = 0;
        }
        System.out.println("Los tres usuarios que más dinero han gastado en Mercadona durante esta semana han sido:");
        for (int i = 0; i < clientes.length; i++) {
            for (int j = 0; j < clientes[i].length; j++) {
                medias[i]+=clientes[i][j];
                System.out.printf("%.2f ",medias[i]);
            }
            System.out.println();
        }
        for (int i = 0; cambio==true; i++) {
            cambio = false;
            for (int j = 0; j < medias.length-1; j++) {
                if (medias[j]>medias[j+1]) {
                    aux = medias[j];
                    medias[j] = medias[j+1];
                    medias[j+1] = aux;
                    auxs = orden[j];
                    orden[j] = orden[j+1];
                    orden[j+1] = auxs;
                    cambio = true;
                }
            }
        }
        for (int i = medias.length-1; i >medias.length-4 ; i--) {
            System.out.printf("El numero %d ha sido %s, con %.2f€ gastados\n",10-i,orden[i],medias[i]);
        }
        System.out.printf("El cliente que menos ha gastado ha sido %s, con una media de %.2f€ y el cliente que más ha gastado ha sido %s, con una media de %.2f. La diferencia de dinero entre ellos ha sido de %.2f€",orden[0],medias[0],orden[9],medias[9],(medias[9]-medias[0]));
    }
}
