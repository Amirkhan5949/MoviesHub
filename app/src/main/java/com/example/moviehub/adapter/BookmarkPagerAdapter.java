package com.example.moviehub.adapter;

import com.example.moviehub.ui.fragments.HomeFragment;
import com.example.moviehub.ui.fragments.MixListFragment;
import com.example.moviehub.utils.Type;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BookmarkPagerAdapter extends FragmentPagerAdapter {
    public BookmarkPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return  MixListFragment.newInstance(null, Type.MixListType.BOOKMARK,Type.MovieOrTvshow.MOVIE);

            case 1:
                return   MixListFragment.newInstance(null ,Type.MixListType.BOOKMARK,Type.MovieOrTvshow.MOVIE);


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
        switch (position){
            case 0:
                return "Movie";
            case 1:
                return "Tv Show";

            default:

                return null;
        }
    }
}
