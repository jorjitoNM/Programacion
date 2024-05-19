package service;

import common.HabilidadNoValidaException;
import dao.DaoUsuario;

public class GestionUsuario {
    private DaoUsuario daoUsuario;

    public GestionUsuario() {
        daoUsuario = new DaoUsuario();
    }

    public GestionUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }
    public boolean nuevoAsesino (String nombre, int ataque, int skins, String[] habilidades, int altura, boolean busrt) throws HabilidadNoValidaException {
        return daoUsuario.nuevoAsesino(nombre,ataque,skins,habilidades,altura,busrt);
    }
    public boolean nuevoMago (String nombre, int ataque, int skins, String[] habilidades, int altura, boolean stunt) {
        return daoUsuario.nuevoMago(nombre,ataque,skins,habilidades,altura,stunt);
    }
}
