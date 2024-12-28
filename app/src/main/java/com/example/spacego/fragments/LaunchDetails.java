package com.example.spacego.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Space_Data;
import com.google.android.material.textview.MaterialTextView;

public class LaunchDetails extends Fragment {

    private Space_Data item;
    private MaterialTextView launch_date_text, launch_site_text, vehicle_text;

    public LaunchDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_launch_details, container, false);
        launch_date_text = view.findViewById(R.id.launch_date_text);
        launch_site_text = view.findViewById(R.id.launch_site_text);
        vehicle_text = view.findViewById(R.id.vehicle_text);

        if (getArguments() != null){
            item = getArguments().getParcelable("Item");
        }

        updateUI();
        return view;
    }

    private void updateUI() {
        if (item.getLaunchSite() != null){
            launch_site_text.setText(item.getLaunchSite());
        }else {
            launch_site_text.setText("Unknown");
        }

        if (item.getLaunchDate() != null){
            launch_date_text.setText(item.getLaunchDate());
        }else {
            launch_date_text.setText("Unknown");
        }

        if (item.getLaunchDate() != null){
            vehicle_text.setText(item.getVehicle());
        }else {
            vehicle_text.setText("Unknown");
        }
    }
}