package dao;

import domain.Plato;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoPersonalTest {
    @InjectMocks
    DaoPersonal daoPersonal;
    @Mock
    Restaurante restaurante;

    @Test
    void verComandas() { //preguntar a Gema por el roden y el sentido de este test
        //Given
        Pedidos pedidos = new Pedidos();
        pedidos.nuevoPedido(1234);
        pedidos.nuevoPedido(4321);
        StringBuilder sb = new StringBuilder();
        pedidos.getPedidos().stream().forEach(sb::append);
        String misPedidos = sb.toString();

        //When
        when(restaurante.verComandas()).thenReturn(misPedidos);

        //Then
        assertEquals(daoPersonal.verComandas(),restaurante.verComandas());
    }

    @Test
    void verCarta() {
    }

    @Test
    void cambiarPrecio() {
    }

    @Test
    void eliminarCarta() { //si quiero comprobar que al devolver false sigue la carta intacta como lo hago??
        //Given
        HashSet<Plato> carta = new HashSet<>();
        carta.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
        carta.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
        carta.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));

        //When
        when(restaurante.eliminarCarta()).thenReturn(true);

        //Then
        assertAll( () -> {
                assertTrue(daoPersonal.eliminarCarta());
                assertThat(daoPersonal.verCarta()).isEqualTo("");
                }
        );
    }
}