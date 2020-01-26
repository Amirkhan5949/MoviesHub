package com.example.moviehub.Network;

import android.graphics.Movie;

import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.model.Reviews;
import com.example.moviehub.model.SimilarMovie;
import com.example.moviehub.model.Trending;
import com.example.moviehub.model.YoutubeConnect;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesRequest {

    @GET("movie/upcoming")
    Call<Trending>getUpcoming(@Query("api_key") String key);

    @GET("movie/popular")
    Call<Trending>getPopular(@Query("api_key")String key);

    @GET("movie/top_rated")
    Call<Trending>getTopRated(@Query("api_key")String key);

    @GET("movie/{id}")
    Call<MovieInfo> getmovierequest(@Path("id") String id, @Query("api_key") String key);

    @GET("movie/{id}/reviews")
    Call<Reviews>getreviews(@Path ("id")String id, @Query("api_key") String key);

    @GET("movie/{id}/similar")
    Call<SimilarMovie>getsimilarmovie(@Path ("id")String id, @Query("api_key") String key);

    @GET("movie/{id}/videos")
    Call<YoutubeConnect>getYoutubeRequest(@Path ("id")String id, @Query("api_key") String key);

    @GET("movie/{id}/credits")
    Call<Credit>getCrewRequest(@Path ("id") String id, @Query("api_key") String key);

}
