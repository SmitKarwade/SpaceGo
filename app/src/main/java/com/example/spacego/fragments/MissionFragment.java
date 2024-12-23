package com.example.spacego.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.SpaceRepo;
import com.example.spacego.databaseaccess.Space_Data;
import com.example.spacego.modal.OrgWise;
import com.example.spacego.recylerview.Vertcial_Adapter;
import com.example.spacego.viewmodel.SpaceViewmodel;

import java.util.ArrayList;
import java.util.List;


public class MissionFragment extends Fragment {


    private RecyclerView recyclerView;
    private Vertcial_Adapter adapter;

    private OrgWise nasaOrgWise = new OrgWise("NASA", new ArrayList<>());
    private OrgWise esaOrgWise = new OrgWise("ESA", new ArrayList<>());
    private OrgWise isroOrgWise = new OrgWise("ISRO", new ArrayList<>());
    private OrgWise jaxaOrgWise = new OrgWise("JAXA", new ArrayList<>());
    private OrgWise roscosmosOrgWise = new OrgWise("ROSCOSMOS", new ArrayList<>());
    private OrgWise csaOrgWise = new OrgWise("CSA", new ArrayList<>());
    private OrgWise cnsaOrgWise = new OrgWise("CNSA", new ArrayList<>());
    private OrgWise uaeOrgWise = new OrgWise("UAE", new ArrayList<>());

    private ArrayList<OrgWise> orgWisesList = new ArrayList();


    private SpaceViewmodel viewmodel;

    public MissionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mission, container, false);
        recyclerView = view.findViewById(R.id.recyler_vertical);

        orgWisesList.add(nasaOrgWise);
        orgWisesList.add(esaOrgWise);
        orgWisesList.add(isroOrgWise);
        orgWisesList.add(jaxaOrgWise);
        orgWisesList.add(roscosmosOrgWise);
        orgWisesList.add(csaOrgWise);
        orgWisesList.add(cnsaOrgWise);
        orgWisesList.add(uaeOrgWise);

        adapter = new Vertcial_Adapter(getActivity(), orgWisesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        viewmodel = new ViewModelProvider(this).get(SpaceViewmodel.class);
        viewmodel.getLiveData("nasa").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(0).getListMisssion().clear();
                orgWisesList.get(0).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(0);
            }
        });


        viewmodel.getLiveData("esa").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(1).getListMisssion().clear();
                orgWisesList.get(1).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(1);
            }
        });

        viewmodel.getLiveData("isro").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {
                orgWisesList.get(2).getListMisssion().clear();
                orgWisesList.get(2).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(2);
            }
        });

        viewmodel.getLiveData("jaxa").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(3).getListMisssion().clear();
                orgWisesList.get(3).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(3);
            }
        });

        viewmodel.getLiveData("roscosmos").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(4).getListMisssion().clear();
                orgWisesList.get(4).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(4);
            }
        });

        viewmodel.getLiveData("csa").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(5).getListMisssion().clear();
                orgWisesList.get(5).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(5);
            }
        });

        viewmodel.getLiveData("cnsa").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(6).getListMisssion().clear();
                orgWisesList.get(6).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(6);
            }
        });

        viewmodel.getLiveData("uae").observe(getViewLifecycleOwner(), new Observer<ArrayList<Space_Data>>() {
            @Override
            public void onChanged(ArrayList<Space_Data> spaceData) {

                orgWisesList.get(7).getListMisssion().clear();
                orgWisesList.get(7).getListMisssion().addAll(spaceData);

                adapter.notifyItemChanged(7);
            }
        });

        return view;
    }

}