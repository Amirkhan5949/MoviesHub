package com.example.moviehub.adapter;

import com.example.moviehub.Fragments.PhotosFragment;
import com.example.moviehub.Fragments.ProfileFragment;
import com.example.moviehub.model.MovieImages;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MoviePosterAdapter extends FragmentPagerAdapter {

    ArrayList<MovieImages.Data> data;

    public MoviePosterAdapter(@NonNull FragmentManager fm, ArrayList<MovieImages.Data> data) {
        super(fm);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return new PhotosFragment(data.get(position).getFilePath());


    }

    @Override
    public int getCount() {
        return data.size();
    }
}



