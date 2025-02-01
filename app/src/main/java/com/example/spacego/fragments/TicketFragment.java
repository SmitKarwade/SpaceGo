package com.example.spacego.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Cart;
import com.example.spacego.recylerview.CartAdapter;
import com.example.spacego.viewmodel.SpaceViewmodel;

import java.util.ArrayList;
import java.util.List;

public class TicketFragment extends Fragment {
    private SpaceViewmodel viewmodel;
    List<Cart> cartList = new ArrayList<>();
    private RecyclerView cartRecylerView;
    private CartAdapter cartAdapter;

    public TicketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);

        cartRecylerView = view.findViewById(R.id.cartRecylerView);
        cartAdapter = new CartAdapter(cartList, getActivity());
        cartRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        cartRecylerView.setHasFixedSize(true);
        cartRecylerView.setAdapter(cartAdapter);


        viewmodel = new ViewModelProvider(requireActivity()).get(SpaceViewmodel.class);
        viewmodel.getLiveCart().observe(getActivity(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartList.clear();
                cartList.addAll(carts);
                cartAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }


}