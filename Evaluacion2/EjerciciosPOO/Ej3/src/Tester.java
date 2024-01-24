import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombre;
        String apellidos;
        int edad;
        int respuesta;
        double saldo;
        String nCuenta;
        CuentaCorriente cuentaC1;
        int posicion;

        System.out.println("Introduzca su nombre");
        nombre = teclado.nextLine();
        System.out.println("Intrpduzca sus apellidos");
        apellidos = teclado.nextLine();
        System.out.println("Introduzca su edad");
        edad = teclado.nextInt();
        System.out.printf("Bienvenido a su banco, %s",nombre);
        Titular personas1 = new Titular(nombre,apellidos,edad);
        cuentaC1 = new CuentaCorriente(personas1);
        CuentaAhorro cuentaA1;
        CuentaAhorro cuentaA2;
        Banco mibanco = new Banco();
        do {
            System.out.println("Si desea abrir una cuenta corriente, pulse 1, si desea abrir una cuenta de ahorro, pulse 2, si desea salir pulse 3");
            respuesta = teclado.nextInt();
            switch (respuesta) {
                case 1: {
                    cuentaC1 = new CuentaCorriente(personas1);
                    System.out.printf("Bienvenido a su cuenta nómina\nEstos son sus datos personales:\nNombre: %s\nApellidos: %S\nNúmero de cuenta: %s\nSaldo: %.3f",nombre,apellidos, cuentaC1.getnCuenta(),cuentaC1.getSaldo());
                }
                case 2: {
                    System.out.println("Si quiere abrir una nueva cuenta ahorro, pulse 1, si lo que quiere es convertir su cuenta corriente en una cuenta ahorro, pulse 2");
                    respuesta = teclado.nextInt();
                    if (respuesta==1) {
                        System.out.println("Introduzca el saldo inicial que va a despositar en la cuenta:");
                        saldo = teclado.nextDouble();
                        cuentaA1 = new CuentaAhorro(personas1,saldo);
                    }
                    else if (respuesta==2) {
                        System.out.println("Introduzca el número de su cuenta a corriente");
                        nCuenta = teclado.nextLine();
                        cuentaA2 = new CuentaAhorro(personas1,cuentaC1.getnCuenta());
                    }
                    else {
                        System.out.println("Introduzca una carácter válido");
                    }
                }
                case 3: {
                    System.out.println("Hasta luego, vuelva pronto");
                }
                default: System.out.println("Introduzca un caráter válido");
            }
        }while (respuesta!=3);
        do {
            System.out.println("Si quiere hacer un ingreso en su cuenta, pulse 1, si quiere sacar dinero de si cuenta, pulse 2, si lo que quiere es ver el estado de tu cuenta, pulsa 3 si se trata de una cuenta corriente, y 4 si se trata de una cuenta ahorro");
            respuesta = teclado.nextInt();
            switch (respuesta) {
                case 1: {
                    System.out.println("Introduzca el número de cuenta:");
                    nCuenta = teclado.nextLine();
                    System.out.println("Intrpduzca la cantidad a ingresas (en €):");
                    saldo = teclado.nextDouble();
                    cuentaC1.ingreso(saldo);
                    System.out.println("El ingreso se ha realizado correctamente");
                }
                case 2: {
                    System.out.println("Introduzca el número de cuenta:");
                    nCuenta = teclado.nextLine();
                    posicion = mibanco.buscarCuentaC(nCuenta);
                    if (posicion<0) {
                        System.out.println("Introduzca la cantidad a retirar (en €):");
                        saldo = teclado.nextDouble();

                        //como hago para ingresas¡r en una cuenta, tengo que implementar el metodo ingresar en banco para poder acceder directamente a la cuenta que se correrponde??
                    }

                    cuentaC1.ingreso(saldo);
                    System.out.println("Aquí tiene la cantidad solicitada");
                }
                case 3: {
                    System.out.println("Introduzca el número de cuenta:");
                    nCuenta = teclado.nextLine();

                }
            }
        }while((respuesta==1)||(respuesta==2)||(respuesta==3));
    }
}
