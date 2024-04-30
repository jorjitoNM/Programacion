package dao;

import domain.Pedido;
import domain.Persona;
import domain.Plato;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Restaurante {

    private HashSet<Plato> carta;
    private Clientes clientes;
    private Pedidos pedidos;


    public Restaurante() {
        clientes = new Clientes();
        pedidos = new Pedidos();
        carta = crearCarta();
    }

    public boolean añadirPlato (String nombre, int cantidad, int idPedido) {
        int idPlato = carta.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(new Plato(0)).getId();
        if (idPlato!=0 && pedidos.last()!=null){ //aqui deberia pedir el id del pedido y guardarmelo en una variable despues de tener el correcto
            pedidos.añadirPlato(idPlato,cantidad);
            return true;
        }
        else
            return false;
    }

    public int nuevoPedido () {
        return pedidos.nuevoPedido();
    }
    private HashSet<Plato> crearCarta () {
        if (carta!=null) {
            carta = new HashSet<>();
            carta.add(new Plato("Hamburguesa Clásica",5.99,"Queso, tocino, huevo ($0.50 cada uno)","Principal"));
            carta.add(new Plato("Pizza Pepperoni",7.99,"Champiñones, pimientos ($0.75 cada uno)","Principal"));
            carta.add(new Plato("Burrito de Pollo",6.99,"Guacamole, crema agria ($0.75 cada uno)","Principal"));
            carta.add(new Plato("Sándwich de Pavo",5.49,"Aguacate, cebolla caramelizada ($0.50 cada uno)","Principal"));
            carta.add(new Plato("Tacos de Carne Asada",8.99," Guacamole, pico de gallo ($0.75 cada uno)","Principal"));
            carta.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
            carta.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
            carta.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
            carta.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));
            carta.add(new Plato("Ensalada César",3.99,"Pollo a la parrilla, aderezo ranch ($1.00 cada uno)","Guarnicion"));
            carta.add(new Plato("Maíz a la Parrilla",1.99,"Mantequilla de ajo, queso parmesano ($0.75 cada uno)","Guarnicion"));
            carta.add(new Plato("Arroz Pilaf",2.49,"Verduras mixtas, salsa de soja ($0.50 cada uno)","Guarnicion"));
            carta.add(new Plato("Papas Hasselback",3.99,"Queso cheddar, cebollino ($0.75 cada uno)","Guarnicion"));
            carta.add(new Plato("Puré de Patatas con Ajo",2.99,"Queso parmesano, mantequilla de hierbas ($0.75 cada uno)","Guarnicion"));
            carta.add(new Plato("Refresco Grande",1.99,"","Acompañante"));
            carta.add(new Plato("Batido de Frutas",3.49,"","Acompañante"));
            carta.add(new Plato("Nachos con Queso",4.99,"","Acompañante"));
            carta.add(new Plato("Palitos de Zanahoria y Apio con Hummus",3.49,"","Acompañante"));
            carta.add(new Plato("Pan de Ajo",2.49,"","Acompañante"));
            carta.add(new Plato("Tarta de Manzana",4.99,"Helado de vainilla, salsa de caramelo ($1.00 cada uno)","Postre"));
            carta.add(new Plato("Helado Sundae",3.49,"Crema batida, nueces ($0.50 cada uno)","Postre"));
            carta.add(new Plato("Cheesecake de Fresa",5.99," Salsa de fresa, chantilly ($0.75 cada uno)","Postre"));
            carta.add(new Plato("Crepes de Nutella",6.49,"Helado de vainilla, fresas frescas ($1.00 cada uno)","Postre"));
            carta.add(new Plato("Tiramisú Casero",6.49,"Cacao en polvo, café espresso ($0.75 cada uno)","Postre"));
            carta.add(new Plato("Pastel de Tres Leches",5.99,"Frutas tropicales, coco rallado ($1.25 cada uno)","Postre"));
            carta.add(new Plato("Mousse de Chocolate",4.99," Frambuesas frescas, hojas de menta ($0.75 cada uno)","Postre"));
            carta.add(new Plato("Tarta de Limón",4.49,"Merengue tostado, ralladura de limón ($0.75 cada uno)","Postre"));
        }
        return carta;
    }
    public int darIDPedido (String nombreUsuario) {
        int idUsuario = clientes.getClientes().stream().filter(c -> c.getNombre().equalsIgnoreCase(nombreUsuario)).mapToInt(Persona::getId).findFirst().orElse(-1); //no me encuentra los clientes
        return pedidos.darIDPedido(idUsuario);
    }
    public void iniciarPedido () {
        pedidos.iniciarPedido();
    }
    public void iniciarPedido (String codigo) {
        pedidos.iniciarPedido(codigo);
    }

    public String getCarta() {
        StringBuilder sb = new StringBuilder();
        for (Plato plato : carta) {
            sb.append(plato.toString());
        }
        return sb.toString();
    }
}