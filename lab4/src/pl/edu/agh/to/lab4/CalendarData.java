package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class CalendarData {
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
