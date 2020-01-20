package com.example.moviehub.Network;

import com.example.moviehub.model.YoutubeConnect;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeRequest {

    @GET("movie/475557/videos")
    Call<YoutubeConnect>getYoutubeRequest(@Query("api_key") String key);
}
