package com.example.spacego.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Cart;
import com.example.spacego.databaseaccess.Space_Data;
import com.example.spacego.missiondata.FullDataActivity;
import com.example.spacego.viewmodel.SpaceViewmodel;
import com.google.android.material.textview.MaterialTextView;

public class MissionDetails extends Fragment {

    private MaterialTextView msn_name_text, org_name_text, summary_text, desc_text;
    private Space_Data item;

    public MissionDetails() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mission_details, container, false);
        msn_name_text = view.findViewById(R.id.msn_name_text);
        org_name_text = view.findViewById(R.id.org_name_text);
        summary_text = view.findViewById(R.id.summary_text);
        desc_text = view.findViewById(R.id.desc_text);

        if (getArguments() != null){
            item = getArguments().getParcelable("Item");
            Log.d("Item", item.getMissionName());
            updateUI();
        }
        return view;
    }

    public void updateUI(){
        msn_name_text.setText(item.getMissionName());
        org_name_text.setText(item.getOrganization());
        summary_text.setText(item.getSummary());
        desc_text.setText(item.getDescription());
    }

    public Cart getCartData(){
        Cart cart = new Cart(item.getId(), item.getMissionName(), item.getOrganization(), item.getSummary(), item.getAmountRS());
        return cart;
    }
}