package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {

    private List<SearchStrategy> strategies;

    CompositeSearchStrategy(SearchStrategy... strategies) {
        this.strategies = new ArrayList<>(Arrays.asList(strategies));
    }

    @Override
    public boolean filter(Suspect suspect) {
        boolean result = true;
        for(SearchStrategy strategy : strategies) {
            result &= strategy.filter(suspect);
        }
        return result;
    }
}
