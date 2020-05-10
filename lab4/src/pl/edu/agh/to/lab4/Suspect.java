package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private String name;

    private String lastname;

    public Suspect(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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
