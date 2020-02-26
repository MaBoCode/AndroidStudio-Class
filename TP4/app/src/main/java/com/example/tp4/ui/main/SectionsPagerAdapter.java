package com.example.tp4.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4.AnimalsFragment;
import com.example.tp4.MainFragment;
import com.example.tp4.MineralsFragment;
import com.example.tp4.R;

import java.util.Locale;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new MainFragment();
                break;
            case 1:
                fragment = new MineralsFragment();
                break;
            case 2:
                fragment = new AnimalsFragment();
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Main";
            case 1:
                return "Minerals";
            case 2:
                return "Animals";
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}