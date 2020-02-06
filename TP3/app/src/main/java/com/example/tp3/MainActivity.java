package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private PlanetAdapter adapter;
    private Button validateButton;

    View.OnClickListener validateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (adapter.validationEnabled()) {
                System.out.println("Enabled to run validation");
            } else {
                System.out.println("Unabled to run validation");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        validateButton = findViewById(R.id.validateButton);

        Data data = new Data();

        adapter = new PlanetAdapter(MainActivity.this, data);

        listView.setAdapter(adapter);

        validateButton.setOnClickListener(validateListener);
    }
}