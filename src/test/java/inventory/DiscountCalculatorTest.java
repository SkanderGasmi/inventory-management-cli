package inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    private Product book;
    private Product electronics;

    @BeforeEach
    void setUp() {
        book = ProductFactory.createProduct("B001", "Test Book", "BOOK", 20.0, 10);
        electronics = ProductFactory.createProduct("E001", "Test Electronics", "ELECTRONICS", 100.0, 10);
    }

    @Test
    void testStudentDiscountOnBooks() {
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 2, "STUDENT");
        assertEquals(4.0, result.getDiscountAmount());
        assertTrue(result.getDescription().contains("Student discount"));
    }

    @Test
    void testStudentDiscountOnElectronics() {
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(electronics, 2, "STUDENT");
        assertEquals(0.0, result.getDiscountAmount());
        assertTrue(result.getDescription().contains("No discount"));
    }

    @Test
    void testBulkDiscountValid() {
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(electronics, 5, "BULK");
        assertEquals(75.0, result.getDiscountAmount());
        assertTrue(result.getDescription().contains("Bulk discount"));
    }

    @Test
    void testBulkDiscountInvalid() {
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(electronics, 3, "BULK");
        assertEquals(0.0, result.getDiscountAmount());
        assertTrue(result.getDescription().contains("No discount"));
    }

    @Test
    void testNoDiscount() {
        DiscountCalculator.DiscountResult result = DiscountCalculator.calculateDiscount(book, 2, "NONE");
        assertEquals(0.0, result.getDiscountAmount());
        assertTrue(result.getDescription().contains("No discount"));
    }

    @Test
    void testDiscountCalculationAccuracy() {
        DiscountCalculator.DiscountResult r1 = DiscountCalculator.calculateDiscount(book, 2, "STUDENT");
        assertEquals(4.0, r1.getDiscountAmount()); // 10% of 20*2

        DiscountCalculator.DiscountResult r2 = DiscountCalculator.calculateDiscount(electronics, 5, "BULK");
        assertEquals(75.0, r2.getDiscountAmount()); // 15% of 100*5
    }
}
