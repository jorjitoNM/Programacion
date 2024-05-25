package domain;

import common.Constantes;
import common.ContraseñaNoValidaExcepcion;
import common.PedidoNoEncontrado;
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
    private TreeSet<Pedido> pedidos;

    public Cliente(String nombre, String apellidos, LocalDate fechaNacimiento, String contraseña) {
        super(nombre, apellidos, fechaNacimiento);
        facturas = new TreeSet<>(Comparator.comparingInt(Factura::getIdFactura));
        promociones = new ArrayList<>();
        this.contraseña = contraseña;
        pedidos = new TreeSet<>(new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                int respuesta = o1.getFecha().compareTo(o2.getFecha());
                if (respuesta == 0) {
                    respuesta = Integer.compare(o1.getIdPedido(),o2.getIdPedido());
                }
                return respuesta;
            }
        });
    }
    public Cliente(int id) {
        super(id);
        pedidos = new TreeSet<>(new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                int respuesta = o1.getFecha().compareTo(o2.getFecha());
                if (respuesta == 0) {
                    respuesta = Integer.compare(o1.getIdPedido(),o2.getIdPedido());
                }
                return respuesta;
            }
        });
    }
    public Cliente(TreeSet<Factura> facturas, List<Promocion> promociones, String contraseña, int idUsuario, LocalDate fechaNacimiento, String apellidos, String nombre) {
        super(nombre, apellidos, fechaNacimiento);
        this.facturas = facturas;
        this.promociones = promociones;
        this.id = idUsuario;
        this.contraseña = contraseña;
        pedidos = new TreeSet<>(new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                int respuesta = o1.getFecha().compareTo(o2.getFecha());
                if (respuesta == 0) {
                    respuesta = Integer.compare(o1.getIdPedido(),o2.getIdPedido());
                }
                return respuesta;
            }
        });
    }
    public void iniciarPedido (int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
                pedido.setActivo(true);
                exit = true;
            }
        }
    }
    public void iniciarPedido (String codigo, int idPedido) {
        Iterator<Pedido> it = pedidos.iterator();
        boolean exit = false;
        Pedido pedido = null;
        while (it.hasNext() && !exit) {
            pedido = it.next();
            if (pedido.getIdPedido() == idPedido) {
                pedido.setActivo(true);
                pedido.setPromocion(new Promocion(codigo));
                exit = true;
            }
        }
    }
    public int nuevoPedido () {
        Pedido pedido = new Pedido(id);
        int idPedido = -1;
        if (pedidos.add(pedido))
            idPedido = pedido.getIdPedido();
        return idPedido;
    }
    public Pedido getPedido (int idPedido) throws PedidoNoEncontrado {
        Pedido pedido = pedidos.stream().filter(p -> p.getIdPedido() == idPedido).findFirst().orElseThrow(PedidoNoEncontrado::new);
        return pedido;
    }
    public String getPedidosString () {
        StringBuilder sb = new StringBuilder();
        pedidos.stream().sorted(Comparator.comparing(Pedido::getFecha)).forEach(sb::append);
        return sb.toString();
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
    public void nuevaFactura (LocalDate fecha, String platos) { //excepcion error añadir factura
        Factura factura = new Factura(id,fecha,platos);
        //if(!facturas.add(factura))
            //excepcion
        facturas.add(factura);
    }
    public boolean comprobarContraseña(String s) {
        return s.equals(contraseña);
    }
}