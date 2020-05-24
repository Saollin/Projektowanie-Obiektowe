package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;

public class ProductNameSearchStrategy implements SearchStrategy{

    private String productName;

    public ProductNameSearchStrategy(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filter(Order order) {
        for(Product p : order.getProducts()) {
            if(p.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
