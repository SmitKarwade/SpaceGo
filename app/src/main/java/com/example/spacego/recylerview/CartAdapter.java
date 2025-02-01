package com.example.spacego.recylerview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.text.SpannedString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.Cart;
import com.example.spacego.databaseaccess.SpaceRepo;
import com.example.spacego.payment.ClientDetailsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

            holder.addBtn.setOnClickListener(v -> {
                View dialogView = LayoutInflater.from(context).inflate(R.layout.agreement_layout, null);

                TextView termsTextView = dialogView.findViewById(R.id.termsTextView);
                MaterialCheckBox agreeCheckbox = dialogView.findViewById(R.id.agreeCheckbox);

                Spanned formattedMessage = Html.fromHtml(context.getString(R.string.agreement), Html.FROM_HTML_MODE_LEGACY);
                termsTextView.setText(formattedMessage);

                // Build the dialog
                new MaterialAlertDialogBuilder(context)
                        .setTitle("Terms and Conditions")
                        .setView(dialogView) // Set the custom view
                        .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                        .setPositiveButton("Continue", (dialog, which) -> {
                            // Get the checkbox state
                            boolean isChecked = agreeCheckbox.isChecked();
                            if (isChecked) {
                                // Checkbox is checked, proceed
                                Intent intent = new Intent(context, ClientDetailsActivity.class);
                                context.startActivity(intent);
                            } else {
                                Toast.makeText(context, "You must agree to the Terms and Conditions to continue.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            });

            holder.removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spaceRepo.removeFromCart(item.getCartId());
                    list.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
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
