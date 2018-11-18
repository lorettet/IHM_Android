package fr.insa_lyon.ihm_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import fr.insa_lyon.ihm_android.adapter.DirectionAdapter;
import fr.insa_lyon.ihm_android.model.Direction;

public class DirectionsActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        mRecyclerView = (RecyclerView) findViewById(R.id.DirectionList);

        List<Direction> dirs = ((ApplicationIHM) getApplication()).directions;

        DirectionAdapter adapter = new DirectionAdapter(dirs);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void newTrajet(View v){
        Intent intent =new Intent(DirectionsActivity.this, NewDirectionActivity.class);
        startActivity(intent);
    }

    public void openDirection(View v)
    {
        Intent intent =new Intent(DirectionsActivity.this, RecapDirectionActivity.class);
        startActivity(intent);
    }
}
