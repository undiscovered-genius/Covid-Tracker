package com.example.coronatracker.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCentre {
    static final String BASE_URL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/";

    @GET("findByPin")
    Call<CentreStats> getCentreStats(@Query("pincode") String pin, @Query("date") String dt);
}
