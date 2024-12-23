package com.example.spacego.databaseaccess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroService {
    @GET("/missions")
    Call<List<Space_Data>> getMissions();

    @GET("/missions/organizations")
    Call<List<Space_Data>> getOrgData(@Query("organization") String organization);
}
