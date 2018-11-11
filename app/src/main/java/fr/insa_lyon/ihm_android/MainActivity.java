package fr.insa_lyon.ihm_android;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR8DIALOG8REQUEST = 9001;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    if(isServicesOK()) {
                        selectedFragment = new MapFragment();
                    }
                    break;
                case R.id.navigation_directions:
                    selectedFragment = new DirectionsFragment();
                    break;
                case R.id.navigation_group:
                    selectedFragment = new GroupFragment();
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

    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: cheking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        
        if(available == ConnectionResult.SUCCESS)
        {
            // everything fine!
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }else if (GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            // Issue fixable
            Log.d(TAG, "isServicesOK: an error occured but is fixable");
            Dialog dialog =  GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR8DIALOG8REQUEST);
            dialog.show();
        }else{
            Toast.makeText(MainActivity.this,"This will not work :(",Toast.LENGTH_SHORT);
        }
        return false;
    }

}
