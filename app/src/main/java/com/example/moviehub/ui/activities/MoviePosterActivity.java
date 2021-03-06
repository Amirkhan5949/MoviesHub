package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.moviehub.R;
import com.example.moviehub.adapter.MoviePosterAdapter;
import com.example.moviehub.model.ImageData;
import com.example.moviehub.model.MovieImages;

import java.util.ArrayList;

public class MoviePosterActivity extends AppCompatActivity {
    ViewPager  pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_poster);
        pager=findViewById(R.id.pager);

        ArrayList<ImageData> images = (ArrayList<ImageData>) getIntent().getSerializableExtra("images");
        Log.i("cghsdg", "onCreate: "+ images.toString());

        pager.setAdapter(new MoviePosterAdapter( getSupportFragmentManager(),images));
        Log.i("scffdf", "onCreate: "+images);



    }
}
