package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;

public interface SearchStrategy {
    boolean filter(Order order);
}
