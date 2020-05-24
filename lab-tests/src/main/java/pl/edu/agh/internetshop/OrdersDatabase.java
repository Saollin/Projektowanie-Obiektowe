package pl.edu.agh.internetshop;

import java.util.*;

public class OrdersDatabase {

    private static Map<UUID, Order> orders = new HashMap<>();

    public static void addOrder(Order newOrder) {
        orders.put(newOrder.getId(), newOrder);
    }

    public static Order getOrder(UUID id) {
        return orders.get(id);
    }
}
