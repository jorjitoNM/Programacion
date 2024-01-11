public class Vaca {
    public Vaca() {
        nombre = nombres[(int)(Math.random()*10)];
        raza = razas[(int)(Math.random()*5)];
        peso = Math.random()*201+600;
        color = colores[(int)(Math.random()*3)];
        lLeche = (int)(Math.random()*31+20);
    }
    public Vaca(String nombre) {
    }
    public Vaca(String nombre,String raza, double peso, String color, int lLeche ) {
    }

    private String nombre;
    private String raza;
    private double peso;
    private String color;
    private int lLeche;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLleche(int lLeche) {
        this.lLeche = lLeche;
    }



    public String getNombre() {
        return nombre;
    }
    public String getRaza() {
        return raza;
    }
    public double getPeso() {
        return peso;
    }
    public String getColor() {
        return color;
    }
    public int getLleche() {
        return lLeche;
    }


    private static String [] nombres = {"Clara","Tania","Candela","Olivia","Mar","Florentina","Antonia","Maria","Anais","Cayetana"};
    private static String [] razas = {"Lidia","Rubia gallega","Cachena","Avileña","Asturiana de los valles"};
    private static String [] colores = {"Marron","Negra","Blanca"};
    /*private static String combinacionColores() {
        int numero = (int)(Math.random()*3);
        StringBuilder resultado = new StringBuilder();
        if (numero==0) {
            resultado.append(colores[(int)(Math.random()*3)]);
        }
        else {
            if (numero==1) {
                resultado.append(colores[(int)(Math.random()*3)]).append(colores[(int)(Math.random()*3)]);
            }
            else {
                resultado.append(colores[(int)(Math.random()*3)]).append(colores[(int)(Math.random()*3)]);
            }
    }
    }
    */




    public String toString() {
        return String.format("Nombre: %s\nRaza: %s\nPeso: %.2f\nColor: %s\nLeche producida: %d",nombre,raza,peso,color,lLeche);
    }

}
