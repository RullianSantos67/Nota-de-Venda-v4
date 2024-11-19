package model;

public class SalesManager {
    private Stock stock;

    public SalesManager(Stock stock) {
        this.stock = stock;
    }

    public Sale createSale() {
        return new Sale();
    }

    public void addItemToSale(Sale sale, Product product, int quantity) {
        if (stock.checkAndReduce(product, quantity)) {
            sale.createSaleItem(product, quantity);
            System.out.println("Item " + product.getDescription() + " added to the sale.");
        } else {
            System.out.println("Failed to add " + product.getDescription() + " to the sale.");
        }
    }

    public void processPayment(Sale sale, String paymentMethod) {
        double total = sale.getTotal();
        System.out.println("\nSelected payment method: " + paymentMethod);
        System.out.println("Total amount to pay: $ " + total);
        System.out.println("Sale completed successfully!");
    }
}
