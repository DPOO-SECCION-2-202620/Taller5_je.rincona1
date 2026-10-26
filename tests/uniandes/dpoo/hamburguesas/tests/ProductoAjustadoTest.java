package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest
{
    private ProductoMenu productoBase;
    private ProductoAjustado productoAjustado1;

    @BeforeEach
    void setUp() throws Exception
    {
        productoBase = new ProductoMenu("hamburguesa", 15000);
        productoAjustado1 = new ProductoAjustado(productoBase);
    }

    @AfterEach
    void tearDown() throws Exception
    {
    }

    @Test
    void testGetNombre()
    {
        assertEquals("hamburguesa", productoAjustado1.getNombre(), "El nombre del producto ajustado no es el esperado.");
    }

    @Test
    void testGetPrecio()
    {
        assertEquals(15000, productoAjustado1.getPrecio(), "El precio del producto ajustado no es el esperado.");
    } 

	@Test
	void testAgregarIngrediente()
	{
	    Ingrediente queso = new Ingrediente("queso", 2000);
	
	    productoAjustado1.agregarIngrediente(queso);
	
	    assertEquals(17000, productoAjustado1.getPrecio(), "El precio con ingrediente agregado no es el esperado.");
	}
	
	@Test
	void testEliminarIngrediente()
	{
	    Ingrediente queso = new Ingrediente("queso", 2000);
	
	    productoAjustado1.agregarIngrediente(queso);
	    productoAjustado1.eliminarIngrediente(queso);
	
	    assertTrue(productoAjustado1.generarTextoFactura().contains("queso"), "La factura debería mostrar el ingrediente eliminado.");
	}

    @Test
    void testGenerarTextoFactura()
    {
        assertNotNull(productoAjustado1.generarTextoFactura(), "El texto de la factura no debería ser null.");
    }
}