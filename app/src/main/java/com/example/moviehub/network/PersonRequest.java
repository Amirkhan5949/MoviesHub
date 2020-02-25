package com.example.moviehub.network;

import com.example.moviehub.model.PersonDetail;
import com.example.moviehub.model.PersonImages;
import com.example.moviehub.model.PersonMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonRequest {

    @GET("person/{personid}")
    Call<PersonDetail>getPersondetail(@Path ("personid")String id,@Query("api_key")String key);


    @GET("person/{personid}/images")
    Call<PersonImages>getPersonImgRequest(@Path ("personid")String id, @Query("api_key")String key);


    @GET("person/{id}/movie_credits")
    Call<PersonMovies>getPersonMovieTvshowRequest(@Path ("id")String id, @Query("api_key")String key);


    @GET("person/{id}/tv_credits")
    Call<PersonMovies>getPersonTvshow(@Path ("id")String id, @Query("api_key")String key);
}
