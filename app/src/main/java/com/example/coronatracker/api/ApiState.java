package com.example.coronatracker.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiState {
    static final String BASE_URL = "https://api.covid19india.org/";

    @GET("data.json")
    Call<StateStats> getStateStats();
}
