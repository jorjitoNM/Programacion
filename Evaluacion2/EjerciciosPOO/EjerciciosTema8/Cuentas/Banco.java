import java.util.Arrays;

public class Banco {
    private CuentaCorriente[] cuentasC;
    private CuentaAhorro[] cuentasA;
    private int contadorC = 0;
    private int contadorA = 0;

    public Banco () {
        cuentasC = new CuentaCorriente[10];
        cuentasA = new CuentaAhorro[10];
    }
    public void crearCuentaC (Titular titular) {
        cuentasC[calcularPosicion()] = new CuentaCorriente(titular);
    }
    public void crearCuentaA (Titular titular,double saldo) {
        cuentasA[calcularPosicion()] = new CuentaAhorro(titular,saldo);
    }
    public void crearCuentaA (Titular titular,String nCuenta,double saldo) {
        cuentasA[calcularPosicion()] = new CuentaAhorro(titular,nCuenta,saldo);
    }
    private int calcularPosicion () {
        int i = 0;
        boolean exit = false;
        for (; i < cuentasC.length && !exit; i++) {
            if (cuentasC[i]!=null) {
                exit = true;
            }
        }
        return i-1;
    }
    public int buscarCuentaC (String nCuenta) {
        boolean exit = false;
        int i = 0;
        for (; i < cuentasC.length && !exit; i++) {
            if (nCuenta.equals(cuentasC[i].getnCuenta())) {
                exit = true;
            }
        }
        return (i-1);
    }
    public int buscarCuentaA (String nCuenta) {
        boolean exit = false;
        int i = 0;
        for (; i < cuentasA.length && !exit; i++) {
            if (nCuenta.equals(cuentasA[i].getnCuenta())) {
                exit = true;
            }
        }
        return (i-1);
    }
    public double getSaldo (int posicion) {
        return cuentasC[posicion].getSaldo();
    }
    public void ingreso (double cantidad, int posicion) {
        cuentasC[posicion].ingreso(cantidad);
    }
    public void retirada (double cantidad, int posicion) {
        cuentasC[posicion].retirada(cantidad);
    }
    public String toString (int posicion) {
        return String.format(cuentasC[posicion].toString());
    }

}
