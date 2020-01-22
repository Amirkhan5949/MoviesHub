package com.example.moviehub.Network;

import com.example.moviehub.model.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieInfoRequest {

    @GET("movie/{id}")
    Call<MovieInfo> getmovierequest(@Path ("id") String id,@Query("api_key") String key);

}
