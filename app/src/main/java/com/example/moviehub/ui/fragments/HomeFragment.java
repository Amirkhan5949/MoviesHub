package com.example.moviehub.ui.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;



import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

 import com.example.moviehub.ui.activities.ForMoreActivity;
import com.example.moviehub.ui.activities.MoreActivity;
import com.example.moviehub.ui.activities.SearchActivity;
 import com.example.moviehub.network.MoviesRequest;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.FrontPageAdapter;
import com.example.moviehub.adapter.TrendingPersonAdapter;
import com.example.moviehub.model.Trending;
import com.example.moviehub.utils.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recycler, resque, upcoming, popular, toprated,trendingpersonrecycler;
    TextView trending, tvshow, upcomingmovie, popularmovie, topratedmovie,trendingperson;
    Slider banner_slider1;
    ImageView msearch;
    View view;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for getContext() fragment
        recycler = view.findViewById(R.id.recycler);
        resque =view.findViewById(R.id.resque);
        trendingpersonrecycler = view.findViewById(R.id.trendingpersonrecycler);
        upcoming = view.findViewById(R.id.upcoming);
        popular = view.findViewById(R.id.popular);
        toprated = view.findViewById(R.id.toprated);
        msearch = view.findViewById(R.id.msearchicon);


        trending = view.findViewById(R.id.trending);
        tvshow = view.findViewById(R.id.tvshow);
        upcomingmovie = view.findViewById(R.id.upcomingmovie);
        popularmovie = view.findViewById(R.id.popularmovie);
        topratedmovie = view.findViewById(R.id.topratedmovie);
        trendingperson = view.findViewById(R.id.trendingperson);
        banner_slider1=view.findViewById(R.id.banner_slider1);





        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        resque.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        trendingpersonrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        upcoming.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        popular.setLayoutManager(new LinearLayoutManager(getContext()));
        popular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));


        toprated.setLayoutManager(new LinearLayoutManager(getContext()));
        toprated.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));



        apitrendingperson();
        apiTrendingMovies();
        apiTrendingTvShow();
        apiUpcoming();
        apiPopulaar();
        apiTopRated();


        msearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        trendingperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.TRENDINGPERSON);
                startActivity(intent);
            }
        });

        trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TRENDINGMOVIES);
                startActivity(intent);
            }
        });

        tvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TRENDINGTVSHOW);
                startActivity(intent);
            }
        });

        popularmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.POPULARMOVIES);
                startActivity(intent);
            }
        });

        topratedmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TOPRAYEDMOVIES);
                startActivity(intent);
            }
        });

        upcomingmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.UPCOMINGMOVIES);
                startActivity(intent);
            }
        });


        return view;
    }


    private void apiTopRated() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getTopRated(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {
                        Log.i("fxczc", "onResponse: " + response.toString());
                        Log.i("fxczc", "onResponse: " + response.body());
                        toprated.setAdapter(new FrontPageAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE));
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("fxczc", "onFailure: " + t.getMessage());

                    }
                });

    }

    private void apiPopulaar() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getPopular(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        Log.i("dscsc", "onResponse: " + response.body());
                        Log.i("dscsc", "onResponse: " + response.toString());

                        popular.setAdapter(new FrontPageAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE));
                    }


                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("dscsc", "onFailure: " + t.getMessage());

                    }
                });

    }

    private void apiUpcoming() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getUpcoming(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        Log.i("adadczc", "onResponse: " + response.toString());
                        Log.i("adadczc", "onResponse: " + response.body());
                        upcoming.setAdapter(new FrontPageAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE));

                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("adadczc", "onFailure: " + t.getMessage());

                    }
                });

    }

    private void apiTrendingTvShow() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrendingTvShow(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        Log.i("adadczc", "onResponse: " + response.toString());
                        Log.i("adadczc", "onResponse: " + response.body());
                        resque.setAdapter(new FrontPageAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.TVSHOW));


                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("adadczc", "onFailure: " + t.getMessage());

                    }
                });

    }

    private void apiTrendingMovies() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrending(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        Log.i("dadacc", "onResponse: " + response.body().getResults());
                        Log.i("dadacc", "onResponse: " + response.toString());
                        recycler.setAdapter(new FrontPageAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE));

                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("dadacc", "onFailure: " + t.getMessage());

                    }
                });

    }

    private void apitrendingperson() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrendingPerson(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {
                        trendingpersonrecycler.setAdapter(new TrendingPersonAdapter(getContext(),response.body().getResults()));
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }

}
