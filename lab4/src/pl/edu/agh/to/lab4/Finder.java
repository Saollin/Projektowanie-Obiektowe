package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private Iterator<? extends Suspect> all;

    public Finder(CompositeAggregate compositeAggregate){
        all = compositeAggregate.composite();
    }

    public void display(SearchStrategy searchStrategy) {

        ArrayList<Suspect> suspects = new ArrayList<>();

        while (all.hasNext()) {
            Suspect suspect = all.next();
            if (suspect.canBeAccused() && searchStrategy.filter(suspect)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n);
        }
    }
}
