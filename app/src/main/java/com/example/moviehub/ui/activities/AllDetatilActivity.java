package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.moviehub.R;
import com.example.moviehub.adapter.MovieDetailAdapter;
import com.example.moviehub.utils.Type;
import com.google.android.material.tabs.TabLayout;

public class AllDetatilActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewpager;
    Type.MovieOrTvshow type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_detatil);

        String s=getIntent().getStringExtra("id");
        Log.i("sscffdf", "onCreate: "+s);
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("type");



        tab=findViewById(R.id.tab);
        viewpager =findViewById(R.id.viewpager );

        viewpager.setAdapter(new MovieDetailAdapter(s,getSupportFragmentManager(),type));
        tab.setupWithViewPager(viewpager);




    }


}
