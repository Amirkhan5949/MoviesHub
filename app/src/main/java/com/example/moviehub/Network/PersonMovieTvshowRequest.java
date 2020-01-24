package com.example.moviehub.Network;

import com.example.moviehub.model.PersonMoviesTvshow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonMovieTvshowRequest {

    @GET("person/3061/movie_credits")
    Call<PersonMoviesTvshow>getPersonMovieTvshowRequest(@Query("api_key")String key);
}


