package inventory;

import java.util.Scanner;

/**
 * Main class providing command-line interface for the inventory system.
 * TODO: Implement a complete menu-driven CLI application.
 *
 * Requirements:
 * - Menu with 6 options: Add, View, Sell, Stock, Statistics, Exit
 * - Input validation and error handling
 * - Sample data for testing
 * - User-friendly interface
 */
public class Main {

    // TODO: Declare class-level variables
    // private static InventoryManager manager;
    // private static Scanner scanner;

    /**
     * TODO: Implement main method
     */
    public static void main(String[] args) {
        // TODO: Initialize manager and scanner
        // Load sample data
        // Start main application loop

        System.out.println("Welcome to Inventory Management System!");
        // loadSampleData();

        // TODO: Implement main loop
        // while (true) {
        //     showMenu();
        //     int choice = getChoice();
        //     handleChoice(choice);
        // }
    }

    /**
     * TODO: Load sample data for testing
     */
    private static void loadSampleData() {
        // TODO: Add sample products for testing
        // Example: Books and Electronics with different prices
        // manager.addProduct("B001", "Java Programming", "BOOK", 29.99, 10);
        // manager.addProduct("B002", "Design Patterns", "BOOK", 35.50, 8);
        // manager.addProduct("E001", "Laptop", "ELECTRONICS", 999.99, 5);
        // manager.addProduct("E002", "Mouse", "ELECTRONICS", 25.99, 15);
    }

    /**
     * TODO: Display main menu options
     */
    private static void showMenu() {
        // TODO: Display formatted menu
        // 1. Add Product
        // 2. View Inventory
        // 3. Sell Product
        // 4. Add Stock
        // 5. View Statistics
        // 6. Exit
    }

    /**
     * TODO: Get user choice with input validation
     * @return user's menu choice
     */
    private static int getChoice() {
        // TODO: Implement input validation
        // Handle invalid input gracefully
        // Return valid choice between 1-6
        return 0; // Placeholder
    }

    /**
     * TODO: Handle user menu choice
     * @param choice - user's selected option
     */
    private static void handleChoice(int choice) {
        // TODO: Implement switch statement for menu options
        // case 1: addProduct(); break;
        // case 2: manager.viewInventory(); break;
        // case 3: sellProduct(); break;
        // case 4: addStock(); break;
        // case 5: manager.viewStatistics(); break;
        // case 6: exit application
        // default: invalid choice message
    }

    /**
     * TODO: Handle adding new product
     */
    private static void addProduct() {
        // TODO: Get product details from user input
        // Prompt for: id, name, type, price, quantity
        // Call manager.addProduct() with inputs
    }

    /**
     * TODO: Handle selling product
     */
    private static void sellProduct() {
        // TODO: Get sale details from user input
        // Prompt for: product ID, quantity, discount type
        // Call manager.sellProduct() with inputs
    }

    /**
     * TODO: Handle adding stock
     */
    private static void addStock() {
        // TODO: Get stock details from user input
        // Prompt for: product ID, quantity to add
        // Call manager.addStock() with inputs
    }

    // TODO: Add helper methods for input validation
    // private static String getStringInput(String prompt) { }
    // private static int getIntInput(String prompt) { }
    // private static double getDoubleInput(String prompt) { }
}