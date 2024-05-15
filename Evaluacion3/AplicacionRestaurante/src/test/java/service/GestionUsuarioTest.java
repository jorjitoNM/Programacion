package service;

import common.Constantes;
import common.PedidoNoEncontrado;
import dao.DaoClientes;
import domain.Pedido;
import domain.Plato;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class gestionClientesTest {

    @InjectMocks
    GestionClientes gestionClientes;
    @Mock
    DaoClientes daoClientes;

    @BeforeEach
    public void intro () {
        System.out.println("Probando un nuevo test");
    }
    @Order(0)
    @Test
    @DisplayName("Mostrar el menu del restaurante")
    void mostrarMenu() {
        //Given
        HashSet<Plato> carta = new HashSet<>();
        carta.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
        carta.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));

        //When
        StringBuilder sb = new StringBuilder();
        carta.forEach(p -> sb.append(p.toString()));
        when(daoClientes.mostrarMenu()).thenReturn(sb.toString());

        String cartaRealString = gestionClientes.mostrarMenu(); //ejecución prueba
        //Then
        assertThat(cartaRealString).isEqualTo(daoClientes.mostrarMenu());
    }

    @Order(1)
    @ParameterizedTest
    @CsvSource({"Guarnicion","Principal"})
    @DisplayName("Mostrar el menu del restaurante filtrado por tipo de plato")
    void testMostrarMenu(String tipo) {
        //Given
        HashSet<Plato> carta = new HashSet<>();
        carta.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
        carta.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));
        String mensajeError = "No disponemos de este tipo de plato, disculpe las molestias";

        //When
        StringBuilder sb = new StringBuilder();
        carta.stream().filter(p -> p.getTipo().equalsIgnoreCase(tipo)).forEach(sb::append);
        when(daoClientes.mostrarMenu(tipo)).thenReturn(sb.toString());

        String cartaRealString = gestionClientes.mostrarMenu(tipo); //ejecución prueba
        //Then
        assertThat(cartaRealString).isEqualTo(daoClientes.mostrarMenu(tipo));

        //When
        when(daoClientes.mostrarMenu("Postre")).thenReturn(mensajeError);

        //Then
        assertThat(daoClientes.mostrarMenu("Postre")).isEqualTo(mensajeError);
    }

    @Order(2)
    @Test
    @DisplayName("Añadir un nuevo plato al pedido")
    void añadirPlato() {
        //Given

        HashSet<Plato> carta = new HashSet<>();
        carta.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
        carta.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));
        HashMap<Integer,Integer> carrito = new HashMap<>();
        carrito.put(1234,2);

        //When
        try {
            when(daoClientes.añadirPlato("Wrap de Vegetales a la Parrilla",2,1234)).thenReturn(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Then
        try {
            assertTrue(daoClientes.añadirPlato("Wrap de Vegetales a la Parrilla",2,1234));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Order(3)
    @Nested
    @DisplayName("Mostrar el carrito de compra")
    class mostrarCarrito {
        @Test
        void mostrarCarritoConPedido () {
            //Given
            int idPedido = 1234;
            HashMap<Integer,Integer> carrito = new HashMap<>();
            carrito.put(1,2);
            carrito.put(2,3);
            carrito.put(3,4);

            //When
            StringBuilder sb = new StringBuilder();
            for (Integer idPlato:carrito.keySet()) {
                sb.append(idPlato.toString());
            }
            String mockResult;
            try {
                when(daoClientes.verCarrito(idPedido)).thenReturn(sb.toString());
                mockResult = daoClientes.verCarrito(idPedido);
            } catch (PedidoNoEncontrado ex) {
                throw new RuntimeException(ex);
            }

            //Then
            try {
                assertEquals(gestionClientes.mostrarCarrito(idPedido), mockResult);
            } catch (PedidoNoEncontrado ex) {
                fail("Este pedido si existe y ha saltado la excepcion");
            }
        }

        @Test
        @DisplayName("Mostrar el carrito sin tener carrito")
        void mostrarCarritoSinPedido () {
            //Given
            int idPedido = 0;
            HashMap<Integer,Integer> carrito = new HashMap<>();
            carrito.put(1,2);
            carrito.put(2,3);
            carrito.put(3,4);

            //When
            try {
                when(daoClientes.verCarrito(idPedido)).thenThrow(PedidoNoEncontrado.class); //Como puedo hacer para comprobar que salta la excepcion si tengo que
            } catch (PedidoNoEncontrado e) {
                fail("Ha saltado la excepcion");
            }
            //Then
            assertThrows(PedidoNoEncontrado.class, () -> gestionClientes.mostrarCarrito(idPedido));
        }
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("testEliminarPlato")
    @DisplayName("Eliminar un plato del pedido")
    void eliminarPlato(boolean respuesta) { //por ejemplo, como comprobaria en este metodo que cuando meto el pedido 0000 salta la excepcion de PedidoNoEncontrado
        //Given

        //When
        when(daoClientes.eliminarPlato("Plato",1234)).thenReturn(respuesta);

        //Then
        assertEquals(gestionClientes.eliminarPlato("Plato", 1234),respuesta);

    }
    public static Stream<Boolean> testEliminarPlato () {
        return Stream.of(true,false);
    }

    @Order(5)
    @Test
    @DisplayName("Pedir el carrito de compra")
    void iniciarPedido() {
        //Given
        Pedido pedido = new Pedido(1234);

        //when
        //que mas puedo probar aqui?????

        gestionClientes.iniciarPedido(0000,pedido.getIdPedido());
        //Then
        //verify(daoClientes.iniciarPedido("0000",pedido.getIdPedido()),1); //no entiendo este error
      //  assertThat(pedido.isActivo()).isEqualTo(true);
    }

    @Order(6)
    @ParameterizedTest
    @DisplayName("Conocer el tiempo de espera del pedido")
    @CsvSource({"420","600","0"})
    void tiempoEspera(double tiempoEspera) {
        //Given
        Pedido pedido = new Pedido(1234);
        pedido.añadirPlato(1234,2);
        pedido.añadirPlato(0123,1);

        //When
        try {
            when(daoClientes.tiempoEspera(pedido.getIdPedido())).thenReturn(tiempoEspera);
        } catch (PedidoNoEncontrado e) {
            System.out.println("Pedido no encontrado");
        }

        //Then
        try {
            assertEquals(gestionClientes.tiempoEspera(pedido.getIdPedido()),daoClientes.tiempoEspera(pedido.getIdPedido()));
        } catch (PedidoNoEncontrado e) {
            System.out.println("Pedido no encontrado");
        }
    }
}