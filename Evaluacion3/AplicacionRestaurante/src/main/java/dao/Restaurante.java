package dao;

import common.Constantes;
import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Restaurante implements Serializable {

    private HashSet<Plato> carta;
    private Clientes clientes;
    private Pedidos pedidos;


    public Restaurante() throws IOException {
        clientes = new Clientes();
        pedidos = new Pedidos();
        if (!DaoFicheros.existCarta())
            DaoFicheros.crearCartaJson();
        carta = crearCarta();
    }

    public boolean añadirPlato (String nombre, int cantidad, int idPedido) throws FileNotFoundException {
        int idPlato = carta.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(new Plato(-1)).getId();
        Pedido pedido = pedidos.getPedidos().stream().filter(p -> p.getIdPedido() == idPedido).findFirst().orElse(null);
        if (idPlato > 0 && pedido != null) {
            pedido.añadirPlato(idPlato, cantidad);
            DaoFicheros.guardarCarta(carta);
            return true;
        } else
            return false;
    }
    public int nuevoPedido (int idUsuario) {
        return pedidos.nuevoPedido(idUsuario);
    }
    private HashSet<Plato> crearCarta () throws IOException {
            if (DaoFicheros.cartaIsEmpty()) {
                carta = new HashSet<>();
                carta.add(new Plato("Hamburguesa Clásica", 5.99, "Queso, tocino, huevo ($0.50 cada uno)", "Principal"));
                carta.add(new Plato("Pizza Pepperoni", 7.99, "Champiñones, pimientos ($0.75 cada uno)", "Principal"));
                carta.add(new Plato("Burrito de Pollo", 6.99, "Guacamole, crema agria ($0.75 cada uno)", "Principal"));
                carta.add(new Plato("Sándwich de Pavo", 5.49, "Aguacate, cebolla caramelizada ($0.50 cada uno)", "Principal"));
                carta.add(new Plato("Tacos de Carne Asada", 8.99, " Guacamole, pico de gallo ($0.75 cada uno)", "Principal"));
                carta.add(new Plato("Wrap de Vegetales a la Parrilla", 6.49, "Aguacate, salsa picante ($0.50 cada uno)", "Principal"));
                carta.add(new Plato("Fajitas de Camarones", 12.49, "Pimientos, cebollas, tortillas de harina ($1.00 cada uno)", "Principal"));
                carta.add(new Plato("Pollo a la Parrilla con Vegetales", 7.99, "Salsa de teriyaki, queso cheddar ($0.50 cada uno)", "Principal"));
                carta.add(new Plato("Papas Fritas", 2.99, "Queso fundido, salsa BBQ ($0.50 cada uno)", "Guarnición"));
                carta.add(new Plato("Ensalada César", 3.99, "Pollo a la parrilla, aderezo ranch ($1.00 cada uno)", "Guarnicion"));
                carta.add(new Plato("Maíz a la Parrilla", 1.99, "Mantequilla de ajo, queso parmesano ($0.75 cada uno)", "Guarnicion"));
                carta.add(new Plato("Arroz Pilaf", 2.49, "Verduras mixtas, salsa de soja ($0.50 cada uno)", "Guarnicion"));
                carta.add(new Plato("Papas Hasselback", 3.99, "Queso cheddar, cebollino ($0.75 cada uno)", "Guarnicion"));
                carta.add(new Plato("Puré de Patatas con Ajo", 2.99, "Queso parmesano, mantequilla de hierbas ($0.75 cada uno)", "Guarnicion"));
                carta.add(new Plato("Refresco Grande", 1.99, "", "Acompañante"));
                carta.add(new Plato("Batido de Frutas", 3.49, "", "Acompañante"));
                carta.add(new Plato("Nachos con Queso", 4.99, "", "Acompañante"));
                carta.add(new Plato("Palitos de Zanahoria y Apio con Hummus", 3.49, "", "Acompañante"));
                carta.add(new Plato("Pan de Ajo", 2.49, "", "Acompañante"));
                carta.add(new Plato("Tarta de Manzana", 4.99, "Helado de vainilla, salsa de caramelo ($1.00 cada uno)", "Postre"));
                carta.add(new Plato("Helado Sundae", 3.49, "Crema batida, nueces ($0.50 cada uno)", "Postre"));
                carta.add(new Plato("Cheesecake de Fresa", 5.99, " Salsa de fresa, chantilly ($0.75 cada uno)", "Postre"));
                carta.add(new Plato("Crepes de Nutella", 6.49, "Helado de vainilla, fresas frescas ($1.00 cada uno)", "Postre"));
                carta.add(new Plato("Tiramisú Casero", 6.49, "Cacao en polvo, café espresso ($0.75 cada uno)", "Postre"));
                carta.add(new Plato("Pastel de Tres Leches", 5.99, "Frutas tropicales, coco rallado ($1.25 cada uno)", "Postre"));
                carta.add(new Plato("Mousse de Chocolate", 4.99, " Frambuesas frescas, hojas de menta ($0.75 cada uno)", "Postre"));
                carta.add(new Plato("Tarta de Limón", 4.49, "Merengue tostado, ralladura de limón ($0.75 cada uno)", "Postre"));
                DaoFicheros.guardarCarta(carta);
            } else
                carta = DaoFicheros.leerCarta();
        return carta;
    }
    public boolean eliminarCarta () {
        carta.clear();
        return DaoFicheros.eliminarCarta();
    }
    public int darIDPedido (String nombreUsuario) {
        int idUsuario = clientes.getClientes().stream().filter(c -> c.getNombre().equalsIgnoreCase(nombreUsuario)).mapToInt(Persona::getId).findFirst().orElse(-1); //no me encuentra los clientes
        return pedidos.darIDPedido(idUsuario);
    }
    public boolean existePedido (int idPedido) {
        return pedidos.getPedidos().stream().filter(p -> p.getIdPedido()==idPedido).findFirst().orElse(null) != null;
        //return pedidos.getPedido(idPedido) != null;
    }
    public void iniciarPedido (int idPedido) {
        pedidos.iniciarPedido(idPedido);
    }
    public void iniciarPedido (String codigo, int idPedido) {
        pedidos.iniciarPedido(codigo,idPedido);
    }
    public String getCarta() {
        StringBuilder sb = new StringBuilder();
        for (Plato plato : carta) {
            sb.append(plato.toString());
        }
        return sb.toString();
    }
    public String getCarta(String tipo) {
        StringBuilder sb = new StringBuilder();
        carta.stream().filter(p -> p.getTipo().equalsIgnoreCase(tipo)).forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }
    public String verCartaAdmin () {
        StringBuilder sb = new StringBuilder();
        for (Plato plato : carta) {
            sb.append(plato.toString());
        }
        return sb.toString();
    }
    public void validarCupon (String codigo, int idUsuario) throws CuponNoValidoException {
        if (clientes.getCliente(idUsuario).getPromociones().stream().filter(p -> p.getCodigo().equalsIgnoreCase(codigo)).findFirst().orElse(null) == null) {
            throw new CuponNoValidoException();
        }
    }
    public String verPedidos (int idUsuario) {
        String resultado = pedidos.verPedidos(Objects.requireNonNull(clientes.getClientes().stream().filter(c -> c.getId() == idUsuario).findFirst().orElse(null)).getId());
        if (resultado.isEmpty()) {
            resultado = Constantes.NO_HAY_PEDIDOS;
        }
        return resultado;
    }
    public boolean eliminarPlato (String nombrePlato, int idPedido) {
        int idPlato = carta.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombrePlato)).findFirst().orElse(new Plato(-1)).getId();
        Pedido pedido = pedidos.getPedidos().stream().filter(p -> p.getIdPedido() == idPedido).findFirst().orElse(null);
        if (idPlato!=0 && pedido!=null){
            pedido.eliminarPlato(idPlato);
            return true;
        }
        else
            return false;
    }
    public void validarPedido (int idPedido) throws PedidoNoEncontrado {
        pedidos.validarPedido(idPedido);
    }
    public String verComandas () {
        StringBuilder sb = new StringBuilder();
        pedidos.getPedidos().forEach(p -> {
            try {
                sb.append(Constantes.PEDIDO).append(p.getIdPedido()).append("(").append(clientes.getCliente(p.getIdUsuario()).getNombre()).append(")").append(getPlatos(p.getIdPedido()));
            } catch (PedidoNoEncontrado e) {
                throw new RuntimeException(e);
            }
        });
        return sb.toString();
    }
    public String crearFactura (int idPedido, int idUsuario) throws PedidoNoEncontrado {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s ", clientes.getCliente(pedidos.getPedido(idPedido).getIdUsuario()).getNombre())); // aqui iria el nombre del cliente, que lo consigo gracias a un metodo que buscar el nombre del usuario con el id que hay en el pedido (en la calse clientes)
        sb.append(idPedido);
        sb.append("\n");
        sb.append(pedidos.getPedido(idPedido).getFecha());
        sb.append("\n");
        sb.append(imprimirPlatos(idPedido));
        sb.append(calcularPrecio(idPedido));
        clientes.getCliente(idUsuario).nuevaFactura(LocalDate.from(pedidos.getPedido(idPedido).getFecha()),imprimirPlatos(idPedido));
        return sb.toString();
    }
    public double tiempoEspera (int idPedido) throws PedidoNoEncontrado {
        double tiempoEspera = 0;
        Set<Integer> claves = pedidos.getPedido(idPedido).getPlatos().keySet();
        for (Integer idPlato:claves) {
            tiempoEspera += getPlato(idPlato).getTiempoPreparacion();
        }
        return tiempoEspera;
    }
    public LocalDateTime horaEntrega (int idPedido) throws PedidoNoEncontrado {
        return pedidos.getPedido(idPedido).horaEntrega(tiempoEspera(idPedido));
    }
    public String verCarrito (int idPedido) throws PedidoNoEncontrado {
        return getPlatos(idPedido);
    }
    public String getPlatos (int idPedido) throws PedidoNoEncontrado {
        StringBuilder sb = new StringBuilder();
        Set<Integer> claves = pedidos.getPedido(idPedido).getPlatos().keySet();
        Pedido pedido = pedidos.getPedido(idPedido);
        for (Integer idPlato:claves) {
            sb.append(String.format("-%s  -->  %d uds.",getNombrePlato(idPlato),pedido.getPlatos().get(idPlato)));
            sb.append("\n");
        }
        return sb.toString();
    }
    private String getNombrePlato (int idPlato) {
        return Objects.requireNonNull(carta.stream().filter(p -> p.getId() == idPlato).findFirst().orElse(null)).getNombre();
    }
    private Plato getPlato (int idPlato) {
        return carta.stream().filter(p -> p.getId() == idPlato).findFirst().orElse(null);
    }
    private String imprimirPlatos (int idPedido) throws PedidoNoEncontrado {
        StringBuilder sb = new StringBuilder();
        for (Integer idPlato : pedidos.getPedido(idPedido).getPlatos().keySet()) {
            sb.append(String.format("- %s ",getNombrePlato(idPlato)));
            sb.append(String.format(": %d",pedidos.getPedido(idPedido).getPlatos().get(idPlato)));
            sb.append("\n");
        }
        return sb.toString();
    }
    public boolean cambiarPrecio (int idPlato, double precio) {
        carta.stream().filter(p -> p.getId()==idPlato).findFirst().ifPresent(p -> p.setPrecio(precio));
        return Objects.requireNonNull(carta.stream().filter(p -> p.getId() == idPlato).findFirst().orElse(null)).getPrecio()==precio;
    }
    private double calcularPrecio (int idPedido) throws PedidoNoEncontrado {
        double precio = 0;
        Set<Integer> platos = pedidos.getPedido(idPedido).getPlatos().keySet();
        for (Integer idPlato : platos) {
            precio += getPlato(idPlato).getPrecio();
        }
        return precio;
    }

    public boolean pedidoIsEmpty(int idPedido) throws PedidoNoEncontrado {
        return pedidos.getPedido(idPedido).getPlatos().isEmpty();
    }
}