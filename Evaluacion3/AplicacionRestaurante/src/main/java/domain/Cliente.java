package domain;

import common.Constantes;
import common.ContraseñaNoValidaExcepcion;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.layout.PatternMatch;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Cliente extends Persona {
    private TreeSet<Factura> facturas;
    private List<Promocion> promociones;
    private String contraseña;

    public Cliente(String nombre, String apellidos, LocalDate fechaNacimiento, String contraseña) {
        super(nombre, apellidos, fechaNacimiento);
        facturas = new TreeSet<>(Comparator.comparingInt(Factura::getIdFactura));
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

    /*public String[] controlSeguridad (String contraseña, String nombreUsuario) {
            String[] errores = new String[2];
            if (nombreUsuario.equals(this.nombreUsuario))
                errores[0] = Constantes.NOMBRE_USUARIO_INCORRCTO;
            else if (this.contraseña.equalsIgnoreCase(contraseña))
                errores[1] = Constantes.NOMBRE_USUARIO_INCORRCTO;
            return errores;
        }*/
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
    public void nuevaFactura (LocalDate fecha, String platos) { //excepcion error añadir factura
        Factura factura = new Factura(id,fecha,platos);
        //if(!facturas.add(factura))
            //excepcion
        facturas.add(factura);
    }
    public void validarContraseña (String contraseña) throws ContraseñaNoValidaExcepcion {
        Pattern p = Pattern.compile("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$");
        Matcher m = p.matcher(contraseña);
        if (!m.matches())
            throw new ContraseñaNoValidaExcepcion();
    }
}
