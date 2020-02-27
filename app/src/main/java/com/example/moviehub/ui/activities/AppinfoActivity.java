package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.moviehub.R;

public class AppinfoActivity extends AppCompatActivity {
    LinearLayout github,linkdin,fbook,instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);

        github=findViewById(R.id.github);
        linkdin=findViewById(R.id.linkdin);
        fbook=findViewById(R.id.fbook);
        instagram=findViewById(R.id.instagram);
    }
}
