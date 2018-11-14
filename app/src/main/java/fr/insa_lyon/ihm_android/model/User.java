package fr.insa_lyon.ihm_android.model;

import java.util.Random;

public class User {
    private final String name;
    private final String color;

    public User(String name) {
        this.name = name;
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while(sb.length() < 7){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        color = sb.toString().substring(0, 7);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
