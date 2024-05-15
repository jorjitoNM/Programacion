package domain;

import common.Constantes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idCamarero;
    private LocalDate fecha;
    private String platos;
    private ArrayList<Integer> ids = new ArrayList<>();

    public Factura(int idCliente, LocalDate fecha,String platos) {
        idFactura = darID();
        this.idCliente = idCliente;
        this.platos = platos;
        this.fecha = fecha;
    }
    public Factura(int idCliente, int idFactura, LocalDate fecha,String platos) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.platos = platos;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public double calcualrPrecio () {
        return 0;
    }
    private int darID () {
        int id = (int) (Math.random()*1000);
        return (ids.contains(id))?darID():id;
    }

    public String toStringFichero() {
        return idFactura + Constantes.SEPARADOR_ELEMENTOS_FACTURA
                + idCliente + Constantes.SEPARADOR_ELEMENTOS_FACTURA
                + fecha + Constantes.SEPARADOR_ELEMENTOS_FACTURA
                + platos + Constantes.SEPARADOR_ELEMENTOS_FACTURA;
    }
}
