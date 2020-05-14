package pl.edu.agh.to.lab4;

public class Student extends Suspect {

    String index;

    public Student(String name, String lastname, int age, String index) {
        super(name, lastname, age);
        this.index = index;
    }

    @Override
    public boolean canBeAccused() {
        return getAge()>18;
    }
}
