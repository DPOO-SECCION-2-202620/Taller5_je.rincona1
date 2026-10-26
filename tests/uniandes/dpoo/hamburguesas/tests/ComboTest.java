package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest
{
    private Combo combo1;
    private Combo combo2;
    private ArrayList<ProductoMenu> itemsCombo;

    @BeforeEach
    void setUp() throws Exception
    {
    	itemsCombo = new ArrayList<ProductoMenu>();

    	itemsCombo.add(new ProductoMenu("hamburguesa", 15000));
    	itemsCombo.add(new ProductoMenu("papas", 5000));
    	itemsCombo.add(new ProductoMenu("gaseosa", 5000));

        combo1 = new Combo("combo familiar", 0.1, itemsCombo);
        combo2 = new Combo("combo familiar sin descuento", 0, itemsCombo);
    }
    
  
    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testGetNombre()
    {
        assertEquals("combo familiar", combo1.getNombre(), "El nombre del combo no es el esperado.");
    }

    @Test
    void testGetPrecio()
    {
        assertEquals(22500, combo1.getPrecio(), "El precio del combo no es el esperado.");
        //sin descuento
        assertEquals(25000, combo2.getPrecio(), "El precio del combo no es el esperado.");
    }

    @Test
    void testGenerarTextoFactura()
    {
        assertNotNull(combo1.generarTextoFactura(), "El texto de la factura no debería ser null.");
    }
}