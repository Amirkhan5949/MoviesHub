package com.example.moviehub.adapter;

import com.example.moviehub.ui.fragments.MoreFragment;
import com.example.moviehub.ui.fragments.TrendingPersonMoreListFragment;
import com.example.moviehub.utils.Type;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SearchAdapteer extends FragmentStatePagerAdapter {

    String s;




    public SearchAdapteer(@NonNull FragmentManager fm,String s) {
        super(fm);
        this.s = s;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return MoreFragment.newInstance(Type.MoreButton.SEARCH_MOVIE, s);

            case 1:
                return MoreFragment.newInstance(Type.MoreButton.SEARCH_TV_SHOW, s);

            case 2:
                return TrendingPersonMoreListFragment.newInstance(Type.MoreButton.SEARCH_PEOPLE, s);

            default:
                return null;
        }

    }

        @Override
        public int getCount() {
            return 3;
        }


    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Movies";
            case 1:
                return "Tv shows";
            case 2:
                return "People";

            default:
                return null;
        }
    }
    }
