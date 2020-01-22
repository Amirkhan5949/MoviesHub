package com.example.moviehub.Network;

import com.example.moviehub.model.DiscoverGenre;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DiscoverRequest {

    @GET("discover/movie")
    Call<DiscoverGenre>getDiscover(@Query("api_key") String key,@Query("with_genres")String with_genres);
}
