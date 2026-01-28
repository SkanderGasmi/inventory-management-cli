package inventory;

/**
 * Product class representing items in the inventory.
 */
public class Product {

    private String id;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Product(String id, String name, String type, double price, int quantity) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters with validation
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public boolean sell(int amount) {
        if (amount <= 0 || amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }

    public void addStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        quantity += amount;
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Product{id='%s', name='%s', type='%s', price=%.2f, quantity=%d}",
                id, name, type, price, quantity);
    }
}
