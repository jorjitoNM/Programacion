package domain;

import common.Constantes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Cliente extends Persona {
    private TreeSet<Factura> facturas;
    private List<Promocion> promociones;
    private String contraseña;
    private String nombreUsuario;

    public Cliente(String contraseña, String nombreUsuario) {
        facturas = new TreeSet<>(new Comparator<Factura>() {
            @Override
            public int compare(Factura o1, Factura o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
        promociones = new ArrayList<>();
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
    }
    public String[] controlSeguridad (String contraseña, String nombreUsuario) {
        String[] errores = new String[2];
        if (nombreUsuario.equals(this.nombreUsuario))
            errores[0] = Constantes.NOMBRE_USUARIO_INCORRCTO;
        else if (this.contraseña.equalsIgnoreCase(contraseña))
            errores[1] = Constantes.NOMBRE_USUARIO_INCORRCTO;
        return errores;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }
}
