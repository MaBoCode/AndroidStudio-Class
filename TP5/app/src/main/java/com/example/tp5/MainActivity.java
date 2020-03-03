package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemListener {

    private static String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(getDataSource(), this);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Data> getDataSource() {
        ArrayList<Data> results = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Data data = new Data("Main " + i, "Secondary " + i);
            results.add(data);
        }

        return results;
    }

    @Override
    public void onItemClick(int position) {
        Data itemData = adapter.getItem(position);
        Log.d(TAG, "Clicked on " + itemData.getMain());
    }
}
