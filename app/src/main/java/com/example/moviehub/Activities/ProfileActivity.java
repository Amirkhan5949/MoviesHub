package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.moviehub.R;
import com.example.moviehub.adapter.ProfileAdapter;
import com.example.moviehub.utils.Type;
import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tablayout=findViewById(R.id.tablayout);
        viewPage=findViewById(R.id.viewpage);
        String a= getIntent().getStringExtra("castid");
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("type");


        viewPage.setAdapter(new ProfileAdapter(a,getSupportFragmentManager(),type));
        tablayout.setupWithViewPager(viewPage);
    }
}
