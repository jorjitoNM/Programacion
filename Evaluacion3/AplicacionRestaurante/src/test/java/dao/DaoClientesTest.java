package dao;

import common.PedidoNoEncontrado;
import domain.Cliente;
import domain.Pedido;
import domain.Promocion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class DaoClientesTest {
    @InjectMocks
    DaoClientes daoClientes;
    @Mock
    Restaurante restaurante;

    @Test
    void nuevoPedido() {
        //Given usar un verify
        Cliente cliente = new Cliente(1234);

        //When
        when(restaurante.nuevoPedido(cliente.getId())).thenReturn(new Pedido(cliente.getId()).getIdPedido());

        //Then
        assertEquals(daoClientes.nuevoPedido(cliente.getId()),restaurante.nuevoPedido(cliente.getId()));

        //Tiene sentido esta comprobacion?? estoy comprobando que al añadir un pedido, luego aparece en el treeSet de pedidos
        //Given
        Pedidos pedidos = new Pedidos();

        //When
        when(restaurante.nuevoPedido(cliente.getId())).thenReturn(pedidos.nuevoPedido(cliente.getId()));

        //Then
        assertEquals(pedidos.getPedidos().stream().findAny().get().getIdPedido(),restaurante.nuevoPedido(cliente.getId()));

    }

    @Test
    void añadirPlato() {
    }

    @Test
    void mostrarMenu() {
    }

    @Test
    void verPedidos() {
        //Given
        Cliente cliente = new Cliente(1234);
        Pedidos pedidos = new Pedidos();
        pedidos.nuevoPedido(cliente.getId());
        pedidos.nuevoPedido(cliente.getId());
        pedidos.nuevoPedido(cliente.getId());

        //When
        when(restaurante.verPedidos(cliente.getId())).thenReturn(pedidos.verPedidos(cliente.getId()));

        //Then
        assertEquals(daoClientes.verPedidos(cliente.getId()),restaurante.verPedidos(cliente.getId()));
        assertThat(daoClientes.verPedidos(cliente.getId())).isNotEmpty().hasSize(3);
    }

    @Test
    void eliminarPlato() {
    }
    @ParameterizedTest
    @CsvSource({"hola10","hola20","hola50"})
    void validarCupon(String cupon) {
        //Given
        Cliente cliente = new Cliente(1234);
        List<Promocion> cupones = new ArrayList<>();
        cupones.add(new Promocion("hola10"));
        cupones.add(new Promocion("hola20"));
        cupones.add(new Promocion("hola30"));
        cliente.setPromociones(cupones);

        //When

        //Then
        //assertThat(daoClientes.validarCupon(cupon))(restaurante.validarCupon(cupon,cliente.getId()));
    }

    @Test
    void horaEntrega() {
        //Given
        Pedido pedido = new Pedido(1234);

        //When
        try {
            when(restaurante.horaEntrega(pedido.getIdPedido())).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        } catch (PedidoNoEncontrado e) {
            throw new RuntimeException(e);
        }
        //Then
        try {
            assertEquals(daoClientes.horaEntrega(pedido.getIdPedido()),restaurante.horaEntrega(pedido.getIdPedido())); //el daoClientes.horaEntrega que va a devolver??
        } catch (PedidoNoEncontrado e) {
            throw new RuntimeException(e);
        }

        //Given


        //When
        try {
            when(restaurante.horaEntrega(0000)).thenThrow(new PedidoNoEncontrado());
        } catch (PedidoNoEncontrado e) {
            throw new RuntimeException(e);
        }

        //Then alguna otra forma de buscar que lanza las excepciones??
        try {
            daoClientes.horaEntrega(0000);
        } catch (PedidoNoEncontrado e) {
            assertThat(e).isInstanceOf(PedidoNoEncontrado.class);
        }

    }
}