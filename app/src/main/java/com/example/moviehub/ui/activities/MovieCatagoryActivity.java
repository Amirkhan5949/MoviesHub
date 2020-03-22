package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.moviehub.ui.fragments.MixListFragment;
import com.example.moviehub.R;
import com.example.moviehub.utils.Type;

public class MovieCatagoryActivity extends AppCompatActivity {
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_catagory);
        frameLayout=findViewById(R.id.framelayout);

        String a=getIntent().getStringExtra("id");
        Log.i("ddgg", "onCreate: "+a);
        Type.MixListType mixlisttype = (Type.MixListType) getIntent().getSerializableExtra("mixlisttype");
        Log.i("sfsfsf", "onCreate: "+mixlisttype);
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("type");

        setFragment(MixListFragment.newInstance (a,mixlisttype,type));


    }
    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.framelayout, fragment);
        t.commit();
    }
}
