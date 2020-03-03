package com.example.tp5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Data> data;
    private OnItemListener mOnItemListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mainTextView, secondaryTextView;
        OnItemListener onItemListener;

        public MyViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            mainTextView = itemView.findViewById(R.id.mainTextView);
            secondaryTextView = itemView.findViewById(R.id.secondaryTextView);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
            //Toast.makeText(v.getContext(), "Clicked on " +  mainTextView.getText().toString(), Toast.LENGTH_SHORT);
        }
    }

    public MyAdapter(ArrayList<Data> data, OnItemListener onItemListener) {
        this.data = data;
        this.mOnItemListener = onItemListener;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        return new MyViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mainTextView.setText(data.get(position).getMain());
        holder.secondaryTextView.setText(data.get(position).getSecondary());
    }

    public Data getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }
}
