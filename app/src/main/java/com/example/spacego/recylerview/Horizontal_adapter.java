package com.example.spacego.recylerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacego.MainActivity;
import com.example.spacego.R;
import com.example.spacego.databaseaccess.Space_Data;
import com.example.spacego.fragments.MissionFragment;
import com.example.spacego.missiondata.FullDataActivity;
import com.example.spacego.viewmodel.SpaceViewmodel;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class Horizontal_adapter extends RecyclerView.Adapter<Horizontal_adapter.HorizontalViewholder>{

    private Context context;
    private List<Space_Data> arrayList;

    public Horizontal_adapter(Context context, List<Space_Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.horizontal_items, parent, false);
        return new HorizontalViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewholder holder, int position) {
        Space_Data item = arrayList.get(position);
        if (item == null){
            Toast.makeText(context, "Item is null ", Toast.LENGTH_SHORT).show();
        }
        holder.missionNameText.setText(item.getMissionName());
        holder.launchText.setText(item.getTime());
        holder.publicMark.setText(item.getPublicAvailability());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FullDataActivity.class);
            intent.putExtra("Item", item);
            Log.d("Item", item.getMissionName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void UpdateData(List<Space_Data> newData) {
        arrayList.clear();
        arrayList.addAll(newData);
        notifyItemRangeChanged(0, newData.size());
    }

    public static class HorizontalViewholder extends RecyclerView.ViewHolder{
        private ShapeableImageView imgSpace;
        private MaterialTextView missionNameText, launchText, publicMark;


        public HorizontalViewholder(@NonNull View itemView) {
            super(itemView);

            imgSpace = itemView.findViewById(R.id.imgSpace);
            missionNameText = itemView.findViewById(R.id.missionNameText);
            launchText = itemView.findViewById(R.id.launchText);
            publicMark = itemView.findViewById(R.id.publicMark);
        }
    }
}
