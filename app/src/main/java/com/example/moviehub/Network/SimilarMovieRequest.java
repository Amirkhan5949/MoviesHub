package com.example.moviehub.Network;

import com.example.moviehub.model.SimilarMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SimilarMovieRequest {
    @GET("movie/{id}/similar")
    Call<SimilarMovie>getsimilarmovie(@Path ("id")String id,@Query("api_key") String key);

}
