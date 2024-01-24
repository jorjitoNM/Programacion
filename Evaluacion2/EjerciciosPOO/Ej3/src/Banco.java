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
        cuentasC[contadorC] = new CuentaCorriente(titular);
    }
    public void crearCuentaA (Titular titular,double saldo) {
        cuentasA[contadorA] = new CuentaAhorro(titular,saldo);
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
    public boolean buscarCuentaA (String nCuenta) {
        boolean exit = false;
        for (int i = 0; i < cuentasA.length && !exit; i++) {
            if (nCuenta.equals(cuentasA[i].getnCuenta())) {
                exit = true;
            }
        }
        return exit;
    }

}
