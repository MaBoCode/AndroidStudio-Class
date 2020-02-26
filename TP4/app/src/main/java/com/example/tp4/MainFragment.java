package com.example.tp4;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ViewPager viewPager;

    public MainFragment() {
        // Required empty public constructor
    }

    View.OnClickListener imageView1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "Image 1", Toast.LENGTH_SHORT).show();
            viewPager.setCurrentItem(1);
        }
    };

    View.OnClickListener imageView2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "Image 2", Toast.LENGTH_SHORT).show();
            viewPager.setCurrentItem(2);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView imageView1 = view.findViewById(R.id.imageView1);
        ImageView imageView2 = view.findViewById(R.id.imageView2);

        imageView1.setImageResource(R.drawable.mineraux);
        imageView2.setImageResource(R.drawable.animaux);

        imageView1.setOnClickListener(imageView1Listener);
        imageView2.setOnClickListener(imageView2Listener);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = getActivity().findViewById(R.id.view_pager);
    }
}
