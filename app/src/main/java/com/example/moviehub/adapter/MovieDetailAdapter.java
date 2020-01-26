package com.example.moviehub.adapter;

import com.example.moviehub.Fragments.CastFragment;
import com.example.moviehub.Fragments.InfoFragment;
import com.example.moviehub.Fragments.ReviewFragment;
import com.example.moviehub.Fragments.MixListFragment;
import com.example.moviehub.utils.Type;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MovieDetailAdapter extends FragmentPagerAdapter {

     private String s;
     private Type.MovieOrTvshow type;

     public MovieDetailAdapter(String s,@NonNull FragmentManager fm,Type.MovieOrTvshow type) {
         super(fm);
         this.s=s;
         this.type = type;
     }




     @NonNull
     @Override
     public Fragment getItem(int position) {
         switch(position){

             case 0:
                 return new InfoFragment(s,type);

             case 1:
                 return new CastFragment(s,type);

             case 2:
                 return new ReviewFragment(s,type);

             case 3:
                 return new MixListFragment(s, Type.MixListType.SIMILAR,type);
             default:
                 return null;

         }


     }

     @Override
     public int getCount() {
         return 4;
     }

     @Nullable
     @Override
     public CharSequence getPageTitle(int position) {
         switch (position){
             case 0:
                 return "Info";
             case 1:
                 return "Cast";
             case 2:
                 return "Review";

             case 3:
                 return "Similar";
             default:

                 return null;
         }
     }
 }
