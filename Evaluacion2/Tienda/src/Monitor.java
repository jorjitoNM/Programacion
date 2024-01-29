public class Monitor extends Articulo {
    private String panel;
    private int resolucion;
    private int hz;
    private double pulgadas;
    private String[] paneles = {"IPS,VA,OLED,TN,nanoIPS,AMOLED"};


    public Monitor (Tienda tienda) {
        super(tienda);
        panel = paneles[(int) (Math.random() * paneles.length)];
        resolucion = (int) (Math.random() *1440+720);
        hz = (int) (Math.random() *180+60);
        pulgadas = Math.random()*25+24;
    }
    public Monitor (Tienda tienda, double precio, String categoria,String marca, String panel,int resolucion,int hz, double pulgadas) {
        super(tienda,precio,categoria,marca);
        this.panel = panel;
        this.resolucion = resolucion;
        this.hz = hz;
        this.pulgadas = pulgadas;
    }
    public double calcularPrecio () {
        double precio = 0;
        if (panel.equals("OLED")) {
            precio += 500;
        }
        else {
            precio += 100;
        }
        precio += (double) (5 * hz) /10;
        precio += (double) (20 * resolucion) /100;
        precio += 25 * pulgadas /10;
        return precio;
    }

    public String marcaArticulo (){
        return Utilidades.marcasM[(int)(Math.random()*Utilidades.marcasM.length)];
    }



}
