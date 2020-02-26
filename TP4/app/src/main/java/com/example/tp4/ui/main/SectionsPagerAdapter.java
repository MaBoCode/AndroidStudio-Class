package com.example.tp4.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4.AnimalsFragment;
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
                fragment = new MineralsFragment();
                break;
            case 1:
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
                return "Fragment 1";
            case 1:
                return "Fragment 2";
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}