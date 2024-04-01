package dao;

import common.Constantes;

import java.io.IOException;

public class erfe {
    public static void main(String[] args) throws IOException {
        /*boolean[] aciertos = new boolean[10];
        boolean uno = false;
        System.out.println(uno);
        System.out.println();
        for (int i = 0; i < aciertos.length; i++) {
            System.out.println(aciertos[i]);
        }*/
        System.out.println(Constantes.MUÑECO1);
        System.out.println(Constantes.MUÑECO2);
        System.out.println(Constantes.MUÑECO3);
        System.out.println(Constantes.MUÑECO4);
        System.out.println(Constantes.MUÑECO5);
        System.out.println(Constantes.MUÑECO6);
        System.out.println(Constantes.MUÑECO7);
        System.out.println(Constantes.MUÑECO8);
        DaoPalabrasFicheros.crearDiccionario();
        DaoPalabrasFicheros.escribirDiccionarioTest("bfvjkefvbjkrv");
    }
}
