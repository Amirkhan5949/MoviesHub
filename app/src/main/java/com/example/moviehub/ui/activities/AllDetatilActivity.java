package com.example.moviehub.ui.activities;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.moviehub.R;
import com.example.moviehub.adapter.InfoSliderAdapter;
import com.example.moviehub.adapter.MovieDetailAdapter;
import com.example.moviehub.model.MovieImages;
import com.example.moviehub.network.MoviesPic;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.utils.Type;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;

public class AllDetatilActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewpager;
    Type.MovieOrTvshow type;
    Slider  banner_sliderinfo;
    CollapsingToolbarLayout collapsing_toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_detatil);

        String s=getIntent().getStringExtra("id");
        Log.i("sscffdf", "onCreate: "+s);
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("type");
        String name=getIntent().getStringExtra("name");
        Log.i("sfscxcc", "onCreate: "+name);

        tab=findViewById(R.id.tab);
        viewpager =findViewById(R.id.viewpager );
        banner_sliderinfo =findViewById(R.id.banner_sliderinfo );
        collapsing_toolbar1 =findViewById(R.id.collapsing_toolbar1 );

        collapsing_toolbar1.setTitle(name);

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesPic.class)
                .getMoviespic(s,NetworkConstraint.key)
                .enqueue(new Callback<MovieImages>() {
                    @Override
                    public void onResponse(Call<MovieImages> call, Response<MovieImages> response) {
                        banner_sliderinfo.setAdapter(new InfoSliderAdapter(response.body().getBackdrops()));


                    }

                    @Override
                    public void onFailure(Call<MovieImages> call, Throwable t) {

                    }
                });

        viewpager.setAdapter(new MovieDetailAdapter(s,getSupportFragmentManager(),type));
        tab.setupWithViewPager(viewpager);




    }


}
