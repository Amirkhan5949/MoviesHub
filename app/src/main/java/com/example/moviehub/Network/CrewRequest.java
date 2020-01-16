package com.example.moviehub.Network;

import com.example.moviehub.model.Credit;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CrewRequest {

    @GET("movie/331482/credits")
    Call<Credit>getCrewRequest(@Query("api_key") String key);
}
