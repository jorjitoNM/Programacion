public class MedicoCentroSalud extends Medico {
    private int id;
    private String nombre;
    private String domicilio;
    private int cPostal;


    public MedicoCentroSalud (String nombre,int edad, String sexo, double hTrabajadas,int id, String domicilio, int cPostal) {
        super(nombre,edad,sexo,hTrabajadas);
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cPostal = cPostal;
    }
    public MedicoCentroSalud () {
        super();
        id = (int)(Math.random()*100);
        nombre = "El médico";
        domicilio = "C/ de Severo Ochoa Nº17";
        cPostal = 28200;
    }
    public MedicoCentroSalud (String nombre,int edad, String sexo, double hTrabajadas,String domicilio, int cPostal) {
        super(nombre,edad,sexo,hTrabajadas);
        id = (int)(Math.random()*100);
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cPostal = cPostal;
    }


    public double calcularSalario (double salarioHora) {
        return hTrabajadas*salarioHora;
    }



    @Override
    public String toString() {
        return "MedicoCentroSalud{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cPostal=" + cPostal +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getcPostal() {
        return cPostal;
    }

    public void setcPostal(int cPostal) {
        this.cPostal = cPostal;
    }
}
