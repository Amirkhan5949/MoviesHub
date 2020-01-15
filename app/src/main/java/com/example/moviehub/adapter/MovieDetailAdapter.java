package com.example.moviehub.adapter;

import android.view.View;
import android.widget.Switch;

import com.example.moviehub.Fragments.CastFragment;
import com.example.moviehub.Fragments.InfoFragment;
import com.example.moviehub.Fragments.ReviewFragment;
import com.example.moviehub.Fragments.SimilarFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
 public class MovieDetailAdapter extends FragmentPagerAdapter {
     public MovieDetailAdapter(@NonNull FragmentManager fm) {
         super(fm);
     }

     public MovieDetailAdapter(@NonNull FragmentManager fm, int behavior) {
         super(fm, behavior);
     }

     @NonNull
     @Override
     public Fragment getItem(int position) {
         switch(position){

             case 0:
                 return new InfoFragment();

             case 1:
                 return new CastFragment();

             case 2:
                 return new ReviewFragment();

             case 3:
                 return new SimilarFragment();
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
