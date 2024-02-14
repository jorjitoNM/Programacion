import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombre;
        String apellidos;
        int edad;
        int respuesta;
        double saldo = 0;
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
        Banco mibanco = new Banco();
        do {
            System.out.println("Si desea abrir una cuenta corriente, pulse 1, si desea abrir una cuenta de ahorro, pulse 2, si desea salir pulse 3");
            respuesta = teclado.nextInt();
            switch (respuesta) {
                case 1: {
                    mibanco.crearCuentaC(personas1);
                    //System.out.printf("Bienvenido a su cuenta nómina\nEstos son sus datos personales:\nNombre: %s\nApellidos: %S\nNúmero de cuenta: %s\nSaldo: %.3f",nombre,apellidos,mibanco.buscarCuentaC());
                }
                case 2: {
                    System.out.println("Si quiere abrir una nueva cuenta ahorro, pulse 1, si lo que quiere es convertir su cuenta corriente en una cuenta ahorro, pulse 2");
                    respuesta = teclado.nextInt();
                    if (respuesta==1) {
                        System.out.println("Introduzca el saldo inicial que va a despositar en la cuenta:");
                        saldo = teclado.nextDouble();
                        mibanco.crearCuentaA(personas1,saldo);
                    }
                    else if (respuesta==2) {
                        System.out.println("Introduzca el número de su cuenta a corriente");
                        nCuenta = teclado.nextLine();
                        mibanco.crearCuentaA(personas1,nCuenta,mibanco.getSaldo(mibanco.buscarCuentaA(nCuenta)));
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
                    posicion = mibanco.buscarCuentaC(nCuenta);
                    if (posicion > 0) {
                        System.out.println("Intrpduzca la cantidad a ingresas (en €):");
                        saldo = teclado.nextDouble();
                        if (saldo > mibanco.getSaldo(posicion)) {
                            mibanco.ingreso(saldo,posicion);
                            System.out.printf("El ingreso se ha realizado correctamente: %f\nSu saldo restante es: %.3f",saldo,mibanco.getSaldo(posicion));
                        }
                        else {
                            System.out.println("La cantidad solicitada es superior a la disponible en la cuenta");
                        }
                    }
                }
                case 2: {
                    System.out.println("Introduzca el número de cuenta:");
                    nCuenta = teclado.nextLine();
                    posicion = mibanco.buscarCuentaC(nCuenta);
                    if (posicion>0) {
                        System.out.println("Introduzca la cantidad a retirar (en €):");
                        saldo = teclado.nextDouble();
                        if (saldo > mibanco.getSaldo(posicion)) {
                            mibanco.retirada(saldo,posicion);
                            System.out.printf("Aquí tiene la cantidad solicitada: %f\nSu saldo restante es: %.3f",saldo,mibanco.getSaldo(posicion));
                        }
                        else {
                            System.out.println("La cantidad solicitada es superior a la disponible en la cuenta");
                        }
                    }
                }
                case 3: {
                    System.out.println("Introduzca el número de cuenta:");
                    nCuenta = teclado.nextLine();
                    posicion = mibanco.buscarCuentaC(nCuenta);
                    if (posicion>0) {
                        System.out.println(mibanco.toString(posicion));
                    }
                }
            }
        }while((respuesta==1)||(respuesta==2)||(respuesta==3));
    }
}
