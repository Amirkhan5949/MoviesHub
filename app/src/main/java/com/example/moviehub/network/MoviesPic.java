package com.example.moviehub.network;

import com.example.moviehub.model.MovieImages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesPic {
    @GET("movie/{movie_id}/images")
    Call<MovieImages>getMoviespic(@Path("movie_id")String id, @Query("api_key")String key);

    @GET("tv/{tv_id}/images")
    Call<MovieImages>getTvpic(@Path("tv_id")String id,@Query("api_key")String key);
}
