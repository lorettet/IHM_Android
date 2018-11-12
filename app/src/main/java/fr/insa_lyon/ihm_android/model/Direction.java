package fr.insa_lyon.ihm_android.model;

public class Direction {
    private final String start;
    private final String end;
    private int numberPerson;

    public Direction(String start, String end, int numberPerson) {
        this.start = start;
        this.end = end;
        this.numberPerson = numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public String getStart() {

        return start;
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
                '}';
    }
}
