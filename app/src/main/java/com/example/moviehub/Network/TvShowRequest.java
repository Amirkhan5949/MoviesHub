package com.example.moviehub.Network;

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

public interface TvShowRequest {

    @GET("tv/upcoming")
    Call<Trending> getUpcoming(@Query("api_key") String key);

    @GET("tv/popular")
    Call<Trending>getPopular(@Query("api_key")String key);

    @GET("tv/top_rated")
    Call<Trending>getTopRated(@Query("api_key")String key);

    @GET("tv/{id}")
    Call<MovieInfo> gettvrequest(@Path("id") String id, @Query("api_key") String key);

    @GET("tv/{id}/reviews")
    Call<Reviews>getreviews(@Path ("id")String id, @Query("api_key") String key);

    @GET("tv/{id}/similar")
    Call<SimilarMovie>getsimilartv(@Path ("id")String id, @Query("api_key") String key);

    @GET("tv/{id}/videos")
    Call<YoutubeConnect>getYoutubeRequest(@Path ("id")String id, @Query("api_key") String key);

    @GET("tv/{id}/credits")
    Call<Credit>getCrewRequest(@Path ("id") String id, @Query("api_key") String key);


}
