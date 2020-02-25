package com.example.moviehub.network;

import com.example.moviehub.model.PersonExternalDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Externalids {
    @GET("person/{person_id}/external_ids")
    Call<PersonExternalDetail>getExternal(@Path ("person_id")String id, @Query("api_key") String key);


}
