package fr.insa_lyon.ihm_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import fr.insa_lyon.ihm_android.adapter.DirectionAdapter;
import fr.insa_lyon.ihm_android.adapter.MessageAdapter;
import fr.insa_lyon.ihm_android.model.Direction;
import fr.insa_lyon.ihm_android.model.Message;

public class ChatActivity extends AppCompatActivity {

    private ListView listView;
    private MessageAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        listView =  findViewById(R.id.messages_view);

        List<Message> msgs = ((ApplicationIHM) getApplication()).messages;

        MessageAdapter adapter = new MessageAdapter(this);
        for (Message m : msgs)
        {
            adapter.add(m);
        }
        listView.setAdapter(adapter);

    }
}
