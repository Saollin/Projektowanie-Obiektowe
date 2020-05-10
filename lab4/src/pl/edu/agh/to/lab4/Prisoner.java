package pl.edu.agh.to.lab4;

import java.util.Calendar;

import static pl.edu.agh.to.lab4.CalendarData.getCurrentYear;

public class Prisoner {
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;

    private final String name;

    private final String surname;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }


    public boolean isJailedNow() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public int getJudgementYear() {
        return judgementYear;
    }

    public int getSentenceDuration() {
        return sentenceDuration;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }
}
