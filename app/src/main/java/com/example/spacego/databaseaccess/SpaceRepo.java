package com.example.spacego.databaseaccess;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpaceRepo {
    private RetroService retroService;
    private Context context;

    public SpaceRepo(Context context) {
        this.retroService = Retrofit_space.getRetrofitInst();
        this.context = context;
    }

    public void getAllMissions() {
        Call<List<Space_Data>> call = retroService.getMissions();
        call.enqueue(new Callback<List<Space_Data>>() {
            @Override
            public void onResponse(Call<List<Space_Data>> call, Response<List<Space_Data>> response) {
                if (response.isSuccessful() && response.body() != null){
                    List<Space_Data> items = response.body();
                    for (Space_Data mission : items){
                        Toast.makeText(context, mission.getMissionName() , Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Space_Data>> call, Throwable throwable) {
                Toast.makeText(context, "get " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
