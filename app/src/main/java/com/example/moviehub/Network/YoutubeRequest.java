package com.example.moviehub.Network;

import com.example.moviehub.model.YoutubeConnect;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface YoutubeRequest {

    @GET("movie/{id}/videos")
    Call<YoutubeConnect>getYoutubeRequest(@Path ("id")String id,@Query("api_key") String key);
}
