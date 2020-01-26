package com.example.moviehub.adapter;

import android.util.Log;

import com.example.moviehub.Fragments.CastFragment;
import com.example.moviehub.Fragments.InfoFragment;
import com.example.moviehub.Fragments.MixListFragment;
import com.example.moviehub.Fragments.ProfileFragment;
import com.example.moviehub.Fragments.ReviewFragment;
import com.example.moviehub.utils.Type;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProfileAdapter extends FragmentPagerAdapter {
    private String s;
    Type.MovieOrTvshow type;

    public ProfileAdapter( String s,@NonNull FragmentManager fm,Type.MovieOrTvshow type) {
        super(fm);
        this.s=s;
        this.type=type;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){

            case 0:
                Log.i("dwrfs", "getItem: "+s);
                return new ProfileFragment(s);

            case 1:
                return new MixListFragment(s,Type.MixListType.CREDIT,type);

            case 2:
                return new MixListFragment(s,Type.MixListType.CREDIT,type);


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
