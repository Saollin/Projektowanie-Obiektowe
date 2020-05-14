package pl.edu.agh.to.lab4;

public class NameSearchStrategy implements SearchStrategy {

    private String name;

    NameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getName().equals(name);
    }
}
