package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Promocion {
    private String codigo;

    public Promocion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toStringFichero() {
        return codigo;
    }
}
