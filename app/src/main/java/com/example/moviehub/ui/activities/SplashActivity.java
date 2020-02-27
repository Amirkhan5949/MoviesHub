package com.example.moviehub.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.example.moviehub.ui.fragments.HomeFragment;
import com.example.moviehub.ui.fragments.MenuFragment;
import com.example.moviehub.ui.fragments.MyListFragment;
import com.example.moviehub.ui.fragments.SearchFragment;
import com.example.moviehub.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SplashActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        frameLayout=findViewById(R.id.frame);
        bottomNavigationView=findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        replace(new HomeFragment());
                        return true;

                    case R.id.search:
                        replace(new SearchFragment());
                        return true;

                    case R.id.mylist:
                        replace(new MyListFragment());
                        return true;

                    case R.id.menu:
                        replace(new MenuFragment());
                        return true;


                }
                return false;
            }
        });
    }



    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}
