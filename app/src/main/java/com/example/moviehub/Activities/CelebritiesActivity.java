package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.moviehub.Fragments.CastFragment;
import com.example.moviehub.R;
import com.example.moviehub.utils.Type;

public class CelebritiesActivity extends AppCompatActivity {

    FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrities);

       String s= getIntent().getStringExtra("id");
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("mixlisttype");


        layout=findViewById(R.id.frame);
        setFragment(new CastFragment(s,type) );
    }

    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frame, fragment);
        t.commit();
    }
}
