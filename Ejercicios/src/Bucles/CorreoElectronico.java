import java.io.IOException;
import java.util.Scanner;

public class CorreoElectronico {
    public static void main(String[] args) throws IOException {
        int opcion = 0;
        boolean exit = false;
        char respuesta = 0;
        int contadorspam = 0;
        char[][] spam = new char[5][50];
        boolean exitrecibidos = false;
        char[][] correo = new char[10][100];
        boolean[] leidos = new boolean[10];
        char[] usuario = new char[15];
        char[] contrasena = new char[15];
        char[] spamcontrasena = new char[15];
        boolean contrasenaspam = false;
        char respuestawrite;
        boolean exitwrite = false;
        int contadorcorreo = 0;
        char respuestaspam;
        boolean exitspam = false;
        boolean[] spamleidos = new boolean[5];
        char[] correogmail = new char[10];
        char[] correoeducamadrid = new char[17];
        boolean dominio = true;
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < leidos.length; i++) {
            leidos[i] = false;
        }
        for (int i = 0; i < spamleidos.length; i++) {
            spamleidos[i] = false;
        }
        for (int i = 0; i < spam.length; i++) {
            for (int j = 0; j < spam[i].length; j++) {
                spam[i][j] = (char)(Math.random()*222+30);
            }
        }
        for (int i = 0; i < spam.length; i++) {
            for (int j = 0; j < spam[i].length; j++) {
                System.out.print(spam[i][j]);
            }
            System.out.println();
        }
        System.out.println("Introduzca el nombre de usuario");
        for (int i = 0; i < usuario.length && usuario[i]!=10; ) {
            usuario[i] = (char) System.in.read();
            if (usuario[i]!=10) {
                i++;
            }
        }
        System.out.println("Introduzca su contraseña");
        for (int i = 0; i < contrasena.length && contrasena[i]!=10;) {
            contrasena[i] = (char) System.in.read();
            if (contrasena[i]!=10) {
                i++;
            }
        }
        do {
            System.out.println("¿Qúe quiere hacer?: \n- Mensajes recibidos (pulsando 1)\n- Spam (pulsando 2)\n- Redactar (pulsando 3)\n- Cerrar (pulsando 4)");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nBienvenido a su bandeja de recibidos\n<--><--><--><--><--><--><--><--><-->");
                    do {
                        System.out.println("Tiene " + contadorcorreo + " correos sin leer desde la última sesión:\nIntroduzca 'S' para leerelos o 'L' si quiere acceder a los correos recibidos ya leídos. Si lo que quiere es volver al menu principal introduzca 'E'");
                        respuesta = (char) System.in.read();
                        if (respuesta == 'S' || respuesta == 's') {
                            int i = 0, contador = 0, j = 0;
                            for (; i < correo.length; i++) {
                                if (leidos[i] == false && correo[i][j]!= 0) {
                                    for (; j < correo[i].length && correo[i][j] != 0; j++) {
                                        System.out.print(correo[i][j]);
                                    }
                                    leidos[i] = true;
                                    contador++;
                                }
                            }
                            System.out.println("Ha leido " + contador + " de " + i + " correos nuevos");
                        } else {
                            if (respuesta == 'L' || respuesta == 'l') {
                                for (int i = 0; i < correo.length; i++) {
                                    if (leidos[i] == true) {
                                        for (int j = 0; j < correo[i].length && correo[i][j] != 0; j++) {
                                            System.out.print(correo[i][j]);
                                        }
                                    }
                                }
                            }
                            else {
                                if (respuesta == 'E' || respuesta == 'e') {
                                    exitrecibidos = true;
                                } else {
                                    System.out.println("La accion no se pudeo completar, pruebe con otra");
                                }
                            }
                        }
                    } while (exitrecibidos == false);
                    break;
                case 2:
                    System.out.println("Bienvenido a su bandeja de spam\n<--><--><--><--><--><--><--><--><-->");
                    do {
                        for (int i = 0; i < spamleidos.length; i++) {
                            if(spamleidos[i]==false) {
                                contadorspam++;
                            }
                        }
                        System.out.println("Tiene " + contadorspam + " mensajes nuevos en la bandeja de spam. Introduzca 'S' para leerelos. Si lo que quiere es volver al menu principal introduzca 'E'");
                        respuestaspam = (char)System.in.read();
                        if (respuestaspam=='S' || respuestaspam=='s') {
                            int i = (int) (Math.random() * 5 - 0);
                            for (int j = 0; j < spam[i].length; j++) {
                                System.out.print(spam[i][j]);
                            }
                            spamleidos[i]=true;
                        }
                        else {
                            if (respuestaspam == 'E' || respuestaspam == 'e') {
                                exitspam = true;
                            } else {
                                System.out.println("Introduzca un carácter válido");
                            }
                        }
                    } while (exitspam==false);
                    break;
                case 3:
                    do {
                        System.out.println("Por favor, introduzca su contraseña para enviar nuevos correos");
                        for (int i = 0; i < contrasena.length && spamcontrasena[i]!=10;) {
                            spamcontrasena[i] = (char) System.in.read();
                            if (spamcontrasena[i] == contrasena[i]) {
                                contrasenaspam = true;
                            } else {
                                contrasenaspam = false;
                            }
                            if (spamcontrasena[i]!=10) {
                                i++;
                            }
                        }
                        if (contrasenaspam == true) {
                            do {
                                System.out.println("Recuerde que puede volver al menu principal pulsando 'E', sino, pulse cualquier otra letra");
                                respuestawrite = (char) System.in.read();
                                if (respuestawrite == 'E' || respuestawrite == 'e') {
                                    exitwrite = true;
                                }
                                else {
                                    int i = 0;
                                    System.out.println("Destinatario:");
                                    while (i < 15 && correo[contadorcorreo][i] != 10) {
                                        correo[contadorcorreo][i] = (char) System.in.read();
                                        if (correo[contadorcorreo][i] != 10) {
                                            i++;
                                        }
                                    }
                                    for (int j = 0; j < correo[contadorcorreo][j]; j++) {
                                        if (!(correo[contadorcorreo][j]==correogmail[j] || correo[contadorcorreo][j]==correoeducamadrid[j])) {
                                            dominio = true;
                                        }
                                        else {
                                            dominio=false;
                                        }
                                    }
                                    if (dominio==false) {
                                        correo[contadorcorreo][i]= 10;
                                        System.out.println("Asunto");
                                        for (; i < 26 && correo[contadorcorreo][i] != 10;) {
                                            correo[contadorcorreo][i] = (char) System.in.read();
                                            if (correo[contadorcorreo][i] != 10) {
                                                i++;
                                            }
                                        }
                                        correo[contadorcorreo][i]= 10;
                                        System.out.println("<--><--><--><--><--><--><--><--><-->");
                                        for (; i < 100 && correo[contadorcorreo][i] != 10;) {
                                            correo[contadorcorreo][i] = (char) System.in.read();
                                            if (correo[contadorcorreo][i] != 10) {
                                                i++;
                                            }
                                        }
                                        contadorcorreo++;
                                    }
                                    else {
                                        System.out.print("El dominio introducido no es válido o compatible, introduzca un dominio válido");
                                    }
                                }
                            } while (exitwrite = false);
                        }
                        else{
                            System.out.println("Contraseña incorrecta");
                        }
                    }while (contrasenaspam = true) ;
                case 4:
                    System.out.println("Va a abandonar la aplcicacion, si es lo que quiere pulse 'C'");
                    respuesta = (char)System.in.read();
                    if (respuesta=='C' || respuesta=='c') {
                        exit=true;
                    }
                    break;
                default:

            }
            } while (exit == false) ;
        }
    }
