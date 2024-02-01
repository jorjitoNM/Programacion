public class Smartphone extends Articulo {
    private int gbRAM;
    private int gbAlmacenamiento;



    public Smartphone (Tienda tienda) {
        super(tienda);
        gbRAM = (int) (Math.random()*4+4);
        gbAlmacenamiento = (int) (Math.random()*192+64);
    }
    public Smartphone (Tienda tienda,String marca,int gbRAM,int gbAlmacenamiento,double precio,String categoria) {
        super(tienda,precio,categoria,marca);
        this.gbRAM = gbRAM;
        this.gbAlmacenamiento = gbAlmacenamiento;
    }


    public String marcaArticulo (){
        return Utilidades.marcasS[(int)(Math.random()*Utilidades.marcasS.length)];
    }
    public double calcularPrecio () {
        double precio = 0;
        if (marca.equalsIgnoreCase("iPhone")) {
            precio = 1099;
            if (gbRAM>6) {
                precio += 250;
            } else if (gbAlmacenamiento>128) {
                precio += 250;
            }
        }
        else {
            precio = 50*gbRAM;
            precio += (double) (20*gbAlmacenamiento)/32;
        }
        return precio;
    }


    public int getGbRAM() {
        return gbRAM;
    }

    public void setGbRAM(int gbRAM) {
        this.gbRAM = gbRAM;
    }

    public int getGbAlmacenamiento() {
        return gbAlmacenamiento;
    }

    public void setGbAlmacenamiento(int gbAlmacenamiento) {
        this.gbAlmacenamiento = gbAlmacenamiento;
    }
}
