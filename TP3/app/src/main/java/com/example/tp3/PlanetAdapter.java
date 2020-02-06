package com.example.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {

    private final ArrayList<String> planets;
    private final String[] planetsSizes;
    private final Context context;
    private int numberOfItemsChecked;
    private String[] selectedSizes;

    public PlanetAdapter(Context context, Data data) {
        this.planets = data.getPlanets();
        this.planetsSizes = data.getPlanetSizes();
        this.selectedSizes = new String[planetsSizes.length];
        this.context = context;
        this.numberOfItemsChecked = 0;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.list_item, null);
        }

        TextView planetName = itemView.findViewById(R.id.item_text);
        final CheckBox checkBox = itemView.findViewById(R.id.item_checkbox);
        final Spinner spinner = itemView.findViewById(R.id.item_spinner);

        planetName.setText(planets.get(position));

        final ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, planetsSizes);

        spinAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox checkbox = buttonView.findViewById(R.id.item_checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinAdapter.notifyDataSetChanged();
                if (checkBox.isChecked()) {
                    numberOfItemsChecked++;
                } else {
                    numberOfItemsChecked--;
                }
            }
        });

        return itemView;
    }

    public Boolean validationEnabled() {
        return numberOfItemsChecked == planets.size();
    }
}
