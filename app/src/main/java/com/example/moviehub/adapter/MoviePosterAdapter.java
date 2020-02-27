package com.example.moviehub.adapter;

import com.example.moviehub.model.ImageData;
import com.example.moviehub.ui.fragments.PhotosFragment;
import com.example.moviehub.model.MovieImages;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MoviePosterAdapter extends FragmentPagerAdapter {

    ArrayList<ImageData> data;

    public MoviePosterAdapter(@NonNull FragmentManager fm, ArrayList<ImageData> data) {
        super(fm);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return   PhotosFragment.newInstance (data.get(position).getFilePath());


    }

    @Override
    public int getCount() {
        return data.size();
    }
}



