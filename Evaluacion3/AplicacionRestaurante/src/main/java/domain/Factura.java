package domain;

import java.time.LocalDate;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idCamarero;
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }
    public double calcualrPrecio () {
        return 0;
    }
}
