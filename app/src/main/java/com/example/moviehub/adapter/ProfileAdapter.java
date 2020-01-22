package com.example.moviehub.adapter;

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

    public ProfileAdapter( String s,@NonNull FragmentManager fm) {
        super(fm);
        this.s=s;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){

            case 0:

                return new ProfileFragment();

            case 1:
                return new MixListFragment(s,Type.MixListType.SIMILAR);

            case 2:
                return new MixListFragment(s,Type.MixListType.SIMILAR);


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
