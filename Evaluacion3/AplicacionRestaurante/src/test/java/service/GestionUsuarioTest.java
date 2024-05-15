package service;

import common.PedidoNoEncontrado;
import dao.DaoClientes;
import domain.Pedido;
import domain.Plato;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
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

    @Order(0)
    @Test
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
    @Test
    void testMostrarMenu() {
    }

    @Order(2)
    @Test
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
        try {
            assertEquals(carrito.get(1234).toString(),daoClientes.verCarrito(1234));
        } catch (PedidoNoEncontrado e) {
            throw new RuntimeException(e);
        }
    }

    @Order(3)
    @Nested
    @DisplayName("Mostrar carrito")
    class mostrarCarrito {
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

        void mostrarCarritoSinPedido () {
            //Given
            int idPedido = 4321;
            HashMap<Integer,Integer> carrito = new HashMap<>();
            carrito.put(1,2);
            carrito.put(2,3);
            carrito.put(3,4);

            //When,Then
            try {
                when(daoClientes.verCarrito(idPedido)).thenReturn("");
                fail("Este pedido no existe y no saltado la excepcion");
            } catch (PedidoNoEncontrado e) {
                assertThrows(PedidoNoEncontrado.class, () -> gestionClientes.verPedidos(idPedido));
            }
        }
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("testEliminarPlato")
    void eliminarPlato(boolean respuesta) { //por ejemplo, como comprobaria en este metodo que cuando meto el pedido 0000 salta la excepcion de PedidoNoEncontrado
        //Given

        //When
        when(daoClientes.eliminarPlato("Plato",1234)).thenReturn(respuesta);
        when(daoClientes.eliminarPlato("",4321)).thenReturn(respuesta);

        //Then
        assertTrue(gestionClientes.eliminarPlato("Plato", 1234));
        assertFalse(gestionClientes.eliminarPlato("", 4321));

    }
    public static Stream<Boolean> testEliminarPlato () {
        return Stream.of(true,false);
    }

    @Order(5)
    @Test
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
    @CsvSource({"420","600","120"})
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