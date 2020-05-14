package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    //private final Collection<Person> allPersons;

    //private final Map<String, Collection<Prisoner>> allPrisoners;
/*
    private Iterator<? extends Suspect> allPrisoners;
    private Iterator<? extends Suspect> allPersons;*/
    /*
    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisoners) {
        this.allPersons = allPersons;
        this.allPrisoners = allPrisoners;
    }
*/
    /*
    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this.allPersons = personDataProvider.iterator();
        this.allPrisoners = prisonersDatabase.iterator();
    }*/
    private Iterator<? extends Suspect> all;

    public Finder(CompositeAggregate compositeAggregate){
        all = compositeAggregate.composite();
    }

    public void display(SearchStrategy searchStrategy) {

        ArrayList<Suspect> suspects = new ArrayList<>();

        while (all.hasNext()) {
            Suspect suspect = all.next();
            if (suspect.canBeAccused() && searchStrategy.filter(suspect)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n);
        }
    }
    /*PRZED 6
    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<>();

        while(all.hasNext()){
            Suspect suspect = all.next();
            if (suspect.canBeAccused() && suspect.getName().equals(name)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n);
        }

        /*PRZED 5
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<>();
        ArrayList<Person> suspectedPersons = new ArrayList<>();

        Prisoner prisoner;

        while(allPrisoners.hasNext()){
            prisoner = (Prisoner) allPrisoners.next();
            if (!prisoner.isJailedNow() && prisoner.getName().equals(name)) {
                suspectedPrisoners.add(prisoner);
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        Person person;
        if (suspectedPrisoners.size() < 10) {
            while(allPersons.hasNext()) {
                person = (Person) allPersons.next();
                if (person.getAge() > 18 && person.getName().equals(name)) {
                    suspectedPersons.add(person);
                }
                if (suspectedPrisoners.size() + suspectedPersons.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedPersons.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n);
        }

        for (Person p : suspectedPersons) {
            System.out.println(p);
        }*/
        /*PRZED 4 PODOUNTEM
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<>();
        ArrayList<Person> suspectedPersons = new ArrayList<>();



        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (!prisoner.isJailedNow() && prisoner.getName().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (Person person : allPersons) {
                if (person.getAge() > 18 && person.getName().equals(name)) {
                    suspectedPersons.add(person);
                }
                if (suspectedPrisoners.size() + suspectedPersons.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedPersons.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n);
        }

        for (Person p : suspectedPersons) {
            System.out.println(p);
        }


    }*/


}
