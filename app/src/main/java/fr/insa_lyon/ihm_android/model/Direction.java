package fr.insa_lyon.ihm_android.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Direction {
    private final String start;
    private final String end;
    private int numberPerson;
    private final Date heure;
    private final int walk;
    private final int bike;
    private final int tram;

    public Direction(String start, String end, int numberPerson, Date heure, int walk, int bike, int tram) {
        this.start = start;
        this.end = end;
        this.numberPerson = numberPerson;
        this.heure = heure;
        this.walk = walk;
        this.bike = bike;
        this.tram = tram;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public String getStart() {

        return start;
    }

    public String getFormtedDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(this.heure);
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

    public int getWalk() {
        return walk;
    }

    public int getBike() {
        return bike;
    }

    public int getTram() {
        return tram;
    }
}
