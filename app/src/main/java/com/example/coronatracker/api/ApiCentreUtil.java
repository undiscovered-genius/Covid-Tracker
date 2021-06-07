package com.example.coronatracker.api;

import com.example.coronatracker.CentreActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCentreUtil {
    private static Retrofit retrfit = null;
    public static ApiCentre getApiCentre() {
        if (retrfit == null) {
            retrfit = new Retrofit.Builder()
                    .baseUrl(ApiCentre.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrfit.create(ApiCentre.class);
    }
}
