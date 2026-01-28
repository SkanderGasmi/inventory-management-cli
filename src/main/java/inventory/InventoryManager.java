package inventory;

import java.util.*;

/**
 * Main business logic class that manages inventory operations.
 */
public class InventoryManager {

    private final Map<String, Product> products;

    public InventoryManager() {
        products = new HashMap<>();
    }

    /**
     * Add product to inventory using Factory pattern.
     */
    public void addProduct(String id, String name, String type, double price, int quantity) {
        try {
            Product product = ProductFactory.createProduct(id, name, type, price, quantity);
            products.put(id, product);
            System.out.println("Added product: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add product: " + e.getMessage());
        }
    }

    /**
     * Sell product using Strategy pattern for discounts.
     */
    public void sellProduct(String id, int quantity, String discountType) {
        Product product = products.get(id);
        if (product == null) {
            System.out.println("Product ID not found: " + id);
            return;
        }
        if (!product.isInStock() || quantity > product.getQuantity()) {
            System.out.println("Insufficient stock for product: " + product.getName());
            return;
        }

        DiscountCalculator.DiscountResult discountResult = DiscountCalculator.calculateDiscount(product, quantity,
                discountType);

        double originalPrice = product.getPrice() * quantity;
        double finalPrice = originalPrice - discountResult.getDiscountAmount();

        product.sell(quantity);

        System.out.printf("Sold %d x %s%n", quantity, product.getName());
        System.out.printf("Original Price: %.2f%n", originalPrice);
        System.out.printf("Discount: %.2f (%s)%n", discountResult.getDiscountAmount(), discountResult.getDescription());
        System.out.printf("Final Price: %.2f%n", finalPrice);
    }

    /**
     * Add stock to existing product.
     */
    public void addStock(String id, int quantity) {
        Product product = products.get(id);
        if (product == null) {
            System.out.println("Product ID not found: " + id);
            return;
        }
        product.addStock(quantity);
        System.out.println("Added " + quantity + " units to product: " + product.getName());
    }

    /**
     * Display all products in inventory.
     */
    public void viewInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory:");
        products.values().forEach(System.out::println);
    }

    /**
     * Calculate total inventory value.
     */
    public double getInventoryValue() {
        return products.values().stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    /**
     * Get products with low stock.
     */
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getQuantity() <= threshold) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }

    /**
     * Display inventory statistics.
     */
    public void viewStatistics() {
        System.out.println("=== Inventory Statistics ===");
        System.out.println("Total products: " + products.size());
        System.out.printf("Total inventory value: %.2f%n", getInventoryValue());

        List<Product> lowStock = getLowStockProducts(5);
        if (!lowStock.isEmpty()) {
            System.out.println("Low stock products (<=5):");
            lowStock.forEach(p -> System.out.printf("- %s (%d units)%n", p.getName(), p.getQuantity()));
        } else {
            System.out.println("No low stock alerts.");
        }
    }
}
