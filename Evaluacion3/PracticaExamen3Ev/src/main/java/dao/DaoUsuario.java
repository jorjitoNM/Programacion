package dao;

import common.HabilidadNoValidaException;

public class DaoUsuario {
    private Campeones dataBase;

    public DaoUsuario() {
        dataBase = new Campeones();
    }

    public DaoUsuario(Campeones dataBase) {
        this.dataBase = dataBase;
    }
    public boolean nuevoAsesino (String nombre, int ataque, int skins, String[] habilidades, int altura, boolean busrt) throws HabilidadNoValidaException {
        return dataBase.nuevoAsesino(nombre,ataque,skins,habilidades,altura,busrt);
    }
    public boolean nuevoMago (String nombre, int ataque, int skins, String[] habilidades, int altura, boolean stunt) {
        return dataBase.nuevoMago(nombre,ataque,skins,habilidades,altura,stunt);
    }
}
