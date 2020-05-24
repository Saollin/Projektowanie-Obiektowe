package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class PriceSearchStrategy implements SearchStrategy {

    BigDecimal searchedPrice;

    public PriceSearchStrategy(BigDecimal searchedPrice) {
        this.searchedPrice = searchedPrice;
    }

    @Override
    public boolean filter(Order order) {
        return order.getDiscountPrice().compareTo(searchedPrice) == 0;
    }
}
