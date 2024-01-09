public class Triangulo {

    private Punto VerticeA;
    private Punto VerticeB;
    private Punto VerticeC;

    public Triangulo (Punto verticeA, Punto verticeB, Punto verticeC) {
        VerticeA = verticeA;
        VerticeB = verticeB;
        VerticeC = verticeC;
    }
    public Triangulo () {
        VerticeA = new Punto(Math.random()*11-5,Math.random()*11-5);
        VerticeB = new Punto(Math.random()*11-5,Math.random()*11-5);
        VerticeC = new Punto(Math.random()*11-5,Math.random()*11-5);
        if ()
    }
}
