package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Zoologico extends Centro {
    private boolean delfinario;
    private boolean pinguinos;
    public Zoologico () {
        super();
        if (Math.random()>0.5)
            delfinario = true;
        else
            delfinario = false;
        if (Math.random()>0.5)
            pinguinos = true;
        else
            pinguinos = false;
        precioEntrada = Math.random()*10+10;
    }

    public Zoologico(String nombre, double precioEntrada, String provincia, int anyoConstruccion, boolean delfinario, boolean pinguinos) {
        super(nombre, precioEntrada, provincia, anyoConstruccion);
        this.delfinario = delfinario;
        this.pinguinos = pinguinos;
    }

    @Override
    public double calcularPrecio(boolean festivo, int edad) {
        double precio = 0;
        if (edad>7) {
            if (festivo)
                precio = Math.random()*10+10*1.3;
            else
                precio = Math.random()*10+10;
        }
        else
            precio = 0;
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + ". " + traduccionBooleanos();
    }

    private String traduccionBooleanos() {
        String respuesta;
        if (delfinario && pinguinos)
            respuesta = "Tiene delfinario y pinguinos";
        else if (delfinario)
            respuesta = "Tiene delfinario";
        else if (pinguinos)
            respuesta = "Tiene pinguinos";
        else
            respuesta = "";
        return respuesta;
    }
}
