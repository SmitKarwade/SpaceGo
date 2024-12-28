package com.example.spacego.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Space_Data;
import com.google.android.material.textview.MaterialTextView;

public class TechnicalDetails extends Fragment {

    private Space_Data item;
    private MaterialTextView mass_text, agency_text;

    public TechnicalDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technical_details, container, false);
        mass_text = view.findViewById(R.id.mass_text);
        agency_text = view.findViewById(R.id.agency_text);
        if (getArguments() != null){
            item = getArguments().getParcelable("Item");
        }

        updateUI();
        return view;
    }

    private void updateUI() {
        if (item.getMassKg() != null){
            mass_text.setText(item.getMassKg().toString());
        }else {
            mass_text.setText("Unknown");
        }
        if (item.getFundingAgency() != null){
            agency_text.setText(item.getFundingAgency());
        }else {
            agency_text.setText("Unknown");
        }
    }
}