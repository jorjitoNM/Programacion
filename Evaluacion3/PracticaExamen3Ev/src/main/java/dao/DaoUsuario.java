package dao;

import common.HabilidadNoValidaException;
import domain.Campeon;

import java.io.IOException;

public class DaoUsuario {
    private Campeones dataBase;

    public DaoUsuario() throws HabilidadNoValidaException {
        dataBase = new Campeones();
        //dataBase = DaoFicheros.leerFicheroBinario();
    }

    public DaoUsuario(Campeones dataBase) {
        this.dataBase = dataBase;
    }
    public boolean nuevoAsesino (String nombre, int ataque, int skins, String habilidades, double altura, double burst) throws HabilidadNoValidaException {
        return dataBase.nuevoAsesino(nombre,ataque,skins,habilidades,altura,burst);
    }
    public boolean nuevoMago (String nombre, int ataque, int skins, String habilidades, double altura, boolean stunt) throws HabilidadNoValidaException {
        return dataBase.nuevoMago(nombre,ataque,skins,habilidades,altura,stunt);
    }

    public void comprobarHabilidades(String habilidades) throws HabilidadNoValidaException {
        Campeon.comprobarHabilidades(Campeon.parsearHabilidadesUsuario(habilidades));
    }

    public String mostrarCampeones(boolean orden) {
        return dataBase.getCampeonesNombre(orden);
    }
    public String mostrarCampeones() {
        return dataBase.getCampeones();
    }
    public String mostrarCampeones(String tipo) {
        return dataBase.getCampeones(tipo);
    }

    public String mostrarCampeonesPorAtaque(String minimo, String maximo) {
        return dataBase.mostrarCampeonesPorAtaque(Integer.parseInt(minimo),Integer.parseInt(maximo));
    }

    public boolean actualizarBurst(int id,double burst) throws NullPointerException {
        return dataBase.actualizarBurst(id,burst);
    }

    public boolean eliminarCampeon(int id) {
        return dataBase.eliminarCampeon(id);
    }

    public void guardarFicheroTXT() throws IOException {
        if (!DaoFicheros.existeFicheroTXT())
            DaoFicheros.crearFicheroTXT();
        dataBase.guardarFicheroTXT();
    }

    public void cargarFicheroTXT() {
        dataBase.cargarFicheroTXT();
    }

    public void guardarFicheroBinario() throws IOException {
        if (!DaoFicheros.existeFicheroBinario())
            DaoFicheros.crearFicheroBinario();
        dataBase.guardarFicheroBinario();
    }

    public void cargarFicheroBinario() {
        dataBase.cargarFicheroBinario();
    }

    public String mostrarCampeonesPorHabilidad() {
        return dataBase.mostrarCampeonesPorHabilidad();
    }
    public String mostrarCampeonesPorHabilidadNoLambda() {
        return dataBase.mostrarCampeonesPorHabilidadNoLambda();
    }
}
