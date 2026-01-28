package inventory;

/**
 * Strategy pattern implementation for calculating different types of discounts.
 * TODO: Implement the Strategy pattern with multiple discount algorithms.
 *
 * Requirements:
 * - Student discount: 10% off books only
 * - Bulk discount: 15% off when buying 5+ items
 * - No discount option
 * - Return discount amount and description
 */
public class DiscountCalculator {

    /**
     * Inner class to hold discount calculation results.
     * TODO: Implement this class with discount amount and description.
     */
    public static class DiscountResult {
        // TODO: Implement DiscountResult class
        // private double discountAmount;
        // private String description;

        // TODO: Add constructor
        // public DiscountResult(double discountAmount, String description) { }

        // TODO: Add getter methods
        // public double getDiscountAmount() { }
        // public String getDescription() { }
    }

    /**
     * TODO: Implement strategy method for calculating discounts
     * @param product - the product being purchased
     * @param quantity - quantity being purchased
     * @param discountType - type of discount to apply (STUDENT, BULK, NONE)
     * @return DiscountResult with amount and description
     */
    public static DiscountResult calculateDiscount(Product product, int quantity, String discountType) {
        // TODO: Implement discount calculation logic

        // Initialize variables
        // double discountAmount = 0.0;
        // String description = "No discount applied";

        // TODO: Implement switch statement or if-else logic for discount types
        // Case "STUDENT":
        //   - Check if product type is "BOOK"
        //   - Apply 10% discount if applicable
        //   - Set appropriate description

        // Case "BULK":
        //   - Check if quantity >= 5
        //   - Apply 15% discount if applicable
        //   - Set appropriate description

        // Case "NONE" or default:
        //   - No discount applied

        // TODO: Return new DiscountResult with calculated values
        return null; // Placeholder
    }

    // TODO: Optional - Add helper methods
    // private static boolean isEligibleForStudentDiscount(Product product) { }
    // private static boolean isEligibleForBulkDiscount(int quantity) { }
}