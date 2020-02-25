package com.example.moviehub.adapter;

import android.util.Log;

import com.example.moviehub.ui.fragments.MixListFragment;
import com.example.moviehub.ui.fragments.ProfileFragment;
import com.example.moviehub.utils.Type;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProfileAdapter extends FragmentPagerAdapter {
    private String s;


    public ProfileAdapter( String s,@NonNull FragmentManager fm) {
        super(fm);
        this.s=s;

        Log.i("dwrfs", "getItem: "+s);

     }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){

            case 0:

                return new ProfileFragment(s);

            case 1:
                return new MixListFragment(s,Type.MixListType.CREDIT,Type.MovieOrTvshow.MOVIE);

            case 2:
                return new MixListFragment(s,Type.MixListType.CREDIT,Type.MovieOrTvshow.TVSHOW);


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
                return "Info";
            case 1:
                return "Movies";
            case 2:
                return "Tv shows";

            default:
                return null;
        }
    }
}
