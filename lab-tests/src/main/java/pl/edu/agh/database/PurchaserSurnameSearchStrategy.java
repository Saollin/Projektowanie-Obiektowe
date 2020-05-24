package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;

public class PurchaserSurnameSearchStrategy implements SearchStrategy {

    private String surname;

    public PurchaserSurnameSearchStrategy(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean filter(Order order) {
        return order.getPurchaser().getSurname().equals(surname);
    }
}
