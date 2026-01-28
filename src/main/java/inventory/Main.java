package inventory;

import java.util.Scanner;

/**
 * Main class providing command-line interface for the inventory system.
 */
public class Main {

    private static InventoryManager manager;
    private static Scanner scanner;

    public static void main(String[] args) {
        manager = new InventoryManager();
        scanner = new Scanner(System.in);

        System.out.println("Welcome to Inventory Management System!");
        loadSampleData();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> manager.viewInventory();
                case 3 -> sellProduct();
                case 4 -> addStock();
                case 5 -> manager.viewStatistics();
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        scanner.close();
    }

    private static void loadSampleData() {
        manager.addProduct("B001", "Java Programming", "BOOK", 29.99, 10);
        manager.addProduct("B002", "Design Patterns", "BOOK", 35.50, 8);
        manager.addProduct("E001", "Laptop", "ELECTRONICS", 999.99, 5);
        manager.addProduct("E002", "Mouse", "ELECTRONICS", 25.99, 15);
    }

    private static void showMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("1. Add Product");
        System.out.println("2. View Inventory");
        System.out.println("3. Sell Product");
        System.out.println("4. Add Stock");
        System.out.println("5. View Statistics");
        System.out.println("6. Exit");
        System.out.print("Enter choice (1-6): ");
    }

    private static int getChoice() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
                System.out.print("Invalid input. Enter a number 1-6: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number 1-6: ");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product type (BOOK/ELECTRONICS): ");
        String type = scanner.nextLine().toUpperCase();
        System.out.print("Enter product price: ");
        double price = getDoubleInput();
        System.out.print("Enter product quantity: ");
        int quantity = getIntInput();

        manager.addProduct(id, name, type, price, quantity);
    }

    private static void sellProduct() {
        System.out.print("Enter product ID to sell: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantity = getIntInput();
        System.out.print("Enter discount type (STUDENT/BULK/NONE): ");
        String discountType = scanner.nextLine().toUpperCase();

        manager.sellProduct(id, quantity, discountType);
    }

    private static void addStock() {
        System.out.print("Enter product ID to add stock: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity to add: ");
        int quantity = getIntInput();

        manager.addStock(id, quantity);
    }

    // Helper methods
    private static int getIntInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input);
                if (value >= 0)
                    return value;
                System.out.print("Please enter a non-negative integer: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter an integer: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0)
                    return value;
                System.out.print("Please enter a non-negative number: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
