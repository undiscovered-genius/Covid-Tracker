package com.example.coronatracker.api;

import retrofit2.Call;
import retrofit2.http.GET;
    public interface ApiCentre {
    static final String BASE_URL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/";

    @GET("findByPin?pincode=411014&date=07-06-2021")
    Call<CentreStats> getCentreStats();
}
