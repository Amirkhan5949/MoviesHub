package com.example.moviehub.Network;

import com.example.moviehub.model.Reviews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReviewRequest {

    @GET("movie/331482/reviews")
    Call<Reviews>getreviews(@Query("api_key") String key);
}
