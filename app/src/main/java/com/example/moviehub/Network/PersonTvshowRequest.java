package com.example.moviehub.Network;

import com.example.moviehub.model.PersonMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonTvshowRequest {

    @GET("person/{id}/tv_credits")
    Call<PersonMovies>getPersonTvshow(@Path ("id")String id, @Query("api_key")String key);
}
