package com.example.moviehub.network;

import com.example.moviehub.model.SearchByName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRequest {

    @GET("search/movie")
    Call<SearchByName> searchMovie(@Query("page") String page, @Query("query")String query, @Query("api_key")String key);


    @GET("search/tv")
    Call<SearchByName> searchTv(@Query("page") String page, @Query("query")String query, @Query("api_key")String key);

    @GET("search/person")
    Call<SearchByName> searchPerson(@Query("page") String page, @Query("query")String query, @Query("api_key")String key);


}
