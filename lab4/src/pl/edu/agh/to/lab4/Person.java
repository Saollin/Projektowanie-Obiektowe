package pl.edu.agh.to.lab4;

public class Person {
    private String name;

    private String lastname;

    private int age;

    public Person(String name, String lastname, int age) {
        this.age = age;
        this.name = name;
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }
}
