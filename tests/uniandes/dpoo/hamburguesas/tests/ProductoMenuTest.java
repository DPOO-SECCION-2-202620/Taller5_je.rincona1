package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest
{
    private ProductoMenu producto1;
    private ProductoMenu producto2;
    private ProductoMenu producto3;

    @BeforeEach
    void setUp() throws Exception
    {
        producto1 = new ProductoMenu("hamburguesa", 15000);
        producto2 = new ProductoMenu("papas", 5000);
        producto3 = new ProductoMenu("gaseosa", 3000);
    }

    @AfterEach
    void tearDown() throws Exception
    {
    }

    @Test
    void testGetNombre()
    {
        assertEquals("hamburguesa", producto1.getNombre(), "El nombre del producto no es el esperado.");
    }

    @Test
    void testGetPrecio()
    {
        assertEquals(15000, producto1.getPrecio(), "El precio del producto no es el esperado.");
    }

    @Test
    void testGenerarTextoFactura()
    {
        assertNotNull(producto1.generarTextoFactura(), "El texto de la factura no debería ser null.");
    }
}
