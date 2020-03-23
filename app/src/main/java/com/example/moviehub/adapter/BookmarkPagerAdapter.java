package com.example.moviehub.adapter;

import com.example.moviehub.ui.fragments.MixListFragment;
import com.example.moviehub.utils.Type;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BookmarkPagerAdapter extends FragmentPagerAdapter {
    Type.MixListType mixListType;
    Type.MovieOrTvshow type;
    String s="";
    public BookmarkPagerAdapter(@NonNull FragmentManager fm,Type.MixListType mixListType) {
        super(fm);
        this.mixListType=mixListType;
        this.type=type;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return   MixListFragment.newInstance(s,mixListType,Type.MovieOrTvshow.MOVIE);

            case 1:
                return   MixListFragment.newInstance(s,mixListType,Type.MovieOrTvshow.TVSHOW);

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
