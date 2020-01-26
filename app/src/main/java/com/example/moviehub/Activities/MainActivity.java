package com.example.moviehub.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.moviehub.Network.MoviesRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.FrontPageAdapter;
import com.example.moviehub.model.Trending;
import com.example.moviehub.utils.Type;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler, resque, upcoming, popular, toprated;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        resque = findViewById(R.id.resque);
        upcoming = findViewById(R.id.upcoming);
        popular = findViewById(R.id.popular);
        toprated = findViewById(R.id.toprated);


        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        resque.setLayoutManager(new LinearLayoutManager(this));
        resque.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        upcoming.setLayoutManager(new LinearLayoutManager(this));
        upcoming.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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
        popular.setLayoutManager(new LinearLayoutManager(this));
        popular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));


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


        toprated.setLayoutManager(new LinearLayoutManager(this));
        toprated.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
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
}
