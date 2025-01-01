package com.example.spacego.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Cart;
import com.example.spacego.databaseaccess.SpaceRepo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewholder>{

    private List<Cart> list;
    private Context context;
    private SpaceRepo spaceRepo;

    public CartAdapter(List<Cart> list, Context context) {
        this.list = list;
        this.context = context;
        spaceRepo = new SpaceRepo(context);
    }

    @NonNull
    @Override
    public CartViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewholder holder, int position) {
        Cart item = list.get(position);
        if (item != null){
            holder.cartMissionName.setText(item.getMissionName());
            holder.cartMissionSummary.setText(item.getMissionSummary());
            holder.cartMissionAmt.setText(item.getAmountRS().toString());
            holder.cartOrg.setText(item.getMissionOrg());

            holder.addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "AddButton", Toast.LENGTH_SHORT).show();
                }
            });

            holder.removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "RemoveButton", Toast.LENGTH_SHORT).show();
                    spaceRepo.removeFromCart(item.getCartId());
                    notifyDataSetChanged();
                    Toast.makeText(context, "" + list.size(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CartViewholder extends RecyclerView.ViewHolder {
        ShapeableImageView org_img;
        MaterialTextView cartMissionName, cartMissionSummary, cartMissionAmt, cartOrg;
        MaterialButton removeBtn, addBtn;

        public CartViewholder(@NonNull View itemView) {
            super(itemView);

            org_img = itemView.findViewById(R.id.org_img);
            cartMissionName = itemView.findViewById(R.id.cartMissionName);
            cartMissionSummary = itemView.findViewById(R.id.cartMissionSummary);
            cartMissionAmt = itemView.findViewById(R.id.cartMissionAmt);
            cartOrg = itemView.findViewById(R.id.cartOrg);
            removeBtn = itemView.findViewById(R.id.removeBtn);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
