package com.example.moviehub.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.moviehub.ui.fragments.MovieFragment;
import com.example.moviehub.ui.fragments.TvshowFragment;


public class MyListAdapter extends FragmentPagerAdapter{
    public MyListAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new MovieFragment();

            case 1:
                return new TvshowFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Movie";
            case 1:
                return "Tv Show";
            default:
                return null;

        }
    }
    }




