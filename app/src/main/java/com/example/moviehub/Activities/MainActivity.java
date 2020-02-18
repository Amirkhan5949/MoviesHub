package com.example.moviehub.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.ImageLoadingService;
import ss.com.bannerslider.Slider;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviehub.Network.MoviesRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.FrontPageAdapter;
//import com.example.moviehub.adapter.MainSliderAdapter;
import com.example.moviehub.adapter.SimilarMovieAdapter;
import com.example.moviehub.adapter.TrendingPersonAdapter;
import com.example.moviehub.model.Trending;

import com.example.moviehub.utils.Type;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler, resque, upcoming, popular, toprated,trendingpersonrecycler;
    TextView trending, tvshow, upcomingmovie, popularmovie, topratedmovie;
    Slider banner_slider1;
//    private Object PicassoImageLoadingService;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        resque = findViewById(R.id.resque);
        trendingpersonrecycler = findViewById(R.id.trendingpersonrecycler);
        upcoming = findViewById(R.id.upcoming);
        popular = findViewById(R.id.popular);
        toprated = findViewById(R.id.toprated);


        trending = findViewById(R.id.trending);
        tvshow = findViewById(R.id.tvshow);
        upcomingmovie = findViewById(R.id.upcomingmovie);
        popularmovie = findViewById(R.id.popularmovie);
        topratedmovie = findViewById(R.id.topratedmovie);
        banner_slider1=findViewById(R.id.banner_slider1);



        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        resque.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trendingpersonrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        upcoming.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//
//        class PicassoImageLoadingService implements ImageLoadingService {
//            public Context context;
//
//            public PicassoImageLoadingService(Context context) {
//                this.context = context;
//            }
//
//            @Override
//            public void loadImage(String url, ImageView imageView) {
//                Picasso.get().load(url).into(imageView);
//            }
//
//            @Override
//            public void loadImage(int resource, ImageView imageView) {
//                Picasso.get().load(resource).into(imageView);
//            }
//
//            @Override
//            public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
//                Picasso.get().load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
//            }
//        }
//
//        Slider.init((ImageLoadingService) PicassoImageLoadingService);
//        banner_slider1.setAdapter(new TrendingPersonAdapter(MainActivity.this,));


         apitrendingperson();
         apiTrendingMovies();
         apiTrendingTvShow();
         apiUpcoming();
         apiPopulaar();
         apiTopRated();

         trending.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.TRENDINGMOVIES);
                 startActivity(intent);
             }
         });

         tvshow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.TRENDINGTVSHOW);
                 startActivity(intent);
             }
         });

         popularmovie.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.POPULARMOVIES);
                 startActivity(intent);
             }
         });

         topratedmovie.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.TOPRAYEDMOVIES);
                 startActivity(intent);
             }
         });

         upcomingmovie.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                 intent.putExtra("type", Type.MoreButton.UPCOMINGMOVIES);
                 startActivity(intent);
             }
         });



        popular.setLayoutManager(new LinearLayoutManager(this));
        popular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));




        toprated.setLayoutManager(new LinearLayoutManager(this));
        toprated.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));


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
                        toprated.setAdapter(new FrontPageAdapter(MainActivity.this, response.body().getResults(), Type.MovieOrTvshow.MOVIE));
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

                        popular.setAdapter(new FrontPageAdapter(MainActivity.this, response.body().getResults(), Type.MovieOrTvshow.MOVIE));
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
                        upcoming.setAdapter(new FrontPageAdapter(MainActivity.this, response.body().getResults(), Type.MovieOrTvshow.MOVIE));

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
                        resque.setAdapter(new FrontPageAdapter(MainActivity.this, response.body().getResults(), Type.MovieOrTvshow.TVSHOW));


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
                        recycler.setAdapter(new FrontPageAdapter(MainActivity.this, response.body().getResults(), Type.MovieOrTvshow.MOVIE));

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
                        trendingpersonrecycler.setAdapter(new TrendingPersonAdapter(MainActivity.this,response.body().getResults()));
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }
}
