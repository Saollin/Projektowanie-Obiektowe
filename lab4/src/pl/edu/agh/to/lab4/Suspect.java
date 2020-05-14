package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private String name;

    private String lastname;

    private int age;

    public Suspect(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge(){
        return age;
    }

    public abstract boolean canBeAccused();

    @Override
    public String toString() {
        return name + " " + lastname;
    }
}
