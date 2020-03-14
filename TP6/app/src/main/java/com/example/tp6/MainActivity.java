package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button serviceButton;
    public View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startService(new Intent(MainActivity.this, HourService.class));
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
        serviceButton = findViewById(R.id.serviceButton);
    }

    public void link() {
        serviceButton.setOnClickListener(buttonListener);
    }
}
