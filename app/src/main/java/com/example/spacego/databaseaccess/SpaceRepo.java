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
                Toast.makeText(context, "get " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return dataArrayList;
    }
}
