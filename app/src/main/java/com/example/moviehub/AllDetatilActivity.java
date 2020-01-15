package com.example.moviehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.moviehub.adapter.MovieDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class AllDetatilActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_detatil);

        tab=findViewById(R.id.tab);
        viewpager =findViewById(R.id.viewpager );

        viewpager.setAdapter(new MovieDetailAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewpager);

    }
}
