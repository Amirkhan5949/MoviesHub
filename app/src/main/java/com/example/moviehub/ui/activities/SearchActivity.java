package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.moviehub.R;
import com.example.moviehub.adapter.SearchAdapteer;
import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity {
    ViewPager sviewpage;
    TabLayout stabLayout;
    ImageView searchicon;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sviewpage = findViewById(R.id.sviewpage);
        stabLayout = findViewById(R.id.stabLayout);
        searchicon = findViewById(R.id.searchicon);
        edit = findViewById(R.id.edit);


        searchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("fgkdfnlgdf", "onClick: ");
                sviewpage.setAdapter(new SearchAdapteer(getSupportFragmentManager(), edit.getText().toString()));
                sviewpage.setOffscreenPageLimit(0);
                stabLayout.setupWithViewPager(sviewpage);
            }
        });
    }
}
