package com.example.moviehub.Network;

import android.graphics.Movie;

import com.example.moviehub.model.Trending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesRequest {

    @GET("movie/upcoming")
    Call<Trending>getUpcoming(@Query("api_key") String key);

    @GET("movie/popular")
    Call<Trending>getPopular(@Query("api_key")String key);

    @GET("movie/top_rated")
    Call<Trending>getTopRated(@Query("api_key")String key);
}
