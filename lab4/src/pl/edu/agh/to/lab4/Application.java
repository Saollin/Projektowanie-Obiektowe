package pl.edu.agh.to.lab4;

public class Application {

    public static void main(String[] args) {
        CompositeAggregate compositeAggregate = new CompositeAggregate(new PersonDataProvider(), new PrisonersDatabase(),
                new StudentDataProvider());
        Finder suspects = new Finder(compositeAggregate);
        //suspects.display(new NameSearchStrategy("Janusz"));
        //suspects.display(new AgeSearchStrategy(30));
        suspects.display(new CompositeSearchStrategy("Janusz", 30));
    }
}
