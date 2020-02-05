package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] planets = {
            "Mercure",
            "Venus",
            "Terre",
            "Mars",
            "Jupiter",
            "Saturne",
            "Uranus",
            "Neptune",
            "Pluton"
    };

    private ListView listView;
    private PlanetAdapter adapter;

    private class PlanetAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return planets.length;
        }

        @Override
        public Object getItem(int position) {
            return planets[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if(itemView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                itemView = inflater.inflate(R.layout.list_item, null);
            }

            TextView planetName = itemView.findViewById(R.id.item_text);
            final CheckBox checkBox = itemView.findViewById(R.id.item_checkbox);
            final Spinner spinner = itemView.findViewById(R.id.item_spinner);

            planetName.setText(planets[position]);

            String[] planetsSizes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
            final ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, planetsSizes);

            spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinAdapter);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CheckBox checkbox = buttonView.findViewById(R.id.item_checkbox);
                    spinner.setEnabled(!checkBox.isChecked());
                    spinAdapter.notifyDataSetChanged();
                }
            });

            return itemView;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        adapter = new PlanetAdapter();

        listView.setAdapter(adapter);
    }
}