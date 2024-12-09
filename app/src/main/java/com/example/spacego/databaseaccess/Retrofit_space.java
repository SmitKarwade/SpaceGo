package com.example.spacego.databaseaccess;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_space {
    private static Retrofit retrofit = null;

    public static RetroService getRetrofitInst() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.10.35:8080")  // Use HTTP unless you're sure about HTTPS
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetroService.class);
    }
}
