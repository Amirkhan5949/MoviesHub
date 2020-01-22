package com.example.moviehub.Network;

import com.example.moviehub.model.Credit;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CrewRequest {

    @GET("movie/{id}/credits")
    Call<Credit>getCrewRequest(@Path ("id") String id,@Query("api_key") String key);
}
