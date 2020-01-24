package com.example.moviehub.Network;

import com.example.moviehub.model.PersonImages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonImagesRequest {
    @GET("person/{personid}/images")
    Call<PersonImages>getPersonImgRequest(@Path ("personid")String id,@Query("api_key")String key);
}
