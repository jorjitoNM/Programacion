public class CuentaCorriente {
    private Titular titular;
    private String nCuenta;
    private double saldo;

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
}
