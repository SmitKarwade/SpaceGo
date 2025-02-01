package com.example.spacego.databaseaccess;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpaceRepo {
    private RetroService retroService;
    private Context context;
    private Map<String, MutableLiveData<ArrayList<Space_Data>>> dataMap = new HashMap<>();
    private MutableLiveData<List<Cart>> cartItems = new MutableLiveData<>();
    List<Cart> list = new ArrayList<>();

    public SpaceRepo(Context context) {
        this.retroService = Retrofit_space.getRetrofitInst();
        this.context = context;
    }

    public MutableLiveData<ArrayList<Space_Data>> getOrgWise(String nameOfOrg) {
        if (!dataMap.containsKey(nameOfOrg)){
            dataMap.put(nameOfOrg, new MutableLiveData<>());
        }

        MutableLiveData<ArrayList<Space_Data>> dataArrayList = dataMap.get(nameOfOrg);
        Call<List<Space_Data>> call = retroService.getOrgData(nameOfOrg);
        call.enqueue(new Callback<List<Space_Data>>() {
            ArrayList<Space_Data> items = new ArrayList<>();
            @Override
            public void onResponse(Call<List<Space_Data>> call, Response<List<Space_Data>> response) {
                if (response.isSuccessful() && response.body() != null){
                    items = (ArrayList<Space_Data>) response.body();
//                    for (Space_Data mission : items){
//                        Toast.makeText(context, mission.getMissionName() , Toast.LENGTH_SHORT).show();
//                    }
                    dataArrayList.postValue(items);
                }else {
                    Toast.makeText(context, "Spring Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Space_Data>> call, Throwable throwable) {
                Toast.makeText(context, "get mission" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return dataArrayList;
    }

    public MutableLiveData<List<Cart>> getCartItems(){
        Call<List<Cart>> call = retroService.getCart();
        call.enqueue(new Callback<List<Cart>>() {

            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.isSuccessful() && response.body() != null){
                    list.clear();
                    list.addAll(response.body());
                    cartItems.postValue(list);
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable throwable) {
                Toast.makeText(context, "get cart" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return cartItems;
    }

    public void addToCart(Cart item){
        Call<Void> call = retroService.addToCart(item);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context, "queued", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Toast.makeText(context, "unable to queue", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void removeFromCart(Integer id){
        Call<String> call = retroService.removeFromCart(id);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
            }
        });
    }

    public void addUserDetails(UserDetails userDetails){
       Call<Void> call = retroService.addUserDetails(userDetails);
       call.enqueue(new Callback<Void>() {
           @Override
           public void onResponse(Call<Void> call, Response<Void> response) {
               if (userDetails != null){
                   Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(context, "Empty data", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<Void> call, Throwable throwable) {
               Toast.makeText(context, " " + throwable.getMessage().toString(), Toast.LENGTH_SHORT).show();
           }
       });
    }
}
