package com.invio.firstapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IServices {
    @GET("location")
    Call<Locations> getLocations();

    @GET
    Call<Character> getCharacter(@Url String data);
}
