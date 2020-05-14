package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAggregate {
    private final Collection<Student> studentCitizens = new ArrayList<Student>();

    public StudentDataProvider() {
        studentCitizens.add(new Student("Adam", "Bera", 21, "2187894"));
        studentCitizens.add(new Student("Grzegorz", "Janosz", 22, "281749"));
        studentCitizens.add(new Student("Janusz", "Studenciany", 25, "551421"));
        studentCitizens.add(new Student("Karol", "Krawczyk", 24, "214874"));
        studentCitizens.add(new Student("Krzysztof", "Zgredek", 29, "57812"));
    }
    public Collection<Student> getAllStudentsCitizens() {
        return studentCitizens;
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        return studentCitizens.iterator();
    }
}
