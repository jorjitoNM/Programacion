package dao;

import common.CuponNoValidoException;
import common.PedidoNoEncontrado;
import domain.Cliente;
import domain.Pedido;
import domain.Promocion;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@Log4j2
@ExtendWith(MockitoExtension.class)
class DaoClientesTest {
    @InjectMocks
    DaoClientes daoClientes;
    @Mock
    Restaurante restaurante;

    @AfterAll
    public static void mensajeFinalLog () {
        log.info("Finalizados todos los test");
    }
    @BeforeAll
    public static void mensajeInicialLog () {
        log.info("Comenzando los test");
    }
    @BeforeEach
    public void intro () {
        System.out.println("Probando un nuevo test");
    }

    @Order(0)
    @DisplayName("Crear un nuevo pedido")
    @Test
    void nuevoPedido() {
        //Given usar un verify
        Cliente cliente = new Cliente(1234);

        //When
        when(restaurante.nuevoPedido(cliente.getId())).thenReturn(true);

        //Then
        assertEquals(daoClientes.nuevoPedido(cliente.getId()),restaurante.nuevoPedido(cliente.getId()));

        //Tiene sentido esta comprobacion?? estoy comprobando que al añadir un pedido, luego aparece en el treeSet de pedidos
        //Given
        Pedidos pedidos = new Pedidos();

        //When
        when(restaurante.nuevoPedido(cliente.getId())).thenReturn(false);

        //Then
        assertFalse(daoClientes.nuevoPedido(cliente.getId()));

        //Comprobacion en masa
        for (int i = 0; i < 15; i++) {
            Cliente clienteMass = new Cliente(i);

            //When
            when(restaurante.nuevoPedido(cliente.getId())).thenReturn(true);

            //Then
            assertEquals(daoClientes.nuevoPedido(cliente.getId()),restaurante.nuevoPedido(cliente.getId()));
            System.out.println("Cliente " + clienteMass.getId() + " pedidos: " + restaurante.verPedidos(cliente.getId()));
        }
    }

    @Test
    void añadirPlato() {
    }

    @Test
    void mostrarMenu() {
    }

   /* @Order(1)
    @DisplayName("Visualizar los pedidos de un cliente")
    @Test
    void verPedidos() {
        //Given
        Cliente cliente = new Cliente(1234);
        Pedidos pedidos = new Pedidos();
        System.out.println(pedidos.getPedidos().size());
        System.out.println(cliente.getId());
        System.out.println(pedidos.nuevoPedido(cliente.getId()));
        System.out.println(pedidos.nuevoPedido(cliente.getId()));
        System.out.println(pedidos.nuevoPedido(cliente.getId()));
        System.out.println(pedidos.getPedidos().size());
        pedidos.getPedidos().forEach(System.out::print);
        //When
        when(restaurante.verPedidos(cliente.getId())).thenReturn(pedidos.verPedidos(cliente.getId()));

        //Then
        assertEquals(daoClientes.verPedidos(cliente.getId()),pedidos.verPedidos(cliente.getId()));
        assertThat(daoClientes.verPedidos(cliente.getId()).split("\n")).isNotEmpty().hasSize(3);
    }*/


    @Test
    void eliminarPlato() {
    }
    @Order(2)
    @DisplayName("Comprobar que un cupon descuento es valido")
    @ParameterizedTest
    @CsvSource({"hola10","hola20","hola30"}) //Quiero lanzar excepcion en el hola50
    void validarCupon(String cupon) {
        //Given
        Cliente cliente = new Cliente(1234);
        List<Promocion> cupones = new ArrayList<>();
        cupones.add(new Promocion("hola10"));
        cupones.add(new Promocion("hola20"));
        cupones.add(new Promocion("hola30"));
        cliente.setPromociones(cupones);

        //When
        try {
            restaurante.validarCupon(cupon,cliente.getId());
        } catch (CuponNoValidoException e) {
            log.error("El cupon introducido no es valido");
        }

        //Then
        assertDoesNotThrow(() -> restaurante.validarCupon(cupon,cliente.getId()));
    }
    @Order(3)
    @DisplayName("Ver la hora de entrega de mi pedido")
    @Test
    void horaEntrega() {
        //Given
        Pedido pedido = new Pedido(1234);

        //When
        try {
            when(restaurante.horaEntrega(pedido.getIdPedido())).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        } catch (PedidoNoEncontrado e) {
            log.error("No se ha encontrado el pedido");
        }
        //Then
        try {
            assertEquals(daoClientes.horaEntrega(pedido.getIdPedido()),restaurante.horaEntrega(pedido.getIdPedido())); //el daoClientes.horaEntrega que va a devolver??, si va a coger lo que le da el mock es imposible que no sea igual
        } catch (PedidoNoEncontrado e) {
            log.error("No se ha encontrado el pedido");
        }

        //Given


        //When
        try {
            when(restaurante.horaEntrega(0000)).thenThrow(new PedidoNoEncontrado());
        } catch (PedidoNoEncontrado e) {
            log.error("No se ha encontrado el pedido");
        }

        //Then
        try {
            daoClientes.horaEntrega(0000);
        } catch (PedidoNoEncontrado e) {
            assertThat(e).isInstanceOf(PedidoNoEncontrado.class);
        }

    }
}