package pl.edu.agh.to.lab4;

public class Person extends Suspect{
    private int age;

    public Person(String name, String lastname, int age) {
        super(name, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
