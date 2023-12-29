package com.devvikram.chatapplication.Activites;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.devvikram.chatapplication.Adapters.ProductAdapter;
import com.devvikram.chatapplication.Models.Products;
import com.devvikram.chatapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductsActivity extends AppCompatActivity {

    public static final String url = "https://fakestoreapi.com/products";
    RecyclerView productRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productRecyclerview = findViewById(R.id.productRecyclerView);
        fetchDataFromUrl();
    }
    private void fetchDataFromUrl() {

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            Log.d(TAG, "onResponse: "+response);

            GsonBuilder builder = new GsonBuilder();
            Gson gson =  builder.create();

            Products[] productss = gson.fromJson(response,Products[].class);

            productRecyclerview.setLayoutManager(new LinearLayoutManager(ProductsActivity.this));

            ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(),productss);
            productRecyclerview.setAdapter(productAdapter);

        }, error -> Toast.makeText(ProductsActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}