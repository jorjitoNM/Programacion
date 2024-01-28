public class Articulo {

    //nuevo producto seria polimorfismo ?? (seria un metodo que es obligatorio tener en los hijos
    protected int id;
    private int pasillo;
    protected double precio;
    protected String categoria;
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
    }
    public Articulo (Tienda tienda,double precio) {
        this.precio = precio;
        //quiero que este contructor llame al que solo recibe tienda
    }
    public  Articulo (Tienda tienda, double precio, String categoria) {
        boolean exit = false;
        do {
            id = (int)(Math.random()*100);
            if (tienda.idUnico(id)){
                exit = true;
            }
        }while(!exit);
        this.precio = precio;
        this.categoria = categoria;
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
}
