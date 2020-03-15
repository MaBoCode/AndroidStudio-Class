package com.example.tp6ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isServiceStarted;
    private Intent locationIntent;
    private Button locationServiceButton;

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!isServiceStarted) {
                startServiceHelper();
            } else {
                stopServiceHelper();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        link();
    }

    public void init() {
        locationIntent = new Intent(MainActivity.this, LocationService.class);
        locationServiceButton = findViewById(R.id.location_service_button);
        isServiceStarted = false;

        locationServiceButton.setText(R.string.service_action_start);
    }

    public void link() {
        locationServiceButton.setOnClickListener(buttonListener);
    }

    public void startServiceHelper() {
        locationServiceButton.setText(R.string.service_action_stop);
        startService(locationIntent);
        isServiceStarted = true;
    }

    public void stopServiceHelper() {
        locationServiceButton.setText(R.string.service_action_start);
        stopService(locationIntent);
        isServiceStarted = false;
    }
}
