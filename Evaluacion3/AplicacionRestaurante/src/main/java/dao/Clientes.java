package dao;

import domain.Cliente;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Clientes {
    private HashSet<Cliente> clientes;

    public Clientes() throws IOException {
        if (!DaoFicheros.existClientes())
            DaoFicheros.crearFicheroClientes();
        clientes = crearClientes();
    }
    public Cliente getCliente(int idCliente) {
        return clientes.stream().filter(c -> c.getId()==idCliente).findFirst().orElse(null);
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
    public Cliente comprobarCliente (int idUsuario) {
        return clientes.stream().filter(c -> c.getId()==idUsuario).findFirst().orElse(null);
    }

    public boolean cambiarContraseña(int idUsuario, String contraseña) throws IOException {
        boolean cambiada = true;
        if (validarContraseña(contraseña)) {
            Cliente cliente = clientes.stream().filter(c -> c.getId() == idUsuario).findFirst().orElse(null);
            if (cliente != null) {
                cliente.setContraseña(contraseña);
                DaoFicheros.guardarClientes(clientes);
            }
            else
                cambiada = false;
        }
        else
            cambiada = false;
        return cambiada;
    }
    public boolean validarContraseña (String contraseña) {
        Pattern p = Pattern.compile("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$");
        Matcher m = p.matcher(contraseña);
        return m.matches();
    }
}
