package service;

import common.HabilidadNoValidaException;
import dao.DaoUsuario;

import java.io.IOException;

public class GestionUsuario {
    private DaoUsuario daoUsuario;

    public GestionUsuario() throws HabilidadNoValidaException {
        daoUsuario = new DaoUsuario();
    }

    public GestionUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }
    public boolean nuevoAsesino (String nombre, int ataque, int skins, String habilidades, double altura, double burst) throws HabilidadNoValidaException {
        return daoUsuario.nuevoAsesino(nombre,ataque,skins,habilidades,altura,burst);
    }
    public boolean nuevoMago (String nombre, int ataque, int skins, String habilidades, double altura, boolean stunt) throws HabilidadNoValidaException {
        return daoUsuario.nuevoMago(nombre,ataque,skins,habilidades,altura,stunt);
    }
    public void comprobaHabilidades (String habilidades) throws HabilidadNoValidaException {
        daoUsuario.comprobarHabilidades(habilidades);
    }
    public String mostrarCampeones (boolean orden) {
        return daoUsuario.mostrarCampeones(orden);
    }
    public String mostrarCampeones () {
        return daoUsuario.mostrarCampeones();
    }
    public String mostrarCampeones (String tipo) {
        return daoUsuario.mostrarCampeones(tipo);
    }

    public String mostrarCampeonesPorAtaque(String minimo, String maximo) {
        return daoUsuario.mostrarCampeonesPorAtaque(minimo,maximo);
    }

    public boolean actualizarBusrt(int id,double burst) throws NullPointerException {
        return daoUsuario.actualizarBurst(id,burst);
    }

    public boolean eliminarCampeon(int id) {
        return daoUsuario.eliminarCampeon(id);
    }

    public void guardarFicheroTXT() throws IOException {
        daoUsuario.guardarFicheroTXT();
    }

    public void cargarFicheroTXT() {
        daoUsuario.cargarFicheroTXT();
    }

    public void guardarFicheroBinario() throws IOException {
        daoUsuario.guardarFicheroBinario();
    }

    public void cargarFicheroBinario() {
        daoUsuario.cargarFicheroBinario();
    }

    public String mostrarCampeonesPorHabilidad() {
        return daoUsuario.mostrarCampeonesPorHabilidad();
    }
    public String mostrarCampeonesPorHabilidadNoLambda() {
        return daoUsuario.mostrarCampeonesPorHabilidadNoLambda();
    }
}
