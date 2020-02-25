package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.moviehub.ui.fragments.MoreFragment;
import com.example.moviehub.R;
import com.example.moviehub.utils.Type;

public class ForMoreActivity extends AppCompatActivity {

    FrameLayout framework;
    private Type.MoreButton type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_more);
        framework=findViewById(R.id.framework);


        type = (Type.MoreButton) getIntent().getSerializableExtra("type");

        Log.i("ffdfs", "onCreate: "+type);

        replace(MoreFragment.newInstance(type));



    }
    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framework,fragment);
        ft.commit();
    }

}
