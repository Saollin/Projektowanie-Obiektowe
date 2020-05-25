package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;

import java.util.*;

public class OrdersDatabase {

    private static Map<UUID, Order> orders = new HashMap<>();

    public static void addOrder(Order newOrder) {
        orders.put(newOrder.getId(), newOrder);
    }

    public static Order getOrder(UUID id) {
        return orders.get(id);
    }

    public static void clearDatabase() {
        orders = new HashMap<>();
    }

    public static List<Order> find(SearchStrategy searchStrategy) {
        List<Order> result = new ArrayList<>();
        for(Order o : orders.values()) {
            if(searchStrategy.filter(o)) {
                result.add(o);
            }
        }
        return result;
    }
}
