package fr.insa_lyon.ihm_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR8DIALOG8REQUEST = 9001;
    private Menu topMenu;
    MapFragment mapFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_map:
                        selectedFragment = new MapFragment();
                        mapFragment = (MapFragment) selectedFragment;
                        if(topMenu != null)
                            topMenu.findItem(R.id.leaveGroup).setVisible(false);
                    break;
                case R.id.navigation_directions:
                    selectedFragment = new DirectionsFragment();
                    if(topMenu != null)
                        topMenu.findItem(R.id.leaveGroup).setVisible(false);
                    break;
                case R.id.navigation_group:
                    selectedFragment = new GroupFragment();
                    if(topMenu != null)
                        topMenu.findItem(R.id.leaveGroup).setVisible(true);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_map);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        topMenu = menu;
        return true;
    }

    public void alert(View v)
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmation");
        alertBuilder.setMessage("Etes-vous sûr de vouloir signaler une zone dangereuse à cet endroit?");
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Votre signalement a été pris en compte",Toast.LENGTH_LONG).show();
                mapFragment.setNewArea();
            }
        });
        alertBuilder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();

    }
    public void metho(View button2) {
        Intent intent =new Intent(MainActivity.this, DirectionsActivity.class);
        startActivity(intent);
    }

    public void openChat(View chatButton)
    {
        Intent intent =new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
    }

}
