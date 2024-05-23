package dao;

import domain.Cliente;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.HashSet;

@Getter
@Setter
public class Clientes {
    private HashSet<Cliente> clientes;

    public Clientes() throws IOException {
        if (!DaoFicheros.existClientes())
            DaoFicheros.crearFicheroClientes();
        clientes = crearClientes();
    }

    public Clientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }
    public Cliente getCliente(int idCliente) {
        return clientes.stream().filter(c -> c.getId()==idCliente).findFirst().orElse(null);
    }
    public Cliente getCliente (String nombreUsuario) {
        return clientes.stream().filter(c -> c.getNombre().equals(nombreUsuario)).findFirst().orElse(null);
    }
    public String mostrarIDsUsuarios () {
        StringBuilder sb = new StringBuilder();
        clientes.forEach(c -> sb.append(c.getNombre()).append(": ").append(c.getId()).append("\n"));
        return sb.toString();
    }
    private HashSet<Cliente> crearClientes() throws IOException {
        HashSet<Cliente> clientes = new HashSet<>();
            if (DaoFicheros.clientesIsEmpty()) {
                Faker faker = new Faker();
                for (int i = 0; i < 15; i++) {
                    clientes.add(new Cliente(faker.name().name(),faker.name().lastName(),faker.date().birthdayLocalDate(),"1234"));
                }
                DaoFicheros.guardarClientes(clientes);
            }
            else {
                clientes = DaoFicheros.leerClientes();
            }
        return clientes;
    }
    public boolean comprobarCliente (int idUsuario) {
        return clientes.stream().filter(c -> c.getId()==idUsuario).findFirst().orElse(null) != null;
    }
}
