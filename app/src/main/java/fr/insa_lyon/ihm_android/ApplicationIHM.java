package fr.insa_lyon.ihm_android;

import android.app.Application;

import java.util.ArrayList;

import fr.insa_lyon.ihm_android.model.Direction;

public class ApplicationIHM extends Application {
    public final ArrayList<Direction> directions;

    public ApplicationIHM() {
        directions = new ArrayList<Direction>();
        directions.add(new Direction("Rue saint jean","Rue saint pierre",4));
        directions.add(new Direction("Une rue","Une autre rue",1));
    }
}
