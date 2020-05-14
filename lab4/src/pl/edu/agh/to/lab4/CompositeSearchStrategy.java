package pl.edu.agh.to.lab4;

public class CompositeSearchStrategy implements SearchStrategy {

    private int age;
    private String name;

    CompositeSearchStrategy(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return (suspect.getName().equals(this.name) && suspect.getAge() == age);
    }
}
