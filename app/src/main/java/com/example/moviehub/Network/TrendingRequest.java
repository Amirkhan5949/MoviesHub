package com.example.moviehub.Network;

import com.example.moviehub.model.Trending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrendingRequest {

    @GET("trending/movie/day")
    Call<Trending> getTrending(@Query("api_key") String key);
}
