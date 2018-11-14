package fr.insa_lyon.ihm_android.model;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Direction {
    private final String start;
    private final String end;
    private int numberPerson;
    private final Calendar heure;

    public Direction(String start, String end, int numberPerson, Calendar heure) {
        this.start = start;
        this.end = end;
        this.numberPerson = numberPerson;
        this.heure = heure;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public String getStart() {

        return start;
    }

    public String getFormtedDate()
    {
        Date d = heure.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(d);
    }

    public String getEnd() {
        return end;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", numberPerson=" + numberPerson +
                ", heure=" + heure +
                '}';
    }
}
