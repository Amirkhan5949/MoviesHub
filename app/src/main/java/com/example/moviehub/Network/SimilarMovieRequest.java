package com.example.moviehub.Network;

import com.example.moviehub.model.SimilarMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SimilarMovieRequest {
    @GET("movie/331482/similar")
    Call<SimilarMovie>getsimilarmovie(@Query("api_key") String key);

}
