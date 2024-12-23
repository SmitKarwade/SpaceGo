package com.example.spacego.recylerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Space_Data;
import com.example.spacego.modal.OrgWise;

import java.util.ArrayList;
import java.util.List;

public class Vertcial_Adapter extends RecyclerView.Adapter<Vertcial_Adapter.Vertical_Viewholder> {

    private Context context;
    private ArrayList<OrgWise> orgWiseList;

    public Vertcial_Adapter(Context context, ArrayList<OrgWise> orgWiseList) {
        this.context = context;
        this.orgWiseList = orgWiseList;
    }

    @NonNull
    @Override
    public Vertical_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vertical_items, parent, false);
        return new Vertical_Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vertical_Viewholder holder, int position) {
        OrgWise orgWiseItem = orgWiseList.get(position);
        holder.textView.setText(orgWiseItem.getOrg());

        // Update the data of the existing Horizontal_adapter
        holder.horizontalAdapter.UpdateData(orgWiseItem.getListMisssion());
        Log.d("reycle", "onBindViewHolder: " + orgWiseItem.getListMisssion().size() + "  " + orgWiseList.get(0).getListMisssion().size());
    }

    @Override
    public int getItemCount() {
        return orgWiseList.size();
    }

    public static class Vertical_Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        Horizontal_adapter horizontalAdapter; // Store the adapter here

        public Vertical_Viewholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.materialTextView);
            recyclerView = itemView.findViewById(R.id.horizontal_recycler);

            // Create the Horizontal_adapter only once in the constructor
            horizontalAdapter = new Horizontal_adapter(itemView.getContext(), new ArrayList<>());
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            recyclerView.setAdapter(horizontalAdapter);
        }
    }
}