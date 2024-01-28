public class Smartphone extends Articulo {
    private int gbRAM;
    private int gbAlmacenamiento;
    private String marca;
    private String[] marcas = {"Samsung,Google,Xiaomi,Oppo,Realme,NothingPhone,Apple,One+"};
    public Smartphone (Tienda tienda) {
        super(tienda);
        gbRAM = (int) (Math.random()*4+4);
        gbAlmacenamiento = (int) (Math.random()*192+64);
        marca = marcas[(int)(Math.random()* marcas.length)];
    }
    public Smartphone (Tienda tienda,int gbRAM, int gbAlmacenamiento,String marca, double precio, String categoria) {
        super(tienda,precio,categoria);
        this.gbRAM = gbRAM;
        this.gbAlmacenamiento = gbAlmacenamiento;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
