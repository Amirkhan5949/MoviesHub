package com.example.moviehub.Network;

import com.example.moviehub.model.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInfoRequest {

    @GET("movie/331482")
    Call<MovieInfo> getmovierequest(@Query("api_key") String key);

}
