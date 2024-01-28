public class Establo {
    private Animal [] misanimales;


    public Establo () {
        misanimales = new Animal[10];
    }
    /*public Establo() {
        this.misanimales = new Animal[10];
        int opcion;
        for (int i = 0; i < misanimales.length; i++) {
            opcion = (int)(Math.random()*3+1);
            if (opcion==1) {
                misanimales[i] = new Vaca();
            } else if (opcion==2) {
                misanimales[i] = new Gallina();
            }
            else {
                misanimales[i] = new Cerdo();
            }
        }
    }*/
    public Establo (Vaca vaca1,Cerdo cerdo1,Gallina gallina1,Vaca vaca2,Cerdo cerdo2,Gallina gallina2) {
        this.misanimales = new Animal[6];
        misanimales[0] = vaca1;
        misanimales[1] = cerdo1;
        misanimales[2] = gallina1;
        misanimales[3] = vaca2;
        misanimales[4] = cerdo2;
        misanimales[5] = gallina2;
    }


    public boolean nuevoAnimal (Animal animal) {
        boolean exit = false;
        for (int i = 0; i < misanimales.length && !exit; i++) {
            if (misanimales[i]== null) {
                misanimales[i] = animal;
                exit = true;
            }
        }
        return exit;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < misanimales.length; i++) {
            builder.append(misanimales[i]).append("\n----------------------------------\n");
        }
        return builder.toString();
    }

    public Animal[] getMisanimales() {
        return misanimales;
    }

    public void setMisanimales(Animal[] misanimales) {
        this.misanimales = misanimales;
    }
    public String mediaProduccion () {
        StringBuilder media = new StringBuilder();
        for (int i = 0; i < misanimales.length; i++) {
            media.append(misanimales[i].calcularProduccion()).append("\n");
        }
        return media.toString();
    }
    //if (misanimales[i] instanceof Gallina)
}
