package com.example.moviehub.Network;

import com.example.moviehub.model.PersonDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonDetailReuest {

    @GET("person/{personid}")
    Call<PersonDetail>getPersondetail(@Path ("personid")String id,@Query("api_key")String key);

}
