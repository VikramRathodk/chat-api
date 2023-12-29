package com.devvikram.chatapplication.Adapters;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devvikram.chatapplication.Models.Products;
import com.devvikram.chatapplication.R;

import java.util.List;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    Context context;
    Products[] products ;

    public ProductAdapter(Context context, Products[] products) {
        this.context = context;
        this.products = products;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productName.setText(products[position].getTitle());
        holder.productPrice.setText("$ "+products[position].getPrice());
        holder.productDesc.setText(products[position].getDescription());
        holder.productCategory.setText(products[position].getCategory());

        Log.d(TAG, "onBindViewHolder: "+products[position].getimage());


        Glide.with(context)
                .load(products[position].getimage())
                .centerCrop()
                .into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return products.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView productName,productDesc,productPrice,productCategory;
        ImageView productImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDesc = itemView.findViewById(R.id.productDesc);
            productCategory = itemView.findViewById(R.id.productCategory);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
