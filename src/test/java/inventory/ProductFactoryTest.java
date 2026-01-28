package inventory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void testCreateValidBook() {
        Product book = ProductFactory.createProduct("B001", "Java Book", "BOOK", 20.0, 10);
        assertEquals("B001", book.getId());
        assertEquals("Java Book", book.getName());
        assertEquals("BOOK", book.getType());
        assertEquals(20.0, book.getPrice());
        assertEquals(10, book.getQuantity());
    }

    @Test
    void testCreateValidElectronics() {
        Product e = ProductFactory.createProduct("E001", "Laptop", "ELECTRONICS", 1000.0, 5);
        assertEquals("E001", e.getId());
        assertEquals("Laptop", e.getName());
        assertEquals("ELECTRONICS", e.getType());
        assertEquals(1000.0, e.getPrice());
        assertEquals(5, e.getQuantity());
    }

    @Test
    void testBookMinimumPriceValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ProductFactory.createProduct("B002", "Cheap Book", "BOOK", 4.99, 5));
        assertTrue(ex.getMessage().contains("minimum price"));
    }

    @Test
    void testElectronicsMinimumPriceValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ProductFactory.createProduct("E002", "Cheap Phone", "ELECTRONICS", 9.99, 5));
        assertTrue(ex.getMessage().contains("minimum price"));
    }

    @Test
    void testInvalidProductType() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ProductFactory.createProduct("X001", "Invalid", "FOOD", 10.0, 1));
        assertTrue(ex.getMessage().contains("Invalid product type"));
    }

    @Test
    void testBoundaryConditions() {
        Product book = ProductFactory.createProduct("B003", "Edge Book", "BOOK", 5.0, 1);
        assertNotNull(book);
        Product e = ProductFactory.createProduct("E003", "Edge Electronics", "ELECTRONICS", 10.0, 1);
        assertNotNull(e);
    }
}
