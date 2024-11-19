package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockItem> items;

    public Stock() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new StockItem(product, quantity));
    }

    public boolean checkAndReduce(Product product, int quantity) {
        for (StockItem item : items) {
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() >= quantity) {
                    item.reduceQuantity(quantity);
                    return true;
                } else {
                    System.out.println("Insufficient stock for product: " + product.getDescription());
                    return false;
                }
            }
        }
        System.out.println("Product " + product.getDescription() + " not found in stock.");
        return false;
    }
}
