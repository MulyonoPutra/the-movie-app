package com.example.themovieapp.retrofit;

import com.example.themovieapp.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<ResponseMovie> getDataMovie (
            @Query("api_key") String apiKey
    );
}



