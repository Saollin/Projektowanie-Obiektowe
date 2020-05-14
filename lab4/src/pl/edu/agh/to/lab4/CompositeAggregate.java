package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate {
    private Iterator<? extends Suspect> allPrisoners;
    private Iterator<? extends Suspect> allPersons;
    private Iterator<? extends Suspect> allStudents;

    CompositeAggregate(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase, StudentDataProvider studentDataProvider){
        this.allPrisoners = prisonersDatabase.iterator();
        this.allPersons = personDataProvider.iterator();
        this.allStudents = studentDataProvider.iterator();
    }

    public Iterator<? extends Suspect> composite(){
        List<Suspect> all = new ArrayList<>();
        while(allPrisoners.hasNext()){
            Prisoner prisoner = (Prisoner) allPrisoners.next();
            all.add(prisoner);
        }

        while(allPersons.hasNext()){
            Person person = (Person) allPersons.next();
            all.add(person);
        }

        while(allStudents.hasNext()){
            Student student = (Student) allStudents.next();
            all.add(student);
        }

        return all.iterator();
    }
}
