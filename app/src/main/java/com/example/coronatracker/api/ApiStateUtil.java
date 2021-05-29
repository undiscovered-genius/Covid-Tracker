package com.example.coronatracker.api;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiStateUtil {
    private static Retrofit retrofit = null;
    public   static ApiState getApiState(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiState.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiState.class);
    }
}
