package pl.edu.agh.to.lab4;

import java.util.Calendar;

import static pl.edu.agh.to.lab4.CalendarData.getCurrentYear;

public class Prisoner extends Suspect{
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public boolean isJailedNow() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }

    public int getJudgementYear() {
        return judgementYear;
    }

    public int getSentenceDuration() {
        return sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }
}
