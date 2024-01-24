public class CuentaCorriente {
    protected Titular titular;
    protected String nCuenta;
    protected double saldo;

    public CuentaCorriente (Titular titular, String nCuenta, double saldo) {
        this.titular = titular;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
    }
    public CuentaCorriente (Titular titular, String nCuenta) {
        this.titular = titular;
        this.nCuenta = nCuenta;
        saldo = 1080;
    }
    public  CuentaCorriente (Titular titular) {
        this.titular = titular;
        nCuenta = String.valueOf(Math.random()*100000);
        saldo = 0;
    }

    public CuentaCorriente(Titular titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public static boolean compararCuentas (String cuenta1,String cuenta2){
        return (cuenta1.equals(cuenta2));
    }
    public void retirada (double cantidad) {
        saldo -= cantidad;
    }
    public void ingreso (double cantidad) {
        saldo += cantidad;
    }
    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString () {
        return String.format("Numero de cuenta: %s\nSaldo: %.3f€",nCuenta,saldo);
    }
}
