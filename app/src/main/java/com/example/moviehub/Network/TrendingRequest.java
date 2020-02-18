package com.example.moviehub.Network;

import com.example.moviehub.model.Trending;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrendingRequest {

    @GET("trending/movie/day")
    Call<Trending> getTrending(@Query("api_key") String key);

    @GET("trending/movie/day")
    Call<Trending> getTrendingMovieMore(@Query("page") String page,@Query("api_key") String key);

    @GET("trending/tv/day")
    Call<Trending>getTrendingTvShow(@Query("api_key")String Key);

    @GET("trending/tv/day")
    Call<Trending>getTrendingTvShowMore(@Query("page") String page,@Query("api_key")String Key);

    @GET("trending/person/day")
    Call<Trending>getTrendingPerson(@Query("api_key")String key);

    @GET("trending/person/day")
    Call<Trending>getTrendingPersonMore(@Query("page") String page,@Query("api_key")String key);



}








