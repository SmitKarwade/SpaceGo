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

public class TimeDetails extends Fragment {

    private Space_Data item;
    private MaterialTextView public_text, time_text;

    public TimeDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            item = getArguments().getParcelable("Item");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_time_details, container, false);
        public_text = view.findViewById(R.id.public_text);
        time_text = view.findViewById(R.id.time_text);

        updateUI();
        return view;
    }

    private void updateUI() {
        public_text.setText(item.getPublicAvailability());
        time_text.setText(item.getTime());
    }


}