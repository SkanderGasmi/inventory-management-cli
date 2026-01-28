package inventory;

import java.util.*;

/**
 * Main business logic class that manages inventory operations.
 * TODO: Implement inventory management using Factory and Strategy patterns.
 *
 * Requirements:
 * - Use ProductFactory for creating products
 * - Use DiscountCalculator for sales with discounts
 * - Maintain product collection
 * - Provide inventory operations and statistics
 */
public class InventoryManager {

    // TODO: Declare collection to store products
    // private Map<String, Product> products;

    /**
     * TODO: Implement constructor
     */
    public InventoryManager() {
        // TODO: Initialize the products collection
    }

    /**
     * TODO: Add product to inventory using Factory pattern
     * @param id - product identifier
     * @param name - product name
     * @param type - product type
     * @param price - product price
     * @param quantity - initial quantity
     */
    public void addProduct(String id, String name, String type, double price, int quantity) {
        // TODO: Implement product addition
        // Use ProductFactory.createProduct()
        // Handle exceptions and display appropriate messages
        // Add product to collection if successful
    }

    /**
     * TODO: Sell product with discount using Strategy pattern
     * @param id - product identifier
     * @param quantity - quantity to sell
     * @param discountType - type of discount to apply
     */
    public void sellProduct(String id, int quantity, String discountType) {
        // TODO: Implement sales logic
        // 1. Find product by ID
        // 2. Validate stock availability
        // 3. Calculate discount using DiscountCalculator
        // 4. Calculate total price and final price
        // 5. Update product quantity
        // 6. Display sale information
    }

    /**
     * TODO: Add stock to existing product
     * @param id - product identifier
     * @param quantity - quantity to add
     */
    public void addStock(String id, int quantity) {
        // TODO: Implement stock addition
        // Find product and add stock
        // Display confirmation message
    }

    /**
     * TODO: Display all products in inventory
     */
    public void viewInventory() {
        // TODO: Implement inventory display
        // Check if inventory is empty
        // Display all products with formatting
    }

    /**
     * TODO: Calculate total inventory value
     * @return total value of all products
     */
    public double getInventoryValue() {
        // TODO: Calculate total value
        // Iterate through products and sum (price * quantity)
        return 0.0; // Placeholder
    }

    /**
     * TODO: Get products with low stock
     * @param threshold - minimum stock level
     * @return list of products below threshold
     */
    public List<Product> getLowStockProducts(int threshold) {
        // TODO: Implement low stock detection
        // Filter products with quantity <= threshold
        return new ArrayList<>(); // Placeholder
    }

    /**
     * TODO: Display inventory statistics
     */
    public void viewStatistics() {
        // TODO: Implement statistics display
        // Show total products count
        // Show total inventory value
        // Show low stock alerts (threshold = 5)
    }

    // TODO: Optional helper methods
    // private boolean productExists(String id) { }
    // private void displaySalesSummary(Product product, int quantity, double originalPrice, double finalPrice, String discountInfo) { }
}