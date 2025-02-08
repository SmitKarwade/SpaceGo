package com.example.spacego.databaseaccess;

import com.example.spacego.payment.OrderResponse;
import com.example.spacego.payment.VerifyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @GET("/form/users/get")
    Call<List<UserDetails>> getUsers();

    @POST("/form/add")
    Call<Void> addUserDetails(@Body UserDetails userDetails);

    @FormUrlEncoded
    @POST("/api/payment/create-order")
    Call<OrderResponse> createOrder(@Field("amount") double amount);

    @FormUrlEncoded
    @POST("/api/payment/verify-payment")
    Call<VerifyResponse> verifyPayment(
            @Field("paymentId") String paymentId,
            @Field("orderId") String orderId,
            @Field("signature") String signature
    );
}
