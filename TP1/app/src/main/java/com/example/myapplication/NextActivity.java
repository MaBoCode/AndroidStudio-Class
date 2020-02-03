package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView firstActivityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("extra");

        this.firstActivityText = findViewById(R.id.firstActivityText);

        String value = bundle.getString("value");

        this.firstActivityText.setText(value);
    }
}
