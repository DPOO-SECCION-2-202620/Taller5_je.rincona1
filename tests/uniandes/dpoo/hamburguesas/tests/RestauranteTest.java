package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;


public class RestauranteTest
{
    private Restaurante restaurante1;

    @BeforeEach
    void setUp() throws Exception
    {
        restaurante1 = new Restaurante();
    }

    @Test
    void testIniciarPedido() throws YaHayUnPedidoEnCursoException
    {
        restaurante1.iniciarPedido("Juan", "Calle 123");

        assertNotNull(restaurante1.getPedidoEnCurso(), "El pedido en curso no debería ser null.");
    }

    @Test
    void testCerrarPedido() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException
    {
        restaurante1.iniciarPedido("Juan", "Calle 123"); restaurante1.cerrarYGuardarPedido();

        assertNull(restaurante1.getPedidoEnCurso(), "El pedido en curso debería ser null.");
    }

    @Test
    void testGetPedidoEnCurso() throws YaHayUnPedidoEnCursoException
    {
        restaurante1.iniciarPedido("Juan", "Calle 123");

        assertNotNull(restaurante1.getPedidoEnCurso(), "El restaurante debería tener un pedido en curso.");
    }

    @Test
    void testGetMenuBase()
    {
        assertNotNull(restaurante1.getMenuBase(), "El menú base no debería ser null.");
    }

    @Test
    void testGetMenuCombos()
    {
        assertNotNull(restaurante1.getMenuCombos(), "La lista de combos no debería ser null.");
    }
    
    @Test
    void testCerrarYGuardarPedido() throws Exception
    {
        restaurante1.iniciarPedido("Juan", "Calle 123");

        Pedido pedido = restaurante1.getPedidoEnCurso();

        restaurante1.cerrarYGuardarPedido();

        assertNull(restaurante1.getPedidoEnCurso(), "No debería haber un pedido en curso.");

        assertTrue(restaurante1.getPedidos().contains(pedido),  "El pedido debería estar guardado en el historial.");
    }
}