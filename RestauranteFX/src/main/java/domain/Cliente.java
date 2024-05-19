package domain;

import common.Constantes;

import java.time.LocalDate;
import java.util.*;

public class Cliente extends Persona {
    private TreeSet<Factura> facturas;
    private List<Promocion> promociones;
    private String contraseña;

    public Cliente(String nombre, String apellidos, LocalDate fechaNacimiento, String contraseña) {
        super(nombre, apellidos, fechaNacimiento);
        facturas = new TreeSet<>(new Comparator<Factura>() {
            @Override
            public int compare(Factura o1, Factura o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
        promociones = new ArrayList<>();
        this.contraseña = contraseña;
    }
    public Cliente() {
    }
    public Cliente(int id) {
        super(id);
    }
    public Cliente(TreeSet<Factura> facturas, List<Promocion> promociones, String contraseña, int idUsuario, LocalDate fechaNacimiento, String apellidos, String nombre) {
        super(nombre, apellidos, fechaNacimiento);
        this.facturas = facturas;
        this.promociones = promociones;
        this.id = idUsuario;
        this.contraseña = contraseña;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    /*public String[] controlSeguridad (String contraseña, String nombreUsuario) {
            String[] errores = new String[2];
            if (nombreUsuario.equals(this.nombreUsuario))
                errores[0] = Constantes.NOMBRE_USUARIO_INCORRCTO;
            else if (this.contraseña.equalsIgnoreCase(contraseña))
                errores[1] = Constantes.NOMBRE_USUARIO_INCORRCTO;
            return errores;
        }*/
    public List<Promocion> getPromociones() {
        return promociones;
    }
    private String imprimirFacturas () {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < facturas.size(); i++) {
            Iterator<Factura> it = facturas.iterator();
            sb.append(it.next().toStringFichero());
            sb.append(Constantes.SEPARADOR_COLECCIONES);
        }
        sb.append("]");
        return sb.toString();
    }
    private String imprimirPromociones () {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < promociones.size(); i++) {
            sb.append(promociones.get(i).toStringFichero());
            sb.append(Constantes.SEPARADOR_COLECCIONES);
        }
        sb.append("]");
        return sb.toString();
    }
    public String toStringFichero() {
        return  imprimirFacturas()
                + Constantes.SEPARADOR_FICHEROSTXT + imprimirPromociones()
                + Constantes.SEPARADOR_FICHEROSTXT + contraseña
                + Constantes.SEPARADOR_FICHEROSTXT + id
                + Constantes.SEPARADOR_FICHEROSTXT + fechaNacimiento
                + Constantes.SEPARADOR_FICHEROSTXT + apellidos
                + Constantes.SEPARADOR_FICHEROSTXT + nombre;
    }
    public void nuevaFactura (int idUsuario, LocalDate fecha, String platos) { //excepcion error añadir factura
        Factura factura = new Factura(idUsuario,fecha,platos);
        //if(!facturas.add(factura))
            //excepcion
        facturas.add(factura);
    }
}
