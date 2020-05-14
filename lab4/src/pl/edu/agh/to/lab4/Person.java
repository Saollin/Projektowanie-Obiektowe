package pl.edu.agh.to.lab4;

public class Person extends Suspect{

    public Person(String name, String lastname, int age) {
        super(name, lastname, age);
    }

    public boolean canBeAccused() { return getAge()>18; }
}
