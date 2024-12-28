package com.example.spacego.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacego.databaseaccess.SpaceRepo;
import com.example.spacego.databaseaccess.Space_Data;

import java.util.ArrayList;

public class SpaceViewmodel extends AndroidViewModel {
    private SpaceRepo spaceRepo;

    public SpaceViewmodel(@NonNull Application application) {
        super(application);
        spaceRepo = new SpaceRepo(application);
    }

    public LiveData<ArrayList<Space_Data>> getLiveData(String orgName){
        return spaceRepo.getOrgWise(orgName);
    }
}
