package com.example.tp5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataContainer> {
    private ArrayList<Data> data;
    private static OnClickRecyclerListener onClickRecyclerListener;

    public static class DataContainer extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mainTextView, secondaryTextView;

        public DataContainer(View itemView) {
            super(itemView);
            mainTextView = itemView.findViewById(R.id.mainTextView);
            secondaryTextView = itemView.findViewById(R.id.secondaryTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickRecyclerListener.itemClicked(getAdapterPosition(), itemView);
        }
    }

    public MyAdapter(ArrayList<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public DataContainer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        return new DataContainer(view);
    }

    @Override
    public void onBindViewHolder(DataContainer holder, int position) {
        holder.mainTextView.setText(data.get(position).getMain());
        holder.secondaryTextView.setText(data.get(position).getSecondary());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickRecyclerListener(OnClickRecyclerListener onClickRecyclerListener) {
        this.onClickRecyclerListener = onClickRecyclerListener;
    }
}
