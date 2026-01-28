package inventory;

/**
 * Strategy pattern implementation for calculating different types of discounts.
 */
public class DiscountCalculator {

    /**
     * Inner class to hold discount calculation results.
     */
    public static class DiscountResult {
        private final double discountAmount;
        private final String description;

        public DiscountResult(double discountAmount, String description) {
            this.discountAmount = discountAmount;
            this.description = description;
        }

        public double getDiscountAmount() {
            return discountAmount;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * Calculates discount based on type and quantity.
     *
     * @param product      The product being purchased
     * @param quantity     Quantity being purchased
     * @param discountType Type of discount (STUDENT, BULK, NONE)
     * @return DiscountResult with amount and description
     */
    public static DiscountResult calculateDiscount(Product product, int quantity, String discountType) {
        double discountAmount = 0.0;
        String description = "No discount applied";

        switch (discountType.toUpperCase()) {
            case "STUDENT":
                if ("BOOK".equals(product.getType())) {
                    discountAmount = product.getPrice() * quantity * 0.10;
                    description = "10% student discount applied";
                }
                break;

            case "BULK":
                if (quantity >= 5) {
                    discountAmount = product.getPrice() * quantity * 0.15;
                    description = "15% bulk purchase discount applied";
                }
                break;

            case "NONE":
            default:
                // No discount
                break;
        }

        return new Disco
