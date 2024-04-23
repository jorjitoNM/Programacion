package domain;

import java.util.List;
import java.util.TreeSet;

public class Cliente extends Persona {
    private TreeSet<Factura> facturas;
    private List<Promocion> promociones;

}
