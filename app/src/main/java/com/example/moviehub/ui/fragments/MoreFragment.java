package com.example.moviehub.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviehub.adapter.TrendingPersonListAdapter;
import com.example.moviehub.network.MoviesRequest;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.network.SearchRequest;
import com.example.moviehub.network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.SimilarMovieAdapter;
import com.example.moviehub.model.SearchByName;
import com.example.moviehub.model.Trending;
import com.example.moviehub.utils.Type;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private boolean isLoading = false;
    private int page = 1;
    private AVLoadingIndicatorView loadingProgress;
    private SimilarMovieAdapter adpter;
     private Type.MoreButton type;
    private String query;


    public static MoreFragment newInstance(Type.MoreButton type) {
        MoreFragment f = new MoreFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        f.setArguments(args);
        return f;
    }

    public static MoreFragment newInstance(Type.MoreButton type, String query) {
        MoreFragment f = new MoreFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        args.putString("query", query);
        f.setArguments(args);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);

        Bundle args = getArguments();
        if(args!=null){
            type = (Type.MoreButton)args.getSerializable("type");
            query = args.getString("query")+" ";
        }




        loadingProgress = view.findViewById(R.id.loadMore);
        recyclerView = view.findViewById(R.id.more);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        switch (type) {
            case TRENDINGMOVIES:
                loadMore();
                break;

            case TRENDINGTVSHOW:
                loadingmore();
                break;

            case POPULARMOVIES:
                PopularMore();
                break;

            case TOPRAYEDMOVIES:
                TopratedMore();
                break;

            case UPCOMINGMOVIES:
                UpcomingMore();
                break;

            case SEARCH_MOVIE:
                searchMovie();
                break;

            case SEARCH_TV_SHOW:
                searchtvshow();
                break;



        }

        addListener();


        return view;
    }


    private void UpcomingMore() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getUpcomingMore(page + "", NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page == 1) {
                            adpter = new SimilarMovieAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }

    private void TopratedMore() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getTopRatedMore(page + "", NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page == 1) {
                            adpter = new SimilarMovieAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });

    }

    private void PopularMore() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getPopularMore(page + "", NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page == 1) {
                            adpter = new SimilarMovieAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {

                    }
                });
    }

    private void loadingmore() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrendingTvShowMore(page + "", NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        if (page == 1) {
                            adpter = new SimilarMovieAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.TVSHOW);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
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
                        if ((total - 1) == lastVisibleItemCount) {
                            isLoading = true;

                            switch (type) {
                                case TRENDINGMOVIES:
                                    loadMore();
                                    break;
                                case TRENDINGTVSHOW:
                                    loadingmore();
                                    break;
                                case POPULARMOVIES:
                                    PopularMore();
                                    break;
                                case TOPRAYEDMOVIES:
                                    TopratedMore();
                                    break;
                                case UPCOMINGMOVIES:
                                    UpcomingMore();
                                    break;
                                case SEARCH_MOVIE:
                                    searchMovie();
                                    break;

                                case SEARCH_TV_SHOW:
                                    searchtvshow();
                                    break;


                            }


                            loadingProgress.setVisibility(View.VISIBLE);
                        } else
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
                .getTrendingMovieMore(page + "", NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {
                        if (page == 1) {
                            Log.i("jkvndkfnvdn", "set: " + response.body().getResults().size());
                            adpter = new SimilarMovieAdapter(getContext(), response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;


                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("jkvndkfnvdn", "onResponse: " + t.toString());

                    }
                });
    }


    private void searchMovie() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(SearchRequest.class)
                .searchMovie(page + "", query, NetworkConstraint.key)
                .enqueue(new Callback<SearchByName>() {
                    @Override
                    public void onResponse(Call<SearchByName> call, Response<SearchByName> response) {
                            Log.i("sfsfdz", "onResponse: "+ response.body());
                            Log.i("sfsfdz", "onResponse: "+ response.toString());

                        if (page == 1) {
                            Log.i("vsfsfs", "onResponse: "+response.body().toString());
                            adpter = new SimilarMovieAdapter(getContext(),response.body().getResults(), Type.MovieOrTvshow.MOVIE);
                            recyclerView.setAdapter(adpter);
                        } else {
                            Log.i("lknnk", "onResponse: "+response.body().toString());
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }


                    @Override
                    public void onFailure(Call<SearchByName> call, Throwable t) {
                        Log.i("sfsfdz", "onResponse: "+ t.getMessage());
                        loadingProgress.setVisibility(View.GONE);
                    }
                });
    }

    private void searchtvshow() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(SearchRequest.class)
                .searchTv(page + "", query, NetworkConstraint.key)
                .enqueue(new Callback<SearchByName>() {
                    @Override
                    public void onResponse(Call<SearchByName> call, Response<SearchByName> response) {
                        Log.i("sfsfdz", "onResponse: "+ response.body());
                        Log.i("sfsfdz", "onResponse: "+ response.toString());

                        if (page == 1) {
                            adpter = new SimilarMovieAdapter(getContext(),response.body().getResults(), Type.MovieOrTvshow.TVSHOW);
                            recyclerView.setAdapter(adpter);
                        } else {
                            adpter.addAllResult(response.body().getResults());
                        }

                        loadingProgress.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }


                    @Override
                    public void onFailure(Call<SearchByName> call, Throwable t) {
                        Log.i("sfsfdz", "onResponse: "+ t.getMessage());
                        loadingProgress.setVisibility(View.GONE);
                    }
                });
    }
}