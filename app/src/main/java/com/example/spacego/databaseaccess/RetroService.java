package com.example.spacego.databaseaccess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetroService {
    @GET("/missions")
    Call<List<Space_Data>> getMissions();

    @GET("/missions/organizations")
    Call<List<Space_Data>> getOrgData(@Query("organization") String organization);

    @GET("/cart/list")
    Call<List<Cart>> getCart();

    @POST("/cart/addMission")
    Call<Void> addToCart(@Body Cart item);

    @DELETE("/cart/removeMission")
    Call<String> removeFromCart(@Query("id") Integer id);  // ResponseBody if object expected
}
