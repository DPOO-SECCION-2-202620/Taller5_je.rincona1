package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class PedidoTest
{
    private Pedido pedido1;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    void setUp() throws Exception
    {
        pedido1 = new Pedido("Juan", "Calle 123");

        producto1 = new ProductoMenu("hamburguesa", 15000);
        producto2 = new ProductoMenu("papas", 5000);
    }

    
    @Test
    void testGetIdPedido()
    {
    	assertNotNull(pedido1.getIdPedido(), "El ID del pedido no debería ser null.");
    }

    
    @Test
    void testGetNombreCliente()
    {
        assertEquals("Juan", pedido1.getNombreCliente(), "El nombre del cliente no es el esperado.");
    }

   
    @Test
    void testGenerarTextoFactura()
    {
        pedido1.agregarProducto(producto1);

        assertNotNull(pedido1.generarTextoFactura(), "El texto de la factura no debería ser null.");
    }
    
    
    @Test
    void testGuardarFactura() throws Exception
    {
        pedido1.agregarProducto(producto1);

        File factura = new File("facturas/facturaTest.txt");
        pedido1.guardarFactura(factura);

        assertTrue(factura.exists(), "La factura debería haberse guardado.");
    }
}