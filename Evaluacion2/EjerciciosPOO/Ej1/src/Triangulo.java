public class Triangulo {

    private Punto verticeA;
    private Punto verticeB;
    private Punto verticeC;

    public static boolean isTriangle (Punto verticeA,Punto verticeB, Punto verticeC) {
        boolean exit = true;
        if (verticeA.calcularDistancia(verticeA,verticeB)%verticeC.calcularDistancia(verticeA,verticeC)==0) {
            exit = false;
        }
        return exit;
    }
    public static boolean isTriangle2 (Punto verticeA,Punto verticeB, Punto verticeC) {
        return verticeA.calcularDistancia(verticeA, verticeB) % verticeC.calcularDistancia(verticeA, verticeC) != 0;
    }
    public Triangulo (Punto verticeA, Punto verticeB, Punto verticeC) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.verticeC = verticeC;
    }
    public Triangulo () {
        boolean exit = false;
        do {
            exit = true;
            verticeA = new Punto(Math.random()*11-5,Math.random()*11-5);
            verticeB = new Punto(Math.random()*11-5,Math.random()*11-5);
            verticeC = new Punto(Math.random()*11-5,Math.random()*11-5);
            if (isTriangle(verticeA, verticeB, verticeC)) {
                exit = false;
            }
        }while(!exit);

    }
    public Punto getVerticeA () {
        return verticeA;
    }
    public Punto getVerticeB () {
        return verticeB;
    }
    public Punto getVerticeC () {
        return verticeC;
    }
    public void setVerticeA (Punto coordenada) {
        verticeA = coordenada;
    }
    public void setVerticeB (Punto coordenada) {
        verticeB = coordenada;
    }
    public void setVerticeC (Punto coordenada) {
        verticeC = coordenada;
    }
    public double calcularDistancia (Punto coordenada) {
        return Math.abs(coordenada.calcularDistancia(coordenada, verticeA));
    }
    public double calcularArea () {
        double semi;
        semi = (verticeA.calcularDistancia(verticeA,verticeB)+verticeA.calcularDistancia(verticeB,verticeC)+verticeA.calcularDistancia(verticeA,verticeC))/2;
        return Math.sqrt(semi*(semi-verticeA.calcularDistancia(verticeA,verticeB))*(semi-verticeA.calcularDistancia(verticeB,verticeC))*(semi-verticeA.calcularDistancia(verticeA,verticeC)));
    }
    public double calcularPerimetro () {
        return verticeA.calcularDistancia(verticeA,verticeB)+verticeA.calcularDistancia(verticeB,verticeC)+verticeA.calcularDistancia(verticeA,verticeC);
    }

}
