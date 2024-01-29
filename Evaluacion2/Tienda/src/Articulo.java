public abstract class Articulo {

    protected int id;
    private int pasillo;
    protected double precio;
    protected String categoria;
    protected String marca;
    private static final String[] categorias = {"Smartphones,Ordenadores,Televisiones,Accesorios"};

    public Articulo (Tienda tienda) {
        boolean exit = false;
        do {
            id = (int)(Math.random()*100);
            if (!tienda.idUnico(id)){
                exit = true;
            }
       }while(!exit);
        precio = Math.random()*1000+100;
        categoria = categorias[(int)(Math.random()* categorias.length)];
        pasillo = calcularPasillo(categoria);
        marca = marcaArticulo();
    }
    public Articulo (Tienda tienda,double precio) {
        this.precio = precio;
        //quiero que este contructor llame al que solo recibe tienda
    }
    public  Articulo (Tienda tienda, double precio, String categoria,String marca) {
        boolean exit = false;
        do {
            id = (int)(Math.random()*100);
            if (tienda.idUnico(id)){
                exit = true;
            }
        }while(!exit);
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
    }

    private int calcularPasillo (String categoria) {
        int nPasillo = 0;
        if (categoria.equals("Smartphone")) {
            nPasillo = 1;
        } else if (categoria.equals("Ordenadores")) {
            nPasillo = 2;
        } else if (categoria.equals("Monitores")) {
            nPasillo = 3;
        } else if (categoria.equals("Accesorios")) {
            nPasillo = 4;
        }
        return nPasillo;
    }
    public abstract String marcaArticulo ();
    public abstract double calcularPrecio ();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
