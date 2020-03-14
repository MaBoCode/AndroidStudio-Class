package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean serviceStarted;
    private Button serviceActionButton;
    private Button serviceStateButton;
    private Intent timeIntent;

    public View.OnClickListener serviceActionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!serviceStarted) {
                serviceStarted = true;
                startService(timeIntent);
                serviceActionButton.setText(R.string.service_action_stop);
            } else {
                serviceStarted = false;
                stopService(timeIntent);
                serviceActionButton.setText(R.string.service_action_start);
            }
        }
    };

    public View.OnClickListener serviceStateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isServiceRunning(HourService.class.getName())) {
                serviceStateButton.setText(R.string.service_state_running);
            } else {
                serviceStateButton.setText(R.string.service_state_stop);
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
        serviceActionButton = findViewById(R.id.service_action_button);
        serviceStateButton = findViewById(R.id.service_state_button);

        serviceStarted = false;
        timeIntent = new Intent(MainActivity.this, HourService.class);

        serviceActionButton.setText(R.string.service_action_start);
        serviceStateButton.setText(R.string.service_state_stop);
    }

    public void link() {
        serviceActionButton.setOnClickListener(serviceActionListener);
        serviceStateButton.setOnClickListener(serviceStateListener);
    }

    private boolean isServiceRunning(String serviceName) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        for(ActivityManager.RunningServiceInfo service: manager.getRunningServices(Integer.MAX_VALUE)) {
            if(serviceName.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
