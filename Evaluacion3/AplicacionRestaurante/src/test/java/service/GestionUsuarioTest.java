package service;

import dao.DaoClientes;
import domain.Pedido;
import domain.Plato;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GestionUsuarioTest {
    @InjectMocks
    GestionUsuario gestionUsuario;
    @Mock
    DaoClientes daoClientes;

    @Test
    void mostrarMenu() {
        //Given
        HashSet<Plato> carta = new HashSet<>();
        carta.add(new Plato("Refresco Grande",1.99,"","Acompañante"));
        carta.add(new Plato("Batido de Frutas",3.49,"","Acompañante"));
        carta.add(new Plato("Nachos con Queso",4.99,"","Acompañante"));
        carta.add(new Plato("Palitos de Zanahoria y Apio con Hummus",3.49,"","Acompañante"));

        //When
        StringBuilder sb = new StringBuilder();
        carta.forEach(p -> sb.append(p.toString()));
        when(gestionUsuario.mostrarMenu()).thenReturn(sb.toString());

        //Then
        assertEquals(gestionUsuario.mostrarMenu(), sb.toString());
    }

    @Test
    void pedirCuenta() {
    }

    @Test
    void añadirPlato() {
    }

    @Test
    void mostrarCarrito() {

    }

    @Test
    void eliminarPlato() {

    }

    @Test
    void añadirCodigo() {
    }

    @Test
    void existePedido() {
        //Given
        Pedido pedido = new Pedido();

        //When
        when(daoClientes.e)
    }

    @Test
    void darIDPedido() {
        //Given
        Pedido pedido = new Pedido();
        int idPedido = pedido.getIdPedido();
        int entrada2 = 1234;
        String nombreUsuario = "Jorge";

        //When
        when(gestionUsuario.darIDPedido(nombreUsuario)).thenReturn(idPedido);

        //Then
        assertEquals(idPedido, pedido.getIdPedido());
        assertNotEquals(idPedido, entrada2);
    }

    @Test
    void nuevoPedido() {
    }

    @Test
    void iniciarPedido() {
    }
}