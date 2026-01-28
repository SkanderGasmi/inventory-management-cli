package inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    private InventoryManager manager;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
    }

    @Test
    void testAddProduct() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 5);
        assertEquals(1, manager.getLowStockProducts(10).size()); // stock <= 10
    }

    @Test
    void testAddInvalidProduct() {
        manager.addProduct("B002", "Cheap Book", "BOOK", -1.0, 5);
        assertEquals(0, manager.getLowStockProducts(10).size()); // invalid not added
    }

    @Test
    void testSellProduct() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 5);
        manager.sellProduct("B001", 2, "STUDENT");
        Product p = manager.getLowStockProducts(10).get(0);
        assertEquals(3, p.getQuantity());
    }

    @Test
    void testSellInsufficientStock() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 2);
        manager.sellProduct("B001", 5, "NONE");
        Product p = manager.getLowStockProducts(10).get(0);
        assertEquals(2, p.getQuantity()); // should remain unchanged
    }

    @Test
    void testAddStock() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 2);
        manager.addStock("B001", 5);
        Product p = manager.getLowStockProducts(10).get(0);
        assertEquals(7, p.getQuantity());
    }

    @Test
    void testInventoryValue() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 2);
        manager.addProduct("E001", "Laptop", "ELECTRONICS", 100.0, 1);
        assertEquals(140.0, manager.getInventoryValue());
    }

    @Test
    void testLowStockProducts() {
        manager.addProduct("B001", "Java Book", "BOOK", 20.0, 2);
        manager.addProduct("E001", "Laptop", "ELECTRONICS", 100.0, 10);
        List<Product> lowStock = manager.getLowStockProducts(5);
        assertEquals(1, lowStock.size());
        assertEquals("B001", lowStock.get(0).getId());
    }

    @Test
    void testNonExistentProduct() {
        manager.sellProduct("X001", 1, "NONE"); // should not throw exception
        manager.addStock("X001", 5); // should not throw exception
    }

    @Test
    void testCompleteWorkflow() {
        manager.addProduct("B001", "Book", "BOOK", 20.0, 5);
        manager.sellProduct("B001", 2, "STUDENT");
        manager.addStock("B001", 3);
        Product p = manager.getLowStockProducts(10).get(0);
        assertEquals(6, p.getQuantity());
        assertEquals(120.0, manager.getInventoryValue()); // 6*20
    }
}
