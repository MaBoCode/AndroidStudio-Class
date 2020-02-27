package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickRecyclerListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(getDataSource());
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Data> getDataSource() {
        ArrayList<Data> results = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            Data data = new Data("Main " + i, "Secondary " + i);
            results.add(data);
        }

        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void itemClicked(int position, View v) {
        Toast.makeText(getApplicationContext(), "Click on " + position, Toast.LENGTH_SHORT).show();
    }
}
