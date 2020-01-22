package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.moviehub.R;
import com.example.moviehub.adapter.MovieDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class AllDetatilActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_detatil);

        String s=getIntent().getStringExtra("id");

        tab=findViewById(R.id.tab);
        viewpager =findViewById(R.id.viewpager );

        viewpager.setAdapter(new MovieDetailAdapter(s,getSupportFragmentManager()));
        tab.setupWithViewPager(viewpager);




        Log.i("cdccdf", "onCreate: "+s);

    }


}
