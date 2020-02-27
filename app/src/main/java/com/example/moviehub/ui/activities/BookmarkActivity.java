package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.moviehub.R;
import com.example.moviehub.adapter.BookmarkPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class BookmarkActivity extends AppCompatActivity {

    TabLayout btabLayout;
    ViewPager bviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        btabLayout=findViewById( R.id.btabLayout);
        bviewPager=findViewById( R.id.bviewPager);

        bviewPager.setAdapter(new BookmarkPagerAdapter(getSupportFragmentManager()));
        btabLayout.setupWithViewPager(bviewPager);
    }
}
