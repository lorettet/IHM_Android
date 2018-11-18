package fr.insa_lyon.ihm_android;

import android.app.Application;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;

import fr.insa_lyon.ihm_android.model.Direction;
import fr.insa_lyon.ihm_android.model.Message;
import fr.insa_lyon.ihm_android.model.User;

public class ApplicationIHM extends Application {
    public final ArrayList<Direction> directions;
    public final ArrayList<Message> messages;

    public ApplicationIHM() {
        directions = new ArrayList<Direction>();
        Calendar cal = Calendar.getInstance();
        cal.set(2018,11,22,00,30);
        directions.add(new Direction("Rue saint jean","Rue saint pierre",4,cal.getTime(), View.VISIBLE, View.INVISIBLE, View.INVISIBLE));
        cal.set(2018,11,22,1,10);
        directions.add(new Direction("Une rue","Une autre rue",1, cal.getTime(), View.INVISIBLE, View.VISIBLE, View.INVISIBLE));
        cal.set(2018,11,22,1,30);
        directions.add(new Direction("Une rue","Une autre rue",1, cal.getTime(), View.INVISIBLE, View.VISIBLE, View.INVISIBLE));
        cal.set(2018,11,22,2,00);
        directions.add(new Direction("Une rue","Une autre rue",5, cal.getTime(), View.INVISIBLE, View.VISIBLE, View.INVISIBLE));
        cal.set(2018,11,22,2,00);
        directions.add(new Direction("Une rue","Une autre rue",5, cal.getTime(), View.VISIBLE, View.INVISIBLE, View.VISIBLE));
        cal.set(2018,11,22,2,00);
        directions.add(new Direction("Une rue","Une autre rue",5, cal.getTime(), View.INVISIBLE, View.VISIBLE, View.INVISIBLE));

        messages = new ArrayList<Message>();
        User user1 = new User("Arthur");
        User user2 = new User("Marion");
        User user3 = new User("Joseph");

        Message msg = new Message("Salut! J'espère que vous passez une bonne soirée, on se retrouve bien à 00h30!",user1,false);
        messages.add(msg);
        msg = new Message("Parfait, on se retrouve la bas, c'est bon pour toi Joseph?",user2,false);
        messages.add(msg);
        msg = new Message("Nickel!",user3,true);
        messages.add(msg);
    }
}
