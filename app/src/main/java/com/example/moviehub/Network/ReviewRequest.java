package com.example.moviehub.Network;

import com.example.moviehub.model.Reviews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReviewRequest {

    @GET("movie/{id}/reviews")
    Call<Reviews>getreviews(@Path ("id")String id,@Query("api_key") String key);
}
