public class CuentaAhorro extends CuentaCorriente {
    private double interes;

    public CuentaAhorro (Titular titular, String nCuenta, double saldo, double interes) {
        super(titular,nCuenta,saldo);
        this.interes = interes;
    }
    public CuentaAhorro (Titular titular, String nCuenta, double interes) {
        super(titular,nCuenta);
        saldo = 1080;
        this.interes = interes;
    }
    public CuentaAhorro (Titular titular, String nCuenta) {
        super(titular,nCuenta);
        saldo = 1080;
        interes = 2.5;
    }
    public CuentaAhorro (Titular titular, double saldo) {
        super(titular,saldo);
    }
    public double calcularInteres ()  {
        return saldo = saldo*interes;
    }
    public double calcularInteres (double interes)  {
        return saldo = saldo*interes;
    }
    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
}
