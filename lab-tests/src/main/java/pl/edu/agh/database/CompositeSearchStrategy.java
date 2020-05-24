package pl.edu.agh.database;

import pl.edu.agh.internetshop.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {

    private List<SearchStrategy> strategies;

    CompositeSearchStrategy(SearchStrategy... strategies) {
        this.strategies = new ArrayList<>(Arrays.asList(strategies));
    }

    @Override
    public boolean filter(Order order) {
        boolean result = true;
        for(SearchStrategy strategy : strategies) {
            result &= strategy.filter(order);
        }
        return result;
    }
}
