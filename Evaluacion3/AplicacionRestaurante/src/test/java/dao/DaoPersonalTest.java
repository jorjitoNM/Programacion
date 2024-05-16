package dao;

import domain.Plato;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
class DaoPersonalTest {
    @InjectMocks
    DaoPersonal daoPersonal;
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
    @DisplayName("Ver los pedidos en curso")
    @Test
    void verComandas() { //preguntar a Gema por el orden y el sentido de este test
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
    @Order(1)
    @DisplayName("Eliminar la carta del restaurante")
    @Test
    void eliminarCarta() { //si quiero comprobar que al devolver false sigue la carta intacta como lo hago??
        //Given

        //When
        when(restaurante.eliminarCarta()).thenReturn(true);

        //Then
        assertAll( () -> {
                assertTrue(daoPersonal.eliminarCarta());
                }
        );
        //Given
        HashSet<Plato> carta2 = new HashSet<>();
        carta2.add(new Plato("Wrap de Vegetales a la Parrilla",6.49,"Aguacate, salsa picante ($0.50 cada uno)","Principal"));
        carta2.add(new Plato("Fajitas de Camarones",12.49,"Pimientos, cebollas, tortillas de harina ($1.00 cada uno)","Principal"));
        carta2.add(new Plato("Pollo a la Parrilla con Vegetales",7.99,"Salsa de teriyaki, queso cheddar ($0.50 cada uno)","Principal"));
        carta2.add(new Plato("Papas Fritas",2.99,"Queso fundido, salsa BBQ ($0.50 cada uno)","Guarnición"));

        carta2.forEach(System.out::println);
        //When
        when(restaurante.eliminarCarta()).thenReturn(false);

        //Then
        assertAll( () -> {
            assertFalse(daoPersonal.eliminarCarta());
            assertThat(daoPersonal.verCarta()).isEqualTo(restaurante.verCartaAdmin());
        });
    }
}