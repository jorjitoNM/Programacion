public class Cerdo {
    private double peso;
    private String nombre;
    private static final String[] nombres = {"Marc","Maria","Angel","Jimena","Herminio","Liliana"};
    private String pureza;
    private static final String[] purezas = {"25% Ibérico","50% Ibérico","75% Ibérico","100% Ibérico"};
    private String alimentacion;
    private int edad;

    public Cerdo () {
        peso = Math.random()*201+200;
        nombre = nombres[(int)(Math.random()*nombres.length-1)];
        pureza = purezas[(int)(Math.random()*purezas.length-1)];
    }
}
