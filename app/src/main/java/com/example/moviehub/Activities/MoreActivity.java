package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.moviehub.Network.MoviesRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.CastAdapter;
import com.example.moviehub.adapter.SimilarMovieAdapter;
import com.example.moviehub.model.Trending;
import com.example.moviehub.utils.Type;
import com.wang.avi.AVLoadingIndicatorView;

public class MoreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private boolean isLoading = false;
    private int page = 1;
    private AVLoadingIndicatorView loadingProgress;
    private SimilarMovieAdapter adpter;
    private Type.MoreButton type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        loadingProgress = findViewById(R.id.loadMore);
        recyclerView = findViewById(R.id.more);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        type = (Type.MoreButton) getIntent().getSerializableExtra("type");


        switch (type){
            case TRENDINGMOVIES:
                loadMore();

            case TRENDINGTVSHOW:
                loadingmore();

            case POPULARMOVIES:
                PopularMore();

            case TOPRAYEDMOVIES:
                TopratedMore();

            case UPCOMINGMOVIES:
                UpcomingMore();

            case TRENDINGPERSON:
//                PersonMore();
        }



       addListener();


    }


    private void UpcomingMore() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getUpcomingMore(page+"",NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page==1){
                            adpter=new SimilarMovieAdapter(MoreActivity.this,response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        }else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading=false;
                        page= page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }

    private void TopratedMore() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getTopRatedMore(page+"",NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page==1){
                            adpter=new SimilarMovieAdapter(MoreActivity.this,response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        }else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading=false;
                        page= page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }

    private void PopularMore() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getPopularMore(page+"",NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page==1){
                            adpter=new SimilarMovieAdapter(MoreActivity.this,response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        }else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading=false;
                        page= page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });
    }

    private void loadingmore() {

            RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                    .create(TrendingRequest.class)
                    .getTrendingTvShowMore(page+"",NetworkConstraint.key)
                    .enqueue(new Callback<Trending>() {
                        @Override
                        public void onResponse(Call<Trending> call, Response<Trending> response) {

                            if (page==1){
                                adpter=new SimilarMovieAdapter(MoreActivity.this,response.body().getResults(), Type.MovieOrTvshow.TVSHOW);
                                recyclerView.setAdapter(adpter);
                            }else {
                                adpter.addAllResult(response.body().getResults());
                            }

                            loadingProgress.setVisibility(View.GONE);
                            isLoading=false;
                            page= page + 1;
                        }

                        @Override
                        public void onFailure(Call<Trending> call, Throwable t) {

                        }
                    });


    }

    private void addListener() {
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int total = linearLayoutManager.getItemCount();
                int firstVisibleItemCount = linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemCount = linearLayoutManager.findLastVisibleItemPosition();

                //to avoid multiple calls to loadMore() method
                //maintain a boolean value (isLoading). if loadMore() task started set to true and completes set to false
                if (!isLoading) {
                    if (total > 0)
                        if ((total - 1) == lastVisibleItemCount){
                            isLoading = true;

                            switch (type){
                                case TRENDINGMOVIES:
                                    loadMore();

                                case TRENDINGTVSHOW:
                                    loadingmore();

                                case POPULARMOVIES:
                                    PopularMore();

                                case TOPRAYEDMOVIES:
                                    TopratedMore();

                                case UPCOMINGMOVIES:
                                    UpcomingMore();
                            }


                            loadingProgress.setVisibility(View.VISIBLE);
                        }else
                            loadingProgress.setVisibility(View.GONE);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

        });
    }

    private void loadMore() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrendingMovieMore(page+"",NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {
                        if(page==1){
                             Log.i("jkvndkfnvdn", "set: "+response.body().getResults().size());
                             adpter = new SimilarMovieAdapter(MoreActivity.this, response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                             recyclerView.setAdapter(adpter);
                        }
                        else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;


                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("jkvndkfnvdn", "onResponse: "+t.toString());

                    }
                });
    }
}
