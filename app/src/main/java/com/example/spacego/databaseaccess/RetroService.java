package com.example.spacego.databaseaccess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroService {
    @GET("/missions")
    Call<List<Space_Data>> getMissions();
}
