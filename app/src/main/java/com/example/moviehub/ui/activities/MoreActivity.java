package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.moviehub.ui.fragments.TrendingPersonMoreListFragment;
import com.example.moviehub.R;
import com.example.moviehub.utils.Type;

public class MoreActivity extends AppCompatActivity {

    private Type.MoreButton type;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


        type = (Type.MoreButton) getIntent().getSerializableExtra("type");
        replace(TrendingPersonMoreListFragment.newInstance(type));



    }

    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framel2,fragment);
        ft.commit();
    }
}



