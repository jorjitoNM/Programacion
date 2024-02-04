public class MedicoAsistenciaDomiciliaria extends Medico {
    private double[] kmVisitas = new double[7];
    private double tarifaKm;


    public MedicoAsistenciaDomiciliaria (String nombre, int edad, String sexo, double hTrabajadas, double tarifaKm){
        super(nombre,edad,sexo,hTrabajadas);
        for (int i = 0; i < kmVisitas.length; i++) {
            kmVisitas[i] = Math.random()*50+10;
        }
        this.tarifaKm = tarifaKm;
    }


    public  double calcularSalario (double salarioBaseHora) {
        double extras = 0;
        for (int i = 0; i < kmVisitas.length; i++) {
            extras += (kmVisitas[i]*tarifaKm);
        }
        return extras+(salarioBaseHora*hTrabajadas);
    }




    public double[] getKmVisitas() {
        return kmVisitas;
    }

    public void setKmVisitas(double[] kmVisitas) {
        this.kmVisitas = kmVisitas;
    }

    public double getTarifaKm() {
        return tarifaKm;
    }

    public void setTarifaKm(double tarifaKm) {
        this.tarifaKm = tarifaKm;
    }
}
